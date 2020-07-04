package com.meru.product.entity;

public class Product{

	private int productId;
	
	private String productName;
	
	private String category;
	
	private String productStatus;
	
	private ProductDescription productDescription;

	public Product() {
	}

	public Product(int productId, String productName, String category, String productStatus,
			ProductDescription productDescription) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.productStatus = productStatus;
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public ProductDescription getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", productStatus=" + productStatus + ", productDescription=" + productDescription + "]";
	}
}
