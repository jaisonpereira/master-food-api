package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.dto.RestaurantDto;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.repository.RestaurantRepository;
import com.masterfood.masterfoodapi.security.UserSecurity;
import com.wirelabs.exceptions.AuthorizationException;
import com.wirelabs.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    private UserService serviceUser;

    private void allowedUserResource(String id) {
        UserSecurity user = UserService.authenticated();
        if (!user.getRestaurantId()
                .equals(id) && user.allowedToFindRestaurant()) {
            throw new AuthorizationException("Restaurant not allowed to user " + user.getId());
        }
    }

    @Autowired
    public RestaurantService(RestaurantRepository repository, UserService serviceUser) {
        this.repository = repository;
        this.serviceUser = serviceUser;
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public Restaurant save(RestaurantDto dto) {
        return save(fromDto(dto));
    }

    public Restaurant save(Restaurant rest) {
        boolean insert = (rest.getId() == null);
        if (!insert) {
            allowedUserResource(rest.getId());
        }
        Restaurant restaurant = repository.save(rest);
        if (insert) {
            serviceUser.setRestaurant(restaurant);
        }
        return restaurant;
    }

    public Restaurant findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Restaurant not found! Id: " + id + ", Type: " + Restaurant.class.getName()));
    }

    public Restaurant fromDto(RestaurantDto dto) {
        return new Restaurant(dto.getId(), dto.getTradingName(), dto.getCompanyName(), dto.getAddress(), dto.getEmail(),
                dto.getDescription(), dto.getTimeEstimate(), dto.getPriceMinimum(), dto.getRating(), dto.getMenu(),
                dto.getSyncDate());
    }

}
