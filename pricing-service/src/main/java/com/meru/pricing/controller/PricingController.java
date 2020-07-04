package com.meru.pricing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meru.pricing.entity.Price;
import com.meru.pricing.service.PricingServiceImpl;

@RestController
public class PricingController {
	static String WELCOME_MSG = "Welcome to Meru Price Service. This is not a valid service path.";
	static String CREATE_SUB_COMPONENT_MSG = "Create %s for Price %d in Price is %s";
	static String UPDATE_SUB_COMPONENT_MSG = "Update %s for Price %d in Price is %s";
	static String DELETE_MSG = "Delete Price for PriceId: %s %s";
	static String SUCCESS = "Success";
	static String ERROR = "Failed";
	static String COMPONENT_PRICE = "Price";

	@Autowired
	PricingServiceImpl ps;
	
	@GetMapping("/pricing")
	public String hello() {

		return "Rest Demo in Pricing  ";
	}


	//get price by id
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Price> getPriceById(@PathVariable int id) {
		Price inventory = ps.getPriceById(id);
		HttpStatus status = HttpStatus.OK;
		if (null == inventory) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<>(inventory, new HttpHeaders(), status);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public ResponseEntity<List<Price>> getAllProductsPrice() {
		return ResponseEntity.ok().body(ps.getAllProductsPrice());
	}
	//remove price
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletePrice(@PathVariable int id) {
		boolean deleted = ps.removePrice(id);
		HttpStatus status = HttpStatus.OK;
		String msg = String.format(DELETE_MSG, id, SUCCESS);
		if (!deleted) {
			msg = String.format(DELETE_MSG, id, ERROR);
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(msg, new HttpHeaders(), status);
	}

	// Add Price
	@RequestMapping(method = RequestMethod.POST, value = "/{productId}")
	public ResponseEntity<Price> addPrice(@PathVariable int productId) {
		Price price= ps.createPrice(productId);
		HttpStatus status = HttpStatus.OK;
		String msg = String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_PRICE, price.getPriceId(), SUCCESS);

		return ResponseEntity.ok().body(price);
	}

	// Update Price
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<String> updatePrice(@PathVariable int id, @RequestBody Price price) {
		boolean updated = ps.createOrUpdatePrice(price);
		HttpStatus status = HttpStatus.OK;
		String msg = String.format(UPDATE_SUB_COMPONENT_MSG, COMPONENT_PRICE, id, SUCCESS);
		if (!updated) {
			msg = String.format(UPDATE_SUB_COMPONENT_MSG, COMPONENT_PRICE, id, ERROR);
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(msg, new HttpHeaders(), status);
	}

}