/**
 * 
 */
package com.inventory.management.manager.impl;
/**
 * @author Vishal Gupta
 *
 */

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.management.common.Constants.StatusCode;
import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.helper.InventoryHelper;
import com.inventory.management.manager.InventoryManager;
import com.inventory.management.model.Product;
import com.inventory.management.model.Range;

@Component
public class InventoryManagerImpl implements InventoryManager {

	@Autowired
	private InventoryHelper inventoryHelper;


	@Override
	public String purchaseProduct(DbProduct product) {
		
		return inventoryHelper.purchaseProduct(product);
	}


	/* (non-Javadoc)
	 * @see com.inventory.management.manager.InventoryManager#saleProduct(int)
	 */
	@Override
	public String saleProduct(List<Product> product) {
		
		String status = inventoryHelper.saleProduct(product);
		if(!status.equals(StatusCode.SUCCESS)) {
			return status;
		}
		status = inventoryHelper.addToSoldProduct(product);
		return status;
	}


	/* (non-Javadoc)
	 * @see com.inventory.management.manager.InventoryManager#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		return inventoryHelper.getAllProducts();
	}


	/* (non-Javadoc)
	 * @see com.inventory.management.manager.InventoryManager#getAllsalesDetails()
	 */
	@Override
	public List<DbSold> getAllsalesDetails() {
		return inventoryHelper.getAllsalesDetails();
	}


	/* (non-Javadoc)
	 * @see com.inventory.management.manager.InventoryManager#getAllSalesByPriceRange(double, double)
	 */
	@Override
	public List<DbSold> getAllSalesByPriceRange(double initialPrice, double finalPrice) {
		return inventoryHelper.getAllSalesByPriceRange(initialPrice, finalPrice);
	}


	/* (non-Javadoc)
	 * @see com.inventory.management.manager.InventoryManager#getAllSalesByDateRange(java.util.Date, java.util.Date)
	 */
	@Override
	public List<DbSold> getAllSalesByDateRange(Date initialDate, Date finalDate) {
		
		return inventoryHelper.getAllSalesByDateRange(initialDate, finalDate);
	}


	/* (non-Javadoc)
	 * @see com.inventory.management.manager.InventoryManager#getAllSalesByRange(com.inventory.management.model.Range)
	 */
	@Override
	public List<DbSold> getAllSalesByRange(Range range) {
		return inventoryHelper.getAllSalesByRange(range);
	}
	
}
