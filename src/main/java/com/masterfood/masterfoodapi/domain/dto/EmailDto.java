package com.masterfood.masterfoodapi.domain.dto;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.Email;

@Data
public class EmailDto implements Serializable {

    private static final long serialVersionUID = 4772842801673052915L;
    @Email(message = "basic.email.invalid")
    private String email;

}
