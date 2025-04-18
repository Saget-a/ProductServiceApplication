package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{sellerID}")
    public Optional<Product> getProduct(@PathVariable int sellerID) {
        return service.getById(sellerID);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{sellerID}")
    public Product updateProduct(@PathVariable int sellerID, @RequestBody Product updatedProduct) {
        updatedProduct.setSellerID(sellerID);
        return service.save(updatedProduct);
    }

    @DeleteMapping("/{sellerID}")
    public void deleteProduct(@PathVariable int sellerID) {
        service.delete(sellerID);
    }
}