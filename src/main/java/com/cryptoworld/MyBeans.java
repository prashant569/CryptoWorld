package com.cryptoworld;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Component
public class MyBeans {

	@Bean
    public MongoDbFactory mongoDbFactory() {
    	return new SimpleMongoDbFactory(new MongoClient("localhost",27017), "SecurityTest");
    }
    
    @Bean
    public MongoTemplate mongoTemplate() {
    	return new MongoTemplate(mongoDbFactory());
    }

   
   
}