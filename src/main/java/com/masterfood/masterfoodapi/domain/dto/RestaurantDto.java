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
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestaurantSaveValid
public class RestaurantDto implements Serializable {

    private static final long serialVersionUID = 2783865037302789407L;

    private String id;
    // nome fantasia
    @NotEmpty(message = "restaurant.required.tradingName")
    @Length(min = 3, max = 80, message = "the tradingName lenght must between 3 until 80")
    private String tradingName;
    // razaoSocial
    @NotEmpty(message = "restaurant.required.companyName")
    @Length(min = 3, max = 80, message = "the companyName lenght must between 3 until 80")
    private String companyName;
    private Address address;
    @Email(message = "restaurant.email.invalid")
    private String email;
    @NotEmpty(message = "restaurant.required.description")
    @Length(min = 3, max = 80, message = "the description lenght must between 3 until 80")
    private String description;
    @NotNull(message = "restaurant.required.timeEstimate")
    private Double timeEstimate;
    private Float priceMinimum;
    private Float rating;
    private List<Category> menu;

}