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
@Setter
@Getter
@Document(collection="venders")
public class DbVender {

	@Id
	private int venderId;
	private String venderName;
	private String address;
}
