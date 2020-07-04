package com.meru.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.product.entity.Inventory;
import com.meru.product.entity.Price;
import com.meru.product.entity.Product;
import com.meru.product.entity.ProductViewModel;
import com.meru.product.repository.ProductViewRepository;

@Service("ProductViewService")
public class ProductViewServiceImpl implements ProductViewServiceIntf {

	@Autowired
    ProductViewRepository productViewRepository;

	@Override
	public boolean removeProductView(int productViewId) {
		productViewRepository.deleteById(productViewId);
        return true;

	}

	@Override
	public List<ProductViewModel> getAllProductViews() {
		// TODO Auto-generated method stub
		return productViewRepository.findAll();
	}

	@Override
	public ProductViewModel getProductViewById(int productViewId) {
		// TODO Auto-generated method stub
		Optional<ProductViewModel> pm=productViewRepository.findById(productViewId);
		return pm.get();
		
	}

	@Override
	public boolean createOrUpdateProductView(ProductViewModel productView) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.save(productView);
        boolean status = false;
        if (null != pv) {
            status = true;
        }
        return status;

	}

	@Override
	public boolean createOrUpdateProductInProductView(int productId, Product product) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setProduct(product);
        } else {
            pv = new ProductViewModel(productId, product, new Inventory(), new Price());
        }
        return createOrUpdateProductView(pv);

	}

	@Override
	public boolean createOrUpdateInventoryInProductView(int productId, Inventory inventory) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setInventory(inventory);
        } else {
            pv = new ProductViewModel(productId, new Product(), inventory, new Price());
        }
        return createOrUpdateProductView(pv);

	}

	@Override
	public boolean createOrUpdatePriceInProductView(int productId, Price price) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setPrice(price);
        } else {
            pv = new ProductViewModel(productId, new Product(), new Inventory(), price);
        }
        return createOrUpdateProductView(pv);

	}


    
}
