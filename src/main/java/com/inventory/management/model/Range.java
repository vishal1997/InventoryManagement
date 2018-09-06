/**
 * 
 */
package com.inventory.management.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vishal Gupta
 *
 */

@Setter
@Getter
public class Range {

	private double initialPrice;
	private double finalPrice;
	private Date initialDate;
	private Date finalDate;
	private String name;
}
