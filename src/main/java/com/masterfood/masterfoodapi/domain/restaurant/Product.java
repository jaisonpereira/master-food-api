package com.masterfood.masterfoodapi.domain.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = -1296143207247613640L;

    private String name;
    private String describe;
}
