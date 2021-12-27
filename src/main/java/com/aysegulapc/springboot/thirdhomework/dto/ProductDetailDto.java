package com.aysegulapc.springboot.thirdhomework.dto;

import java.math.BigDecimal;

public class ProductDetailDto {
    private String productName;
    private String categoryName;
    private String categoryId;
    private BigDecimal productPrice;

    public ProductDetailDto() {
    }

    public ProductDetailDto(String productName, String categoryName, String categoryId, BigDecimal productPrice) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDetailDto{" +
                "productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
