/**
 * 
 */
package com.inventory.management.dbmodel;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vishal Gupta
 *
 */
@Setter
@Getter
@Document(collection="sold")
public class DbSold {

	@Id
	private String invoiceNumber;
	private int serialNumber;
	private int quantity;
	private int price;
	private Date date;
}
