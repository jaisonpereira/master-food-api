package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import com.wirelabs.common.utils.LengthControl;
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
    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "product" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String name;
    @Length(min = LengthControl.DESC_MIN_LENGTH,
            max = LengthControl.DESC_MAX_LENGTH,
            message = "product" + LengthControl.DESC_DEFAULT_MESSAGE)
    private String description;
    @NotNull(message = "restaurant.required.product.price")
    private BigDecimal price;
    private List<CategoryComplement> categoriesComplement;

}
