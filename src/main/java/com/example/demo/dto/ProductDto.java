package com.example.demo.dto;

public class ProductDto {
    private String name;
    private String productDescription;
    private int price;

    public ProductDto() {
    }


    public ProductDto(String name, String productDescription, int price) {
        this.name = name;
        this.productDescription = productDescription;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
