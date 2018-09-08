/**
 * 
 */
package com.inventory.management.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.model.Product;

/**
 * @author Vishal Gupta
 *
 */

@Component
public class DbSoldUtils {

	public List<DbSold> convertProductToSoldProduct(List<Product> products) {
		
		List<DbSold> dbSoldList = new ArrayList<DbSold>();
		
		for(Product product : products) {
			
			DbSold dbSold = new DbSold();
			dbSold.setDate(new Date());
			dbSold.setInvoiceNumber(product.getSerialNumber()+""+product.getQuantity()+""+new Date());
			dbSoldList.add(dbSold);
		}
		return dbSoldList;
	}
	
public DbSold convertProductToSoldProduct(Product product) {
		
		DbSold dbSold = new DbSold();
		dbSold.setDate(new Date());
		dbSold.setInvoiceNumber(product.getSerialNumber()+""+product.getQuantity()+""+new Date());
		return dbSold;
	}
}
