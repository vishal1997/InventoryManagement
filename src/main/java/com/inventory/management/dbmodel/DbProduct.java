/**
 * 
 */
package com.inventory.management.dbmodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vishal Gupta
 *
 */

@Getter
@Setter
@Document(collection="products")
public class DbProduct {

	@Id
	private int serialNumber;
	private String productName;
	private int quantity;
	private String venderName;
	private double price;
}
