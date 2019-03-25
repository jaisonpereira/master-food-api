package com.masterfood.masterfoodapi.services.validation;

import com.masterfood.masterfoodapi.domain.dto.MenuDto;
import com.masterfood.masterfoodapi.domain.restaurant.Category;
import com.masterfood.masterfoodapi.domain.restaurant.CategoryComplement;
import com.masterfood.masterfoodapi.domain.restaurant.Product;
import com.wirelabs.common.utils.NumberManager;
import com.wirelabs.utils.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MenuSaveValidator implements ConstraintValidator<MenuSaveValid, MenuDto> {

    @Autowired
    private NumberManager numberManager;

    @Override
    public void initialize(MenuSaveValid ann) {
        // Unnecessary implementation
    }

    public void validateCategoryComplement(List<CategoryComplement> categoriesComplement, List<FieldMessage> list) {
        if (categoriesComplement != null && !categoriesComplement.isEmpty()) {
            categoriesComplement.forEach(categoryComplement -> {
                if (categoryComplement != null && !numberManager.isNullOrZero(categoryComplement.getQuantityMin()) &&
                        !numberManager.isNullOrZero(categoryComplement.getQuantityMax()) &&
                        categoryComplement.getQuantityMin() > categoryComplement.getQuantityMax()) {
                    list.add(new FieldMessage("quantityMin", "menu.quantitymin"));
                }

            });
        }
    }

    public void validateProducts(List<Product> products, List<FieldMessage> list) {
        if (products != null && !products.isEmpty()) {
            products.stream()
                    .forEach(product -> this.validateCategoryComplement(product.getCategoriesComplement(), list));
        }
    }

    public void validateMenu(List<Category> menu, List<FieldMessage> list) {
        if (menu != null && !menu.isEmpty()) {
            menu.forEach(category -> this.validateProducts(category.getProducts(), list));
        }
    }

    @Override
    public boolean isValid(MenuDto dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        this.validateMenu(dto.getMenu(), list);
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
