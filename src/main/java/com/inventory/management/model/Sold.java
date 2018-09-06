/**
 * 
 */
package com.inventory.management.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vishal Gupta
 *
 */
@Setter
@Getter
public class Sold {
	
	@Id
	private String invoiceNumber;
	private int serialNumber;
	private int quantity;
	private int price;
	private Date date;
}
