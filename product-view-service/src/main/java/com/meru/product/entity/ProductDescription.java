package com.meru.product.entity;

public class ProductDescription {
	
	private String details; // description of the item
	
	private String specification; // all product specs
	
	private int weight; // weight in grams

	public ProductDescription() {
	}

	public ProductDescription(String details, String specification, int weight) {
		this.details = details;
		this.specification = specification;
		this.weight = weight;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "ProductDescription [details=" + details + ", specification=" + specification + ", weight=" + weight
				+ "]";
	}

}
