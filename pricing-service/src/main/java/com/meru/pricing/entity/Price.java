package com.meru.pricing.entity;

import org.springframework.data.annotation.Id;

public class Price { 

	@Id
    private int priceId;
    private int productId;
    private double price;

    public Price() {

    }

    public Price(int priceId, int productId, double price) {
        this.priceId = priceId;
        this.productId = productId;
        this.price = price;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
