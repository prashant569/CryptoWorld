package com.cryptoworld.service;


import com.cryptoworld.model.UserProfile;


public interface UserService {

	public UserProfile findByUsername(String username);
	public void add(UserProfile userProfile);
	
}
