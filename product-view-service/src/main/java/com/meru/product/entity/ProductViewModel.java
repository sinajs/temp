package com.meru.product.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class ProductViewModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    private int productViewId;
	
    
    private int productId;

	
	private Product product;

	private Inventory inventory;
	
	private Price price;

	public ProductViewModel() {
	}

	public ProductViewModel(int productId, Product product, Inventory inventory, Price price) {
		this.productId = productId;
		this.product = product;
		this.inventory = inventory;
		this.price = price;
	}

	public ProductViewModel(int productViewId, int productId, Product product, Inventory inventory, Price price) {
		this.productViewId = productViewId;
		this.productId = productId;
		this.product = product;
		this.inventory = inventory;
		this.price = price;
	}

	public int getProductViewId() {
		return productViewId;
	}

	public void setProductViewId(int productViewId) {
		this.productViewId = productViewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "ProductView [productViewId=" + productViewId + ", productId=" + productId + ", product=" + product
				+ ", inventory=" + inventory + ", price=" + price + "]";
	}
}
