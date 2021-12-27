package com.aysegulapc.springboot.thirdhomework.repository;

import com.aysegulapc.springboot.thirdhomework.dto.ProductDetailDto;
import com.aysegulapc.springboot.thirdhomework.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByCategoryId(String categoryId);

    ProductDetailDto findProductDetailDtoById(String id);

    @Query("{price: ?0}")
    Product findByPrice(BigDecimal price);
}
