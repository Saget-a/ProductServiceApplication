package com.example.product.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String productServiceUrl = "http://localhost:8081/api/products";

    public boolean existsByProductName(String productName) {
        try {
            // Надіслати запит GET /exists/{productName}
            Boolean response = restTemplate.getForObject(productServiceUrl + "/exists/" + productName, Boolean.class);
            return Boolean.TRUE.equals(response);
        } catch (Exception e) {
            return false;
        }
    }
}
