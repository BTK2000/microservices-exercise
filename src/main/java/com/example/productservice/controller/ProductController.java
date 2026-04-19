package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        log.info("API call: create product name={}, price={}, stock={}",
                product.getName(), product.getPrice(), product.getStock());
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        log.info("API call: get product by id={}", id);
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        log.info("API call: get all products");
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @Valid @RequestBody Product product) {
        log.info("API call: update product id={}", id);
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        log.info("API call: delete product id={}", id);
        productService.deleteProduct(id);
        return "Product deleted successfully with id: " + id;
    }

    @GetMapping("/paged")
    public Page<Product> getProductsPaged(@RequestParam int page,
                                          @RequestParam int size,
                                          @RequestParam String sortBy) {
        log.info("API call: get paged products page={}, size={}, sortBy={}", page, size, sortBy);
        return productService.getProductsPaged(page, size, sortBy);
    }

    @GetMapping("/filter/price")
    public List<Product> getProductsAbovePrice(@RequestParam BigDecimal price) {
        log.info("API call: filter products above price={}", price);
        return productService.getProductsAbovePrice(price);
    }

    @GetMapping("/native/price")
    public List<Product> getProductsAbovePriceNative(@RequestParam BigDecimal price) {
        log.info("API call: native query products above price={}", price);
        return productService.getProductsAbovePriceNative(price);
    }
}