package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = -555849179487885922L;

    private String name;
    private CategoryType categoryType;
    private List<Product> products;
    private Integer ordination;
    private boolean active;

}
