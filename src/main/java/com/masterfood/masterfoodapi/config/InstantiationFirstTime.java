package com.masterfood.masterfoodapi.config;

import com.masterfood.masterfoodapi.domain.Category;
import com.masterfood.masterfoodapi.domain.enums.CategoryType;
import com.masterfood.masterfoodapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InstantiationFirstTime implements CommandLineRunner {

    CategoryRepository repositoryCategory;

    @Autowired
    public InstantiationFirstTime(CategoryRepository repositoryCategory) {
        this.repositoryCategory = repositoryCategory;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
    }

    public void loadCategories() {
        if (repositoryCategory.findAll()
                .isEmpty()) {
            Category category1 = new Category(null, "category 1", CategoryType.COMUN,
                    "Category 1 for test type: Comun");
            Category category2 = new Category(null, "category 2", CategoryType.COMUN,
                    "Category 2 for test type: Comun");
            repositoryCategory.saveAll(Arrays.asList(category1, category2));
        }
    }

}
