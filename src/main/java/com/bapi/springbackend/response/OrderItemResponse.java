package com.bapi.springbackend.response;

public class OrderItemResponse {
    private String item;
    private double amount;
    private double price;

    public OrderItemResponse(String item, double amount, double price) {
        this.item = item;
        this.amount = amount;
        this.price = price;
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
