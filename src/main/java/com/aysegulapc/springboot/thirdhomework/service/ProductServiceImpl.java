package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.converter.ProductConverter;
import com.aysegulapc.springboot.thirdhomework.dto.ProductDetailDto;
import com.aysegulapc.springboot.thirdhomework.entity.Product;
import com.aysegulapc.springboot.thirdhomework.service.entityservice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductEntityService productEntityService;

    @Override
    public List<Product> findAll() {
        return productEntityService.findAll();
    }

    @Override
    public Product findById(String id) {
        return productEntityService.findById(id);
    }

    @Override
    public ProductDetailDto findProductDetailDtoById(String id) {

        Product product = productEntityService.findById(id);
        ProductDetailDto productDetailDto = ProductConverter.INSTANCE.convertProductToProductDetailDto(product);
        return productDetailDto;
    }

    @Override
    public Product save(Product product) {
        return productEntityService.save(product);
    }

    @Override
    public void deleteById(String id) {
        productEntityService.delete(id);
    }

    @Override
    public List<ProductDetailDto> findAllProductByCategoryId(String categoryId) {
        List<Product> productList = productEntityService.findAllProductByCategoryId(categoryId);
        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);
        return productDetailDtoList;
    }

    @Override
    public Product findProductByPrice(BigDecimal price) {
        Product product = productEntityService.findProductByPrice(price);
        return product;
    }
}
