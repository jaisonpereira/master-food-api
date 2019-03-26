package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import com.wirelabs.common.utils.LengthControl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorderPasta extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -1300429575050241135L;

    @NotEmpty(message = "menu.required.borderName")
    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "border or pasta" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String name;
    @NotNull(message = "menu.required.priceBorder")
    private BigDecimal price;

}
