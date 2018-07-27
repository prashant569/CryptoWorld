package com.cryptoworld.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cryptoworld.model.UserProfile;
import com.cryptoworld.model.CoinMarketCap.CoinMarketCap;
import com.cryptoworld.model.CoinMarketCap.Cryptocurrency;
import com.cryptoworld.model.CoinMarketCap.CryptocurrencyData;
import com.cryptoworld.model.CoinMarketCap.CurrencyChangeData;
import com.cryptoworld.service.CoinMarketCapService;
import com.cryptoworld.service.UserService;



@Controller
public class LoginAndRegisterController {

	@Autowired
	UserService userService;
	
	@Autowired
	CoinMarketCapService coinMarketCapService;
	
	@RequestMapping("/")
	public ModelAndView loginForm(@RequestParam Optional<String> error, Principal principal) {

		ModelAndView mv = new ModelAndView();	
		
		if(principal==null) {
			
			mv.addObject("userProfile",new UserProfile());
			mv.addObject("loginFormClassValue","active");
			mv.setViewName("LoginAndRegister/LoginAndRegister");
			if(error.isPresent()) {
				mv.addObject("errorMessage", "Bad Credentials");
			}
		}
		else {
			
			mv.setViewName("redirect:/home");
		}
		
		
		return mv;
	}
	
	
	/*@RequestMapping("/home")
	public String homePage(@RequestParam Optional<String> error,Principal principal) throws Exception {

		if(principal==null)
			throw new Exception("Principal cannot be null at home page : User is not logged in.");
		
		UserProfile userProfile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ModelAndView mv = new ModelAndView();	
		//mv.addObject("name", userProfile.getFirstName() + " " + userProfile.getLastName());
		
		return "redirect:/cryptocurrency/coinmarketcap";	
		
	}*/
	
	@GetMapping("/home")
	public ModelAndView list(Principal principal) throws Exception { 
		
		if(principal==null)
			throw new Exception("Principal cannot be null at home page : User is not logged in.");
		
		UserProfile userProfile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView mv = new ModelAndView("home");
		
		CryptocurrencyData coinMarketCapFullData = coinMarketCapService.getAllTickerData();
		
		if(coinMarketCapFullData==null)
		{
			mv.addObject("coinMarketCapFullData", "No Data to display at the moment");
		}
		else
		{
			mv.addObject("coinMarketCapFullData",coinMarketCapFullData );
		}
		
		return mv;
		
	}

	@RequestMapping("/register")
	public ModelAndView showRegisterForm(Principal principal) {
		
		ModelAndView mv = new ModelAndView();
		
		if(principal==null) {
			mv.addObject("userProfile",new UserProfile());
			mv.addObject("registerFormClassValue","active");
			mv.setViewName("LoginAndRegister/LoginAndRegister");
		}
		else {
			
			mv.setViewName("redirect:/home");
		}
		
		return mv;
	}
	
	
	
	@PostMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute UserProfile userProfile,Principal principal) {
		
		// sha 256 password encryption using Apache Commons Codec » 1.9
		String passwordSha256Hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(userProfile.getPassword()); 
		userService.add(new UserProfile(userProfile.getFirstName(),userProfile.getLastName(),userProfile.getUsername(), passwordSha256Hex));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@RequestMapping("/checkForExistingUsername")
	@ResponseBody
	public String checkForExistingUsername(@RequestParam("username") String username) {
		
		UserProfile user = null;		
		String errorMessage = null;
		
		try {
			user = userService.findByUsername(username);
		}
		catch (Exception ex) {
			System.out.println("Exception :" + ex);
			return "Something unexpected happen. Please try again";
		}
		
		finally {
			if(user != null) {
				errorMessage = "Username already exist";
			}
			return errorMessage;
		}	
	}
	
	
	
}
