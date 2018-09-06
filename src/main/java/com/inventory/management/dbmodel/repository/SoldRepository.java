/**
 * 
 */
package com.inventory.management.dbmodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;


/**
 * @author Vishal Gupta
 *
 */

@Repository
public interface SoldRepository extends MongoRepository<DbSold, String>{

	public DbProduct findByInvoiceNumber(int invoiceNumber);
}
