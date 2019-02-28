package com.masterfood.masterfoodapi.domain.enums;

import lombok.Getter;

public enum CategoryType {

    COMUN(1), PIZZA(2);

    @Getter
    private Integer tipo;

    CategoryType(int tipo) {
        this.tipo = tipo;
    }

}
