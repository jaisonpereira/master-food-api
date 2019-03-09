package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.User;
import com.masterfood.masterfoodapi.domain.enums.PerfilType;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.repository.UserRepository;
import com.masterfood.masterfoodapi.security.UserSecurity;
import com.wirelabs.exceptions.AuthorizationException;
import com.wirelabs.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public static UserSecurity authenticated() {
        try {
            return (UserSecurity) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
        } catch (Exception e) {
            throw new AuthorizationException("Authenticated user not found ", e);
        }
    }

    public void setRestaurant(Restaurant restaurant) {
        User user = findById(authenticated().getId());
        user.setRestaurant(restaurant);
        repository.save(user);
    }

    public void hasAccess(String id) {
        UserSecurity user = authenticated();
        if (user == null ||
                (!user.hasRole(PerfilType.ADMIN) && !user.hasRole(PerfilType.ROOT)) && !id.equals(user.getId())) {
            throw new AuthorizationException("Access Denied");
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        hasAccess(id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User not found! Id: " + id + ", Type: " + User.class.getName()));
    }

}
