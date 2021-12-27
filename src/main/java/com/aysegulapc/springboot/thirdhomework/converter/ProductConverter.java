package com.aysegulapc.springboot.thirdhomework.converter;

import com.aysegulapc.springboot.thirdhomework.dto.ProductDetailDto;
import com.aysegulapc.springboot.thirdhomework.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "productPrice")
    ProductDetailDto convertProductToProductDetailDto(Product product);


    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "productPrice")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> product);

}
