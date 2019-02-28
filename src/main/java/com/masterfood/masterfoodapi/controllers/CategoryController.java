package com.masterfood.masterfoodapi.controllers;

import com.masterfood.masterfoodapi.domain.Category;
import com.masterfood.masterfoodapi.services.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @ApiOperation(value = "Find all categories")
    @ApiResponse(code = 404, message = "Category not found")
    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

}
