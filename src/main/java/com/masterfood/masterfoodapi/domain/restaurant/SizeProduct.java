package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import com.masterfood.masterfoodapi.domain.enums.FlavorQuantityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeProduct extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -4334558657793622534L;

    @NotEmpty(message = "restaurant.required.categoryName")
    @Length(min = 3, max = 55, message = "the size  name lenght must between 3 until 55")
    private String name;
    private List<FlavorQuantityType> flavorsQuantity;
    private BigDecimal price;

}
