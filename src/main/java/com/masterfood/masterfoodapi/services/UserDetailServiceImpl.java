package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.User;
import com.masterfood.masterfoodapi.repository.UserRepository;
import com.masterfood.masterfoodapi.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = repository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSecurity(user.getId(), user.getEmail(), user.getPassword(), user.getPerfis(), user.getName(),
                user.getRestaurant() != null
                        ? user.getRestaurant()
                                .getId()
                        : null);
    }
}