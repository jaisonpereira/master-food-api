package com.masterfood.masterfoodapi.controllers;

import com.masterfood.masterfoodapi.domain.dto.EmailDto;
import com.masterfood.masterfoodapi.security.UserSecurity;
import com.masterfood.masterfoodapi.services.AuthService;
import com.masterfood.masterfoodapi.services.UserService;
import com.wirelabs.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @PostMapping(value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSecurity user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent()
                .build();
    }

    @PostMapping(value = "/forgot")
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDto dto) {
        service.sendNewPassword(dto.getEmail());
        return ResponseEntity.noContent()
                .build();
    }
}