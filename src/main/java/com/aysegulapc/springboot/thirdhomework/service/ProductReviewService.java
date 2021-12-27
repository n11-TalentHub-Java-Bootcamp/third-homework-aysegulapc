package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.entity.ProductReview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductReviewService {
    List<ProductReview> findAll();

    ProductReview findById(String id);

    ProductReview save(ProductReview productReview);

    void delete(String id);
}
