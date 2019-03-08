package com.masterfood.masterfoodapi.domain.dto;

import com.masterfood.masterfoodapi.domain.Address;
import com.masterfood.masterfoodapi.domain.restaurant.Category;
import com.masterfood.masterfoodapi.services.validation.RestaurantSaveValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestaurantSaveValid
public class RestaurantDto implements Serializable {

    private static final long serialVersionUID = 2783865037302789407L;

    private String id;
    @NotEmpty(message = "name is required")
    @Length(min = 3, max = 80, message = "the name lenght must between 3 until 80")
    private String name;
    private Address address;
    @Email(message = "Email invalid")
    private String email;
    private String describe;
    @NotEmpty(message = "time estimate is required")
    private Double timeEstimate;
    private Float priceMinimum;
    private Float rating;
    private List<Category> menu;

}