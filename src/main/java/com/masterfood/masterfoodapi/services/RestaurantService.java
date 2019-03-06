package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.repository.RestaurantRepository;
import com.wirelabs.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public Restaurant findById(String id) {
        // TODO: devera recuperar somente usuarios que forem admin ou que o login esteja
        // associado com esse restaurant
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Restaurant not found! Id: " + id + ", Type: " + Restaurant.class.getName()));
    }

}
