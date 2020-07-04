package com.meru.product.service;

import java.util.List;

import com.meru.product.entity.Inventory;
import com.meru.product.entity.Price;
import com.meru.product.entity.Product;
import com.meru.product.entity.ProductViewModel;

public interface ProductViewServiceIntf {

	public boolean removeProductView(int productViewId);

    public List<ProductViewModel> getAllProductViews();

    public ProductViewModel getProductViewById(int productViewId);

    public boolean createOrUpdateProductView(ProductViewModel productView);

    public boolean createOrUpdateProductInProductView(int productId, Product product);

    public boolean createOrUpdateInventoryInProductView(int productId, Inventory inventory);

    public boolean createOrUpdatePriceInProductView(int productId, Price price);



}
