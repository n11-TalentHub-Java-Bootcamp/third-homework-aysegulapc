package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.dto.ProductDetailDto;
import com.aysegulapc.springboot.thirdhomework.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(String id);

    ProductDetailDto findProductDetailDtoById(String id);

    Product save(Product product);

    void deleteById(String id);

    List<ProductDetailDto> findAllProductByCategoryId(String categoryId);

    Product findProductByPrice(BigDecimal price);
}
