package com.meru.product.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int inventoryId;
	private int productId;
	
	private int qty;
	
	private String pickZone;
	
	private String packZone;
	
	private String ShippingArea;

	public Inventory() {
	}

	public Inventory(int inventoryId, int productId, int qty, String pickZone, String packZone, String shippingArea) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.qty = qty;
		this.pickZone = pickZone;
		this.packZone = packZone;
		ShippingArea = shippingArea;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPickZone() {
		return pickZone;
	}

	public void setPickZone(String pickZone) {
		this.pickZone = pickZone;
	}

	public String getPackZone() {
		return packZone;
	}

	public void setPackZone(String packZone) {
		this.packZone = packZone;
	}

	public String getShippingArea() {
		return ShippingArea;
	}

	public void setShippingArea(String shippingArea) {
		ShippingArea = shippingArea;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", qty=" + qty + ", pickZone="
				+ pickZone + ", packZone=" + packZone + ", ShippingArea=" + ShippingArea + "]";
	}
}
