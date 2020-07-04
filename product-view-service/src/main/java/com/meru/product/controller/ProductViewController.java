package com.meru.product.controller;

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

import com.meru.product.entity.Inventory;
import com.meru.product.entity.Price;
import com.meru.product.entity.Product;
import com.meru.product.entity.ProductViewModel;
import com.meru.product.service.ProductViewServiceIntf;

@RestController
public class ProductViewController {

static String WELCOME_MSG = "Welcome to Product View Service. This is not a valid service path.";
static String DELETE_MSG = "Delete Product View for ProductViewID: %s %s";
static String CREATE_SUB_COMPONENT_MSG = "Create %s for product %d in ProductView is %s";
static String UPDATE_SUB_COMPONENT_MSG = "Update %s for product %d in ProductView is %s";
static String SUCCESS = "Success";
static String ERROR = "Failed";
static String COMPONENT_PRODUCT = "Product";
static String COMPONENT_INVENTORY = "Inventory";
static String COMPONENT_PRICE = "Price";
static String COMPONENT_PROMOTION = "Promotion";


@GetMapping("/productview")
public String productview() {

	return "Rest Demo in Product View  ";
}

@RequestMapping(method = RequestMethod.GET, value = "/")
public ResponseEntity<String> showInfo() {
    return ResponseEntity.badRequest().headers(new HttpHeaders()).body(WELCOME_MSG);
}


  @Autowired
  
  private ProductViewServiceIntf pvs;
  
  
  @RequestMapping(method = RequestMethod.GET, value = "/{id}") public
  ResponseEntity<ProductViewModel> getProductViewById(@PathVariable int id) {
  ProductViewModel pvm = pvs.getProductViewById(id); HttpStatus status =
  HttpStatus.OK; if (null == pvm) { status = HttpStatus.NO_CONTENT; } return
  new ResponseEntity<>(pvm, new HttpHeaders(), status); }
  
  @RequestMapping(method = RequestMethod.GET, value = "/all") public
  ResponseEntity<List<ProductViewModel>> getAllProductViews() { return
  ResponseEntity.ok().body(pvs.getAllProductViews()); }
  
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}") public
  ResponseEntity<String> deleteProductView(@PathVariable int id) { boolean
  deleted = pvs.removeProductView(id); HttpStatus status = HttpStatus.OK;
  String msg = String.format(DELETE_MSG, id, SUCCESS); if (!deleted) { msg =
  String.format(DELETE_MSG, id, ERROR); status = HttpStatus.BAD_REQUEST; }
  return new ResponseEntity<>(msg, new HttpHeaders(), status); }
  
  // Add Product to Product View
  
  @RequestMapping(method = RequestMethod.POST, value = "/product") public
  ResponseEntity<String> addProductToProductView(@RequestBody Product product)
  { boolean created =
  pvs.createOrUpdateProductInProductView(product.getProductId(), product);
  HttpStatus status = HttpStatus.OK; String msg =
  String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_PRODUCT,
  product.getProductId(), SUCCESS); if (!created) {
  String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_PRODUCT,
  product.getProductId(), ERROR); status = HttpStatus.BAD_REQUEST; } return new
  ResponseEntity<>(msg, new HttpHeaders(), status); }
  
  //Update Product in Product View
  
  @RequestMapping(method = RequestMethod.PUT, value = "/product/{id}") public
  ResponseEntity<String> updateProductInProductView(@PathVariable int
  id, @RequestBody Product product) { boolean updated =
  pvs.createOrUpdateProductInProductView(id, product); HttpStatus status =
  HttpStatus.OK; String msg = String.format(UPDATE_SUB_COMPONENT_MSG,
  COMPONENT_PRODUCT, id, SUCCESS); if (!updated) { msg =
  String.format(UPDATE_SUB_COMPONENT_MSG, COMPONENT_PRODUCT, id, ERROR); status
  = HttpStatus.BAD_REQUEST; } return new ResponseEntity<>(msg, new
  HttpHeaders(), status); }
  
  //Add Inventory to Product View
  
  @RequestMapping(method = RequestMethod.POST, value = "/inventory") public
  ResponseEntity<String> addInventoryToProductView(@RequestBody Inventory
  inventory) { boolean created =
  pvs.createOrUpdateInventoryInProductView(inventory.getProductId(),
  inventory); HttpStatus status = HttpStatus.OK; String msg =
  String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_INVENTORY,
  inventory.getProductId(), SUCCESS); if (!created) {
  String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_INVENTORY,
  inventory.getProductId(), ERROR); status = HttpStatus.BAD_REQUEST; } return
  new ResponseEntity<>(msg, new HttpHeaders(), status); }
  
  //Update Inventory in Product View
  
  @RequestMapping(method = RequestMethod.PUT, value = "/inventory/{id}") public
  ResponseEntity<String> updateInventoryInProductView(@PathVariable int
  id, @RequestBody Inventory inventory) { boolean updated =
  pvs.createOrUpdateInventoryInProductView(id, inventory); HttpStatus status =
  HttpStatus.OK; String msg = String.format(UPDATE_SUB_COMPONENT_MSG,
  COMPONENT_INVENTORY, id, SUCCESS); if (!updated) { msg =
  String.format(UPDATE_SUB_COMPONENT_MSG, COMPONENT_INVENTORY, id, ERROR);
  status = HttpStatus.BAD_REQUEST; } return new ResponseEntity<>(msg, new
  HttpHeaders(), status); }
  
  //Add Price to Product View
  
  @RequestMapping(method = RequestMethod.POST, value = "/price") public
  ResponseEntity<String> addPriceToProductView(@RequestBody Price price) {
  boolean created = pvs.createOrUpdatePriceInProductView(price.getProductId(),
  price); HttpStatus status = HttpStatus.OK; String msg =
  String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_PRICE,
  price.getProductId(), SUCCESS); if (!created) {
  String.format(CREATE_SUB_COMPONENT_MSG, COMPONENT_PRICE,
  price.getProductId(), ERROR); status = HttpStatus.BAD_REQUEST; } return new
  ResponseEntity<>(msg, new HttpHeaders(), status); }
  
  //Update Price in Product View
  
  @RequestMapping(method = RequestMethod.PUT, value = "/price/{id}") public
  ResponseEntity<String> updatePriceInProductView(@PathVariable int
  id, @RequestBody Price price) { boolean updated =
  pvs.createOrUpdatePriceInProductView(id, price); HttpStatus status =
  HttpStatus.OK; String msg = String.format(UPDATE_SUB_COMPONENT_MSG,
  COMPONENT_PRICE, id, SUCCESS); if (!updated) { msg =
  String.format(UPDATE_SUB_COMPONENT_MSG, COMPONENT_PRICE, id, ERROR); status =
  HttpStatus.BAD_REQUEST; } return new ResponseEntity<>(msg, new HttpHeaders(),
  status); }

  
  
 
}
