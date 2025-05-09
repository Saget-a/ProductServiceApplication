package com.example.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.client.AuthClient;
import com.example.product.model.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final AuthClient authClient;

    public ProductController(ProductService productService, AuthClient authClient) {
        this.productService = productService;
        this.authClient = authClient;
    }

    // Получить все товары, кроме товаров пользователя (каталог)
    @GetMapping("/catalog/{username}")
    public List<Product> getCatalogExcludingUser(@PathVariable String username) {
        Long userId = authClient.getUserId(username);
        return productService.getAllExcludingSeller(userId.intValue());
    }

    // Получить все товары пользователя (личный кабинет)
    @GetMapping("/my-products/{username}")
    public List<Product> getMyProducts(@PathVariable String username) {
        Long userId = authClient.getUserId(username);
        return productService.getBySellerId(userId.intValue());
    }

    // Создать товар от имени пользователя (sellerID подставляется автоматически)
    @PostMapping("/create/{username}")
    public Product createProduct(@PathVariable String username, @RequestBody Product product) {
        Long userId = authClient.getUserId(username);
        product.setSellerID(userId.intValue());
        return productService.save(product);
    }
}
