package com.example.product.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthClient {

    private final RestTemplate restTemplate;

    @Value("${auth.service.url}")
    private String authServiceUrl;

    public AuthClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Long getUserId(String username) {
        String url = authServiceUrl + "/api/auth/getId/" + username;
        return restTemplate.getForObject(url, Long.class);
    }
}