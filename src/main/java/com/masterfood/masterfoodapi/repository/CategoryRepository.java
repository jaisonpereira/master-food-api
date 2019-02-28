package com.masterfood.masterfoodapi.repository;

import com.masterfood.masterfoodapi.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
