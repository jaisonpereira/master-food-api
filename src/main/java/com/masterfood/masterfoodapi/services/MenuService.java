package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.dto.MenuDto;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private RestaurantService serviceRestaurant;

    @Autowired
    public MenuService(RestaurantService serviceRestaurant) {
        this.serviceRestaurant = serviceRestaurant;
    }

    public void save(MenuDto dto, String restaurantId) {
        Restaurant restaurant = serviceRestaurant.findById(restaurantId);
        restaurant.setMenu(dto.getMenu());
        serviceRestaurant.save(restaurant);
    }

    public MenuDto findById(String id) {
        return new MenuDto(serviceRestaurant.findById(id));
    }

}
