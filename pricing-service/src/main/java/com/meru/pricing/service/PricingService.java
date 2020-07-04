package com.meru.pricing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meru.pricing.entity.Price;


@Service
public interface PricingService {
    public List<Price> getAllProductsPrice();

    public Price getPriceById(int priceId);


    public boolean createOrUpdatePrice(Price price);

    public boolean removePrice(int priceId);
}
