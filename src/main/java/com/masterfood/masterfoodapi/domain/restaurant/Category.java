package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.BaseProductControl;
import com.masterfood.masterfoodapi.domain.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseProductControl implements Serializable {

    private static final long serialVersionUID = -555849179487885922L;

    @NotEmpty(message = "restaurant.required.categoryName")
    @Length(min = 3, max = 55, message = "the category name lenght must between 3 until 55")
    private String name;
    private Integer categoryType;
    private List<Product> products;
    private List<SizeProduct> sizes;
    private List<BorderPasta> borders;
    private List<FlavorProduct> flavors;

    @Transient
    public CategoryType getCategory() {
        return CategoryType.getCategoryByValue(this.categoryType);
    }

}
