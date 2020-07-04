package com.meru.pricing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.meru.pricing.entity.Price;

@Repository
public interface PriceRepository extends MongoRepository<Price, Integer> {
		
}
