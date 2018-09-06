/**
 * 
 */
package com.inventory.management.dbmodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.dbmodel.DbVender;

/**
 * @author Vishal Gupta
 *
 */

@Repository
public interface VenderRepository extends MongoRepository<DbVender, String> {

}
