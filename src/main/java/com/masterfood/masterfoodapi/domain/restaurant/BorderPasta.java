package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
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
public class BorderPasta extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -1300429575050241135L;

    @NotEmpty(message = "restaurant.required.categoryName")
    @Length(min = 3, max = 55, message = "the border  name lenght must between 3 until 55")
    private String name;
    private BigDecimal price;

}
