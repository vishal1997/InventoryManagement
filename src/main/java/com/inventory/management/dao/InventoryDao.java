/**
 * 
 */
package com.inventory.management.dao;

import java.util.Date;
import java.util.List;

import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.model.Range;

/**
 * @author Vishal Gupta
 *
 */
public interface InventoryDao {

	public String purchaseProduct(DbProduct product);
	public String saleProduct(List<Integer> productId);
	public DbProduct getProductByProductId(int productId);
	public String updateProduct(List<DbProduct> dbProduct);
	public String updateProduct(DbProduct dbProduct);
	public List<DbProduct> getAllProducts();
	public List<DbSold> getAllsalesDetails();
	public List<DbSold> getAllSalesByPriceRange(double initialPrice, double finalPrice);
	public List<DbSold> getAllSalesByDateRange(Date initialDate, Date finalDate);
	public List<DbSold> getAllSalesByRange(Range range);
	public String addToSoldProduct(List<DbSold> dbSold);
	public String addToSoldProduct(DbSold dbSold);
	public List<DbProduct> getSuggestion(String productName);
	public DbProduct getProduct(String productName);
}
