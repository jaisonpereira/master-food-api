package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import com.wirelabs.common.utils.LengthControl;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryComplement extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = 3337232582860004341L;
    @NotEmpty(message = "menu.required.categoryCompName")
    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "category complement" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String name;
    private List<Product> products;
    private Integer quantityMin;
    private Integer quantityMax;
    private boolean required;

}
