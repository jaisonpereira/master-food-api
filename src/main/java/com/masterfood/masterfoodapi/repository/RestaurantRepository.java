package com.masterfood.masterfoodapi.repository;

import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    @Transactional(readOnly = true)
    List<Restaurant> findByEmail(String email);

}
