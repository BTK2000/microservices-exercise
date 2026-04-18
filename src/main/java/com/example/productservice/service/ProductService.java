package com.example.productservice.service;

import com.example.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    boolean validateStock(Integer productId, Integer quantity);
}