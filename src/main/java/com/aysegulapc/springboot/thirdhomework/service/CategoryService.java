package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.entity.Category;

import java.util.List;

public interface CategoryService{
    List<Category> findAll();

    Category findById(String id);

    Category save(Category category);

    void deleteById(String id);
}
