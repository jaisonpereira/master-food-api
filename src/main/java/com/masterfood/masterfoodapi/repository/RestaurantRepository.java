package com.masterfood.masterfoodapi.repository;

import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

}
