package com.springguru.testrestful.models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    private int productId;
    @Column
    private String productName;
    @Column
    private double amount;

    public Product() {
    }

    public Product(int productId, String productName, double amount) {
        this.productId = productId;
        this.productName = productName;
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
