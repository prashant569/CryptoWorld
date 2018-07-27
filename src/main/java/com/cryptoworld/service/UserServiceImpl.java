package com.cryptoworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cryptoworld.model.UserProfile;
import com.cryptoworld.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserRepository userDao;

	@Override
	public UserProfile findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public void add(UserProfile userProfile) {
		userDao.add(userProfile);
	}
	
}
