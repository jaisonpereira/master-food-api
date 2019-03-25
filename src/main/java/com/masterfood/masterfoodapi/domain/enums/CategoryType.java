package com.masterfood.masterfoodapi.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryType {

    DEFAULT(1), PIZZA(2);

    private Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    CategoryType(int tipo) {
        this.value = tipo;
    }

    @JsonCreator
    public static CategoryType getCategoryByValue(final int value) {
        for (final CategoryType category : CategoryType.values()) {
            if (category.value == value) {
                return category;
            }
        }
        return null;
    }
}
