package com.masterfood.masterfoodapi.config;

import com.masterfood.masterfoodapi.domain.User;
import com.masterfood.masterfoodapi.domain.enums.PerfilType;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.repository.RestaurantRepository;
import com.masterfood.masterfoodapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class InstantiationFirstTime implements CommandLineRunner {

    public static final String ADMIN = "admin";
    public static final String CLIENT = "client";

    RestaurantRepository repositoryRestaurant;
    UserRepository repositoryUser;
    BCryptPasswordEncoder encoderPass;

    @Autowired
    public InstantiationFirstTime(RestaurantRepository repositoryRestaurant, UserRepository repositoryUser,
            BCryptPasswordEncoder encoderPass) {
        this.repositoryRestaurant = repositoryRestaurant;
        this.repositoryUser = repositoryUser;
        this.encoderPass = encoderPass;
    }

    @Override
    public void run(String... args) throws Exception {
        loadRestaurant();
        loadUsers();
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

    public void loadUsers() {
        if (repositoryUser.findAll()
                .isEmpty()) {
            User user1 = new User();
            user1.setEmail(ADMIN);
            user1.setName(ADMIN);
            user1.addPerfil(PerfilType.ADMIN);
            user1.setPassword(encoderPass.encode(ADMIN));

            User user2 = new User();
            user2.setEmail(CLIENT);
            user2.setName(CLIENT);
            user2.addPerfil(PerfilType.CLIENT);
            user2.setPassword(encoderPass.encode(CLIENT));

            repositoryUser.saveAll(Arrays.asList(user1, user2));
        }
    }

}
