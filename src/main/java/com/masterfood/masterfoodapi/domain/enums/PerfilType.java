package com.masterfood.masterfoodapi.domain.enums;

public enum PerfilType {

    ROOT(1, "ROLE_ROOT"), CLIENT(2, "ROLE_CLIENT"), ADMIN(3, "ROLE_ADMIN"), CUSTOMERS(4, "ROLE_CUSTOMERS");

    private int cod;
    private String descricao;

    private PerfilType(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PerfilType toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (PerfilType x : PerfilType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id Invalid: " + cod);
    }

}