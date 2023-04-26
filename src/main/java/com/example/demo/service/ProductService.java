package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(int id) {
        return productRepository.findById(id).get();
    }

    public Product save(ProductDto dto) {
        int id = autoIncrement();
        Product product = new Product(id, dto.getName(), dto.getProductDescription(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(int id, ProductDto dto) {
        Product product = productRepository.findById(id).get();
        product.setName(dto.getName());
        product.setProductDescription(dto.getProductDescription());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public Product delete(int id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return product;
    }

    // private methods
    private int autoIncrement() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty()? 1 :
                products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
