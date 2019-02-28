package com.masterfood.masterfoodapi.services;

import com.masterfood.masterfoodapi.domain.Category;
import com.masterfood.masterfoodapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

}
