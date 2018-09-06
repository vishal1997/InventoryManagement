/**
 * 
 */
package com.inventory.management.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vishal Gupta
 *
 */

@Getter
@Setter
public class Product {

	private int serialNumber;
	private String productName;
	private int quantity;
	private double price;
}
