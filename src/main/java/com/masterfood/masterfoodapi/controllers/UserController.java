package com.masterfood.masterfoodapi.controllers;

import com.masterfood.masterfoodapi.domain.User;
import com.masterfood.masterfoodapi.services.UserService;
import com.wirelabs.common.BaseControllerWeb;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseControllerWeb {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @ApiOperation(value = "Find all Users")
    @GetMapping
    @PreAuthorize("hasAnyRole(" + GROUP_ADMIN + ")")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Find by id user")
    @ApiResponse(code = 404, message = "User not found")
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole(" + GROUP_ADMIN + ")")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
