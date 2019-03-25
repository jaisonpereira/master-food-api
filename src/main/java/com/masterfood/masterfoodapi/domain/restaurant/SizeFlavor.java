package com.masterfood.masterfoodapi.domain.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeFlavor implements Serializable {

    private static final long serialVersionUID = 6529290627655856945L;
    @NotEmpty(message = "restaurant.required.categoryName")
    @Length(min = 3, max = 55, message = "the sizeFlavor  name lenght must between 3 until 55")
    private String name;

    private BigDecimal price;

    protected int ordination;
}
