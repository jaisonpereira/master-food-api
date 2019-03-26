package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
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
public class FlavorProduct extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -4075564447100870054L;

    @NotEmpty(message = "restaurant.required.categoryName")

    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "Flavor Product" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String name;

    @Length(min = LengthControl.DESC_MIN_LENGTH,
            max = LengthControl.DESC_MAX_LENGTH,
            message = "product" + LengthControl.DESC_DEFAULT_MESSAGE)
    private String decription;
    private List<SizeFlavor> sizes;

}
