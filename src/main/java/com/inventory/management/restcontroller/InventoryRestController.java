/**
 * 
 */
package com.inventory.management.restcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.inventory.management.common.Constants.StatusCode;
import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.manager.InventoryManager;
import com.inventory.management.model.Product;
import com.inventory.management.model.Range;

/**
 * @author Vishal Gupta
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/api/v1/")
@ComponentScan
public class InventoryRestController {
	
	@Autowired
	private InventoryManager inventoryManager;
	
	
	@RequestMapping(value = "product", method=RequestMethod.POST)
	public Map<String, String> purchaseProduct(@RequestBody final DbProduct product) throws Exception{
		
		Map<String, String> status = new HashMap<String, String>();
		try {
			status.put("Status",inventoryManager.purchaseProduct(product));
		} catch(Exception ex) {
			status.put("Status", StatusCode.ERROR);
			return status;
		}
		return status;
	}
	
	@RequestMapping(value = "sold", method = RequestMethod.POST)
	public Map<String, String> saleProduct(ArrayList<Product> product) {
		
		Map<String, String> status = new HashMap<String, String>();
		try {
			status.put("Status", inventoryManager.saleProduct(product));
		} catch(Exception ex) {
			status.put("Status", StatusCode.ERROR);
			return status;
		}
		return status;
	}
	
	@RequestMapping(value = "available", method = RequestMethod.GET) 
	public List<Product> getAllProducts() throws Exception {
	
		try {
			return inventoryManager.getAllProducts();
		} catch (Exception ex){
			return new ArrayList<Product>();
		}
	}
	
	@RequestMapping(value = "getSalesDetails", method = RequestMethod.GET)
	public List<DbSold> getAllSalesDetails() {
		
		try {
			return inventoryManager.getAllsalesDetails();
		} catch(Exception ex) {
			return new ArrayList<DbSold>();
		}
	}
	
	@RequestMapping(value = "getSalesDetails/priceRange", method = RequestMethod.POST) 
	public List<DbSold> getAllSalesByPriceRange(@RequestBody final double initialPrice,
												@RequestBody final double finalPrice) {
		try {
			return inventoryManager.getAllSalesByPriceRange(initialPrice, finalPrice);
		} catch(Exception ex) {
			return new ArrayList<DbSold>();
		}
	}
	
	@RequestMapping(value = "getSalesDetails/dateRange",method = RequestMethod.POST)
	public List<DbSold> getAllSalesByDateRange(@RequestBody final Date initialDate,
												@RequestBody final Date finalDate) {
		try {
			return inventoryManager.getAllSalesByDateRange(initialDate, finalDate);
		} catch(Exception ex) {
			return new ArrayList<DbSold>();
		}
	}
	
	@RequestMapping(value = "getSalesDetails/range",method = RequestMethod.POST)
	public List<DbSold> getAllSalesByRange(@RequestBody Range range) {
		
		try {
			return inventoryManager.getAllSalesByRange(range);
		} catch(Exception ex) {
			return new ArrayList<DbSold>();
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Map<String, String> get() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Status", "Pass");
		return map;
	}
	
	@RequestMapping(value = "/getSuggestion", method = RequestMethod.POST)
	public List<Product> getSuggestions(@RequestBody final String productName) {
		
		try {
			return inventoryManager.getSuggestion(productName);
		} catch(Exception ex) {
			return new ArrayList<Product>();
		}
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public Product getProduct(@RequestBody final String productName) {
		
		try {
			return inventoryManager.getProduct(productName);
		} catch(Exception ex) {
			return new Product();
		}
	}
}
