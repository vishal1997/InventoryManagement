/**
 * 
 */
package com.inventory.management.helper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.management.common.Constants.StatusCode;
import com.inventory.management.dao.InventoryDao;
import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.helper.InventoryHelper;
import com.inventory.management.model.Product;
import com.inventory.management.model.Range;
import com.inventory.management.utils.DbSoldUtils;
import com.inventory.management.utils.ProductUtils;

/**
 * @author Vishal Gupta
 *
 */

@Component
public class InventoryHelperImpl implements InventoryHelper {

	@Autowired
	private InventoryDao inventoryDao;
	
	@Autowired
	private ProductUtils productUtils;
	
	@Autowired
	private DbSoldUtils dbSoldUtils;

	@Override
	public String purchaseProduct(DbProduct product) {
		return inventoryDao.purchaseProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#saleProduct(int)
	 */
	@Override
	public String saleProduct(List<Product> products) {
		
		List<DbProduct> dbProducts = new ArrayList<DbProduct>();
		for(Product product : products) {
			DbProduct dbProduct = inventoryDao.getProductByProductId(product.getSerialNumber());
			dbProduct = productUtils.updateProductQuantity(dbProduct, product);
			dbProducts.add(dbProduct);
		}
		return inventoryDao.updateProduct(dbProducts);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		
		List<DbProduct> dbProduct = inventoryDao.getAllProducts();
		return productUtils.convertDbProductToProduct(dbProduct);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getAllsalesDetails()
	 */
	@Override
	public List<DbSold> getAllsalesDetails() {
		return inventoryDao.getAllsalesDetails();
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getAllSalesByPriceRange(double, double)
	 */
	@Override
	public List<DbSold> getAllSalesByPriceRange(double initialPrice, double finalPrice) {
		return inventoryDao.getAllSalesByPriceRange(initialPrice, finalPrice);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getAllSalesByDateRange(java.util.Date, java.util.Date)
	 */
	@Override
	public List<DbSold> getAllSalesByDateRange(Date initialDate, Date finalDate) {
		return inventoryDao.getAllSalesByDateRange(initialDate, finalDate);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getAllSalesByRange(com.inventory.management.model.Range)
	 */
	@Override
	public List<DbSold> getAllSalesByRange(Range range) {
		return inventoryDao.getAllSalesByRange(range);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#addToSoldProduct(com.inventory.management.model.Product)
	 */
	@Override
	public String addToSoldProduct(List<Product> product) {
		
		List<DbSold> dbSold = dbSoldUtils.convertProductToSoldProduct(product);
		return inventoryDao.addToSoldProduct(dbSold);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getSuggestion(java.lang.String)
	 */
	@Override
	public List<Product> getSuggestion(String productName) {
		List<DbProduct> dbProduct = inventoryDao.getSuggestion(productName);
		return productUtils.convertDbProductToProduct(dbProduct);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#getProduct(java.lang.String)
	 */
	@Override
	public Product getProduct(String productName) {
		
		Product product = productUtils.convertDbProductToProduct(inventoryDao.getProduct(productName));
		return product;
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#saleProduct(com.inventory.management.model.Product)
	 */
	@Override
	public String saleProduct(Product product) {
		
		DbProduct dbProduct = inventoryDao.getProductByProductId(product.getSerialNumber());
		dbProduct = productUtils.updateProductQuantity(dbProduct, product);
		return inventoryDao.updateProduct(dbProduct);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.helper.InventoryHelper#addToSoldProduct(com.inventory.management.model.Product)
	 */
	@Override
	public String addToSoldProduct(Product product) {
		DbSold dbSold = dbSoldUtils.convertProductToSoldProduct(product);
		return inventoryDao.addToSoldProduct(dbSold);
	}
}
