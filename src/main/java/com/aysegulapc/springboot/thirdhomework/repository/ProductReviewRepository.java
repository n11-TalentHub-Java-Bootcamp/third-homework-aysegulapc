package com.aysegulapc.springboot.thirdhomework.repository;

import com.aysegulapc.springboot.thirdhomework.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
}
