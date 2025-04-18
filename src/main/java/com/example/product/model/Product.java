package com.example.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int sellerID;
    private String productName;
    private int amount;
    private double price;
    private String productDescription;

    public Product() {}

    public Product(String productName, int sellerID, int amount, double price, String productDescription) {
        this.sellerID = sellerID;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.productDescription = productDescription;
    }

    // Getters и Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getSellerID() { return sellerID; }
    public void setSellerID(int sellerID) { this.sellerID = sellerID; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }
}
