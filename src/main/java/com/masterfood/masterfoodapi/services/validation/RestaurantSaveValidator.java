package com.masterfood.masterfoodapi.services.validation;

import com.masterfood.masterfoodapi.domain.dto.RestaurantDto;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.repository.RestaurantRepository;
import com.wirelabs.utils.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RestaurantSaveValidator implements ConstraintValidator<RestaurantSaveValid, RestaurantDto> {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public void initialize(RestaurantSaveValid ann) {
        // Unnecessary implementation
    }

    @Override
    public boolean isValid(RestaurantDto objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        List<Restaurant> aux = repository.findByEmail(objDto.getEmail());
        if (aux != null && !aux.isEmpty() && !aux.get(0)
                .getId()
                .equals(objDto.getId())) {
            list.add(new FieldMessage("email", "restaurant.email.already"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
