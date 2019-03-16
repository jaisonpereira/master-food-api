package com.masterfood.masterfoodapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 6632240962664247601L;

    @NotEmpty(message = "restaurant.required.categoryName")
    @Length(min = 3, max = 25, message = "the category name lenght must between 3 until 80")
    private String name;
    private Integer categoryType;
    @NotNull()
    private Integer ordination;

}