package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryComplement extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = 3337232582860004341L;
    @NotEmpty(message = "restaurant.required.product.name")
    @Length(min = 3, max = 55, message = "the product name lenght must between 3 until 55")
    private String name;
    private List<Product> products;
    private Integer quantityMin;
    private Integer quantityMax;
    private boolean required;

}
