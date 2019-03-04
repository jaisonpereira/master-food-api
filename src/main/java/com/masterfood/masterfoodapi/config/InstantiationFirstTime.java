package com.masterfood.masterfoodapi.config;

import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InstantiationFirstTime implements CommandLineRunner {

    RestaurantRepository repositoryRestaurant;

    @Autowired
    public InstantiationFirstTime(RestaurantRepository repositoryRestaurant) {
        this.repositoryRestaurant = repositoryRestaurant;
    }

    @Override
    public void run(String... args) throws Exception {
        loadRestaurant();
    }

    public void loadRestaurant() {
        if (repositoryRestaurant.findAll()
                .isEmpty()) {
            Restaurant restaurant1 = new Restaurant();
            restaurant1.setName("Restaurant 1");
            restaurant1.setEmail("teste@restaurant1.com");
            restaurant1.setPriceMinimum(10.1f);
            restaurant1.setRating(4.6f);
            restaurant1.setTimeEstimate(40.);
            repositoryRestaurant.saveAll(Arrays.asList(restaurant1));
        }
    }

}
