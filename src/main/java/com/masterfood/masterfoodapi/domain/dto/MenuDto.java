package com.masterfood.masterfoodapi.domain.dto;

import com.masterfood.masterfoodapi.domain.restaurant.Category;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.services.validation.MenuSaveValid;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@MenuSaveValid
public class MenuDto implements Serializable {

    private static final long serialVersionUID = 5164843847969031192L;

    public MenuDto(Restaurant rest) {
        this.menu = rest.getMenu();
    }

    @NotNull(message = "menu is required")
    private List<Category> menu;
}
