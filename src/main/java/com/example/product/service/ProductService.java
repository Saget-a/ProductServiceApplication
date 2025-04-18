package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> getById(int sellerID) {
        return repository.findById(sellerID);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void delete(int sellerID) {
        repository.deleteById(sellerID);
    }
}