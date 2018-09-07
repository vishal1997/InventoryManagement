/**
 * 
 */
package com.inventory.management.manager;

import java.util.Date;
import java.util.List;

import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.model.Product;
import com.inventory.management.model.Range;

/**
 * @author Vishal Gupta
 *
 */
public interface InventoryManager {

	public String purchaseProduct(DbProduct product);
	public String saleProduct(List<Product> product);
	public List<Product> getAllProducts();
	public List<DbSold> getAllsalesDetails();
	public List<DbSold> getAllSalesByPriceRange(double initialPrice, double finalPrice);
	public List<DbSold> getAllSalesByDateRange(Date initialDate, Date finalDate);
	public List<DbSold> getAllSalesByRange(Range range);
	public List<Product> getSuggestion(String productName);
	public Product getProduct(String productName);
}
