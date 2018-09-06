package com.inventory.management.mongodb.config;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.inventory.management.common.Constants.Database;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * MongoDB Configuration
 * @author Vishal
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.inventory.management.dbmodel.repository"})

public class MongoConfiguration extends AbstractMongoConfiguration {


	@Override
	protected String getDatabaseName() {
		return Database.DATABASE;
	}

	@Override
	public Mongo mongo() throws Exception {
		
        ServerAddress serverAddress = new ServerAddress(Database.ADDRESS, Database.PORT);
        MongoCredential credential = MongoCredential.createCredential(Database.USER, Database.DATABASE, Database.PWD.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(4).socketKeepAlive(true).build();
        
        Mongo mongo = new MongoClient(serverAddress, Arrays.asList(credential),options);

        return mongo;
	}
	
    @Bean(name="MongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), Database.DATABASE);
    }
    

}
