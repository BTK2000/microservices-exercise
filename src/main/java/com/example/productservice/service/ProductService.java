package com.example.productservice.service;

import com.example.productservice.entity.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product updateProduct(Integer id, Product product);

    void deleteProduct(Integer id);

    boolean validateStock(Integer productId, Integer quantity);

    Page<Product> getProductsPaged(int page, int size, String sortBy);

    List<Product> getProductsAbovePrice(BigDecimal price);
}