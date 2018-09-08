/**
 * 
 */
package com.inventory.management.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.inventory.management.common.Constants.StatusCode;
import com.inventory.management.dao.InventoryDao;
import com.inventory.management.dbmodel.DbProduct;
import com.inventory.management.dbmodel.DbSold;
import com.inventory.management.dbmodel.repository.ProductRepository;
import com.inventory.management.dbmodel.repository.SoldRepository;
import com.inventory.management.model.Range;
import com.mongodb.WriteResult;

/**
 * @author Vishal Gupta
 *
 */

@Component
public class InventoryDaoImpl implements InventoryDao {

	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private SoldRepository soldRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String purchaseProduct(DbProduct product) {
		
		try {
			productRepo.insert(product);
		} catch(Exception ex) {
			throw new RuntimeException("Some error occurred during product purchase");
		}
		return StatusCode.SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#saleProduct(int)
	 */
	@Override
	public String saleProduct(List<Integer> productId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getProductByProductId(int)
	 */
	@Override
	public DbProduct getProductByProductId(int productId) {
		
		return productRepo.findBySerialNumber(productId);
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#updateProduct(com.inventory.management.dbmodel.DbProduct)
	 */
	@Override
	public String updateProduct(List<DbProduct> dbProduct) {
		
		try {
			productRepo.save(dbProduct);
			deleteProductWithQuantityZero();
			return StatusCode.SUCCESS;
		} catch(Exception ex) {
			throw new RuntimeException("Unable to update product details");
		}
	}
	
	public WriteResult deleteProductWithQuantityZero() {
		try {
			Query query = new Query(Criteria.where("quantity").lte(0));
			return mongoTemplate.remove(query, DbProduct.class);
		} catch(Exception ex) {
			throw new RuntimeException("No data found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getAllProducts()
	 */
	@Override
	public List<DbProduct> getAllProducts() {
		
		try {
			return productRepo.findAll();
		} catch(Exception ex) {
			throw new RuntimeException("No product found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getAllsalesDetails()
	 */
	@Override
	public List<DbSold> getAllsalesDetails() {
		
		try {
			return soldRepo.findAll();
		} catch(Exception ex) {
			throw new RuntimeException("No details found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getAllSalesByPriceRange(double, double)
	 */
	@Override
	public List<DbSold> getAllSalesByPriceRange(double initialPrice, double finalPrice) {
		
		try {
			Query query = new Query(
					    Criteria.where("price").lte(finalPrice).gte(initialPrice)
					);
			return mongoTemplate.find(query, DbSold.class);
		} catch(Exception ex) {
			throw new RuntimeException("No data found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getAllSalesByDateRange(java.util.Date, java.util.Date)
	 */
	@Override
	public List<DbSold> getAllSalesByDateRange(Date initialDate, Date finalDate) {
		
		try {
			Query query = new Query(
					Criteria.where("date").lte(finalDate).gte(initialDate)
				);
			return mongoTemplate.find(query,DbSold.class);
		} catch(Exception ex) {
			throw new RuntimeException("No data found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getAllSalesByRange(com.inventory.management.model.Range)
	 */
	@Override
	public List<DbSold> getAllSalesByRange(Range range) {
		
		try {
			Query query = new Query(
					Criteria.where("date").lte(range.getFinalDate()).gte(range.getInitialDate()).
					andOperator(
					Criteria.where("price").lte(range.getFinalPrice()).gte(range.getInitialPrice())).
					andOperator(
					Criteria.where("name").regex(range.getName()))
				);
			return mongoTemplate.find(query, DbSold.class);
		} catch(Exception ex) {
			throw new RuntimeException("No data Found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#addToSoldProduct(java.util.List)
	 */
	@Override
	public String addToSoldProduct(List<DbSold> dbSold) {
		
		try {
			soldRepo.insert(dbSold);
			return StatusCode.SUCCESS;
		} catch(Exception ex)  {
			throw new RuntimeException("Error occured");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getSuggestion(java.lang.String)
	 */
	@Override
	public List<DbProduct> getSuggestion(String productName) {
		try {
			Query query = new Query(
					Criteria.where("productName").regex(productName)
				);
			return mongoTemplate.find(query, DbProduct.class);
		} catch(Exception ex) {
			throw new RuntimeException("No data Found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#getProduct(java.lang.String)
	 */
	@Override
	public DbProduct getProduct(String productName) {
		try {
			return productRepo.findByProductName(productName);
		} catch(Exception ex) {
			throw new RuntimeException("No data Found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#updateProductSold(com.inventory.management.dbmodel.DbProduct)
	 */
	@Override
	public String updateProduct(DbProduct dbProduct) {
		try {
			productRepo.save(dbProduct);
			return StatusCode.SUCCESS;
		} catch(Exception ex) {
			throw new RuntimeException("No data found");
		}
	}

	/* (non-Javadoc)
	 * @see com.inventory.management.dao.InventoryDao#addToSoldProduct(com.inventory.management.dbmodel.DbSold)
	 */
	@Override
	public String addToSoldProduct(DbSold dbSold) {
		try {
			soldRepo.insert(dbSold);
			return StatusCode.SUCCESS;
		} catch(Exception ex) {
			throw new RuntimeException("No data found");
		}
	}
}
