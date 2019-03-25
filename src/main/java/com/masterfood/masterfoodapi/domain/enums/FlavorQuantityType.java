package com.masterfood.masterfoodapi.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FlavorQuantityType {

    TWO(2), THREE(3), FOUR(4);

    private Integer value;

    @JsonValue
    public Integer getTipo() {
        return value;
    }

    FlavorQuantityType(int tipo) {
        this.value = tipo;
    }

    @JsonCreator
    public static FlavorQuantityType getFlavorQuantityByValue(final int value) {
        for (final FlavorQuantityType flavor : FlavorQuantityType.values()) {
            if (flavor.value == value) {
                return flavor;
            }
        }
        return null;
    }

}
