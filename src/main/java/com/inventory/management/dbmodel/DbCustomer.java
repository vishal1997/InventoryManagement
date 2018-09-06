/**
 * 
 */
package com.inventory.management.dbmodel;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vishal Gupta
 *
 */
@Getter
@Setter
@Document(collection="customer")
public class DbCustomer {

	String name;
	String address;
	Date date;
}
