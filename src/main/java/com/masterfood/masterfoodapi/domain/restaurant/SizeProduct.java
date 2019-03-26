package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import com.masterfood.masterfoodapi.domain.enums.FlavorQuantityType;
import com.wirelabs.common.utils.LengthControl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeProduct extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -4334558657793622534L;

    @NotEmpty(message = "menu.required.sizeProductName")
    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "SizeProduct" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String name;
    private List<FlavorQuantityType> flavorsQuantity;

}
