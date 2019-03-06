package com.masterfood.masterfoodapi.domain.enums;

public enum PerfilType {

    ADMIN(1, "ROLE_ADMIN"), CLIENT(2, "ROLE_CLIENT");

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