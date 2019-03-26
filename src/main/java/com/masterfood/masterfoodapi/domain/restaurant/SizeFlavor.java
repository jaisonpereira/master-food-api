package com.masterfood.masterfoodapi.domain.restaurant;

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
public class SizeFlavor implements Serializable {

    private static final long serialVersionUID = 6529290627655856945L;
    @NotEmpty(message = "menu.required.sizeFlavorName")
    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "SizeFlavor" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String name;

    @NotNull(message = "menu.required.priceSizeFlavor")
    private BigDecimal price;

    protected int ordination;
}
