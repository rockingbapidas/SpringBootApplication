
package com.bapi.springbackend.request;

import com.google.gson.annotations.SerializedName;

public class OrderItemRequest {

    @SerializedName("amount")
    private Double mAmount;
    @SerializedName("name")
    private String mName;
    @SerializedName("price")
    private Double mPrice;

    public Double getAmount() {
        return mAmount;
    }

    public void setAmount(Double amount) {
        mAmount = amount;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

}
