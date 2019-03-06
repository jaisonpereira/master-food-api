package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.User;
import com.masterfood.masterfoodapi.domain.enums.PerfilType;
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
            return null;
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {

        UserSecurity user = authenticated();

        if (user == null || !user.hasRole(PerfilType.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Access Denied");
        }

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User not found! Id: " + id + ", Type: " + User.class.getName()));
    }

}
