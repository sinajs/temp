package com.meru.pricing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.pricing.entity.Price;
import com.meru.pricing.repository.PriceRepository;

@Service
public class PricingServiceImpl implements PricingService {

    @Autowired
     PriceRepository pr;


    @Override
    public List<Price> getAllProductsPrice() {
        return pr.findAll();
    }

  

    @Override
    public boolean createOrUpdatePrice(Price price) {
        Price updatedPrice = pr.save(price);
        boolean status = false;
        if (null != updatedPrice) {
            status = true;
        }
        return status;
    }

   

	public Price createPrice(int productId) {
		// TODO Auto-generated method stub
		Price price=new Price();
		price.setProductId(productId);
		price.setPrice(10000);
		return price;
	}

	@Override
	public Price getPriceById(int priceId) {
		// TODO Auto-generated method stub			
		Optional<Price> pp =  pr.findById(priceId);
		  return pp.get();
	}

	@Override
	public boolean removePrice(int priceId) {
		// TODO Auto-generated method stub
		Optional<Price> deletedPrice =  pr.findById(priceId);
		     pr.deleteById(priceId);
	        boolean deleted = false;
	        if (null != deletedPrice) {
	            deleted = true;
	        }
	        return deleted;
	}
	
	

	
}

