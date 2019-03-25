package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -1296143207247613640L;

    @NotEmpty(message = "restaurant.required.product.name")
    @Length(min = 3, max = 55, message = "the product name lenght must between 3 until 55")
    private String name;
    @Length(min = 3, max = 80, message = "the product name lenght must between 3 until 80")
    private String description;
    @NotNull(message = "restaurant.required.product.price")
    private BigDecimal price;
    private List<CategoryComplement> categoriesComplement;

}
