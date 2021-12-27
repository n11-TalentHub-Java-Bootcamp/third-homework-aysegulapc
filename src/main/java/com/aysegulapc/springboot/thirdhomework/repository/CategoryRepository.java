package com.aysegulapc.springboot.thirdhomework.repository;

import com.aysegulapc.springboot.thirdhomework.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
