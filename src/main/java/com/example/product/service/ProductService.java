package com.example.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Получить все товары
    public List<Product> getAll() {
        return repository.findAll();
    }

    // Получить товар по его ID 
    public Optional<Product> getByProductId(Long id) {
        return repository.findById(id);
    }

    // Получить товары по sellerID
    public List<Product> getBySellerId(int sellerID) {
        return repository.findBySellerID(sellerID);
    }

    // Получить все товары, кроме товаров определённого пользователя
    public List<Product> getAllExcludingSeller(int sellerID) {
        return repository.findBySellerIDNot(sellerID);
    }

    // Сохранить или обновить товар
    public Product save(Product product) {
        return repository.save(product);
    }

    // Удалить товар по его ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}