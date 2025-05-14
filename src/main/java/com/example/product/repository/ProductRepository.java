package com.example.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Найти все товары по sellerID
    List<Product> findBySellerID(int sellerID);

    // Найти все товары, НЕ принадлежащие sellerID (для отображения общего каталога)
    List<Product> findBySellerIDNot(int sellerID);

    // Перевірка, чи існує товар з таким іменем
    boolean existsByProductNameIgnoreCase(String productName);

}
