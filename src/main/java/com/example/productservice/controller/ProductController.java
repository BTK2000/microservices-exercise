package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "Product deleted successfully with id: " + id;
    }

    @GetMapping("/paged")
    public Page<Product> getProductsPaged(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy
    ) {
        return productService.getProductsPaged(page, size, sortBy);
    }

    @GetMapping("/filter/price")
    public List<Product> getProductsAbovePrice(@RequestParam BigDecimal price) {
        return productService.getProductsAbovePrice(price);
    }

    @GetMapping("/native/price")
    public List<Product> getProductsAbovePriceNative(@RequestParam BigDecimal price) {
        return productService.getProductsAbovePriceNative(price);
    }
}