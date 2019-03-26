package com.masterfood.masterfoodapi.domain.dto;

import com.masterfood.masterfoodapi.domain.Address;
import com.masterfood.masterfoodapi.domain.restaurant.Category;
import com.masterfood.masterfoodapi.services.validation.RestaurantSaveValid;
import com.wirelabs.common.utils.LengthControl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Length(min = LengthControl.DESC_MIN_LENGTH,
            max = LengthControl.DESC_MAX_LENGTH,
            message = "tradingName" + LengthControl.DESC_DEFAULT_MESSAGE)
    private String tradingName;
    // razaoSocial
    @NotEmpty(message = "restaurant.required.companyName")
    @Length(min = LengthControl.DESC_MIN_LENGTH,
            max = LengthControl.DESC_MAX_LENGTH,
            message = "company name" + LengthControl.DESC_DEFAULT_MESSAGE)
    private String companyName;
    private Address address;

    @Email(message = "basic.email.invalid")
    @Length(min = LengthControl.NAME_MIN_LENGTH,
            max = LengthControl.NAME_MAX_LENGTH,
            message = "email" + LengthControl.NAME_DEFAULT_MESSAGE)
    private String email;
    @NotEmpty(message = "restaurant.required.description")

    @Length(min = LengthControl.DESC_MIN_LENGTH,
            max = LengthControl.FULL_DESC_MAX_LENGTH,
            message = "description restaurant" + LengthControl.DEFAULT_MESSAGE + LengthControl.FULL_DESC_MAX_LENGTH)
    private String description;
    @NotNull(message = "restaurant.required.timeEstimate")
    private Double timeEstimate;
    private Float priceMinimum;
    private Float rating;
    private List<Category> menu;
    private LocalDateTime syncDate;

}