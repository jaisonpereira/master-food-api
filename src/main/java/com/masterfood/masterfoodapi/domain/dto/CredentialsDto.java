package com.masterfood.masterfoodapi.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CredentialsDto implements Serializable {

    private static final long serialVersionUID = -8016427621602434257L;

    private String email;
    private String password;

}
