package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
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
    @Length(min = 3, max = 55, message = "the size  name lenght must between 3 until 55")
    private String name;
    private String decription;
    private List<SizeFlavor> sizes;

}
