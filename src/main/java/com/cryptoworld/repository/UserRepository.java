package com.cryptoworld.repository;

import com.cryptoworld.model.UserProfile;


public interface UserRepository /*extends MongoRepository<UserProfile, String>*/ {
	
	public UserProfile findByUsername(String username);	
	public void add(UserProfile user);
}
