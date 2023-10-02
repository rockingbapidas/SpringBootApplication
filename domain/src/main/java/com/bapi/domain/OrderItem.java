package com.bapi.domain;

public class OrderItem {
    private Long id;
    private String item;
    private double amount;
    private double price;

    public OrderItem(Long id, String item, double amount, double price) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.price = price;
    }

    public OrderItem(String item, double amount, double price) {
        this.item = item;
        this.amount = amount;
        this.price = price;
    }

    public OrderItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
