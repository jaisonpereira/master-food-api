package com.masterfood.masterfoodapi.controllers;

import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import com.masterfood.masterfoodapi.services.RestaurantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    private RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @ApiOperation(value = "Find all restaurants")
    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll() {
        List<Restaurant> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Find by id restaurants")
    @ApiResponse(code = 404, message = "Category not found")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
