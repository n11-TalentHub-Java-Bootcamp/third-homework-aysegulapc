package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.entity.Category;
import com.aysegulapc.springboot.thirdhomework.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    public Category findById(String id) {
        return categoryEntityService.findById(id);
    }

    public Category save(Category category) {
        return categoryEntityService.save(category);
    }

    public void deleteById(String id) {
        categoryEntityService.deleteById(id);
    }

}
