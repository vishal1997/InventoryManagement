/**
 * 
 */
package com.inventory.management.dbmodel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.dbmodel.DbProduct;

/**
 * @author Vishal Gupta
 *
 */

@Repository
public interface ProductRepository extends MongoRepository<DbProduct, String> {

	public DbProduct findBySerialNumber(int serialNumber);
	public boolean deleteBySerialNumber(int serialNumber);
	public DbProduct findByProductName(String productName);
}
