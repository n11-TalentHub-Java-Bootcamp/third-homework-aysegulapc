package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.entity.ProductReview;
import com.aysegulapc.springboot.thirdhomework.service.entityservice.ProductReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService{

    @Autowired
    private ProductReviewEntityService productReviewEntityService;

    @Override
    public List<ProductReview> findAll() {
        return productReviewEntityService.findAll();
    }

    @Override
    public ProductReview findById(String id) {
        return productReviewEntityService.findById(id);
    }

    @Override
    public ProductReview save(ProductReview productReview) {
        return productReviewEntityService.save(productReview);
    }

    @Override
    public void delete(String id) {
        productReviewEntityService.delete(id);
    }
}
