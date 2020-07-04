package com.meru.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meru.product.entity.ProductViewModel;

@Repository
public interface ProductViewRepository extends MongoRepository<ProductViewModel, Integer> {
	 @Query("select pv from ProductViewModel"
	    		+ " pv where pv.productId=:productId")
	    public ProductViewModel getByProductId(@Param("productId") int productId);
}

