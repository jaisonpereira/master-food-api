package com.masterfood.masterfoodapi.domain.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = -1296143207247613640L;

    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private Integer ordination;

}
