/**
 * 
 */
package com.inventory.management.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.model.Product;

/**
 * @author Vishal Gupta
 *
 */

@Component
public class ProductUtils {

	public List<Integer> getProductIds(List<Product> products) {
		
		List<Integer> id = new ArrayList<Integer>();
		for(Product product : products) {
			id.add(product.getSerialNumber());
		}
		return id;
	}
	
	public DbProduct updateProductQuantity(DbProduct dbProduct, Product product) {
		
		if(dbProduct.getQuantity() >= product.getQuantity())
			dbProduct.setQuantity(dbProduct.getQuantity()-product.getQuantity());
		return dbProduct;
	}

	public Product convertDbProductToProduct(DbProduct dbProduct) {
		
		Product product = new Product();
		product.setPrice(dbProduct.getPrice());
		product.setProductName(dbProduct.getProductName());
		product.setQuantity(dbProduct.getQuantity());
		product.setSerialNumber(dbProduct.getSerialNumber());
		return product;
	}
	
	public List<Product> convertDbProductToProduct(List<DbProduct> dbProducts) {
		
		List<Product> product = new ArrayList<Product>();
		for(DbProduct dbProduct : dbProducts) {
			product.add(convertDbProductToProduct(dbProduct));
		}
		return product;
	}
}
