package com.bapi.service.response;

public class SumOfOrderResponse {
    private double sum;

    public SumOfOrderResponse(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
