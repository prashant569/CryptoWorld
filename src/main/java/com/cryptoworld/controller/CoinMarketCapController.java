package com.cryptoworld.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cryptoworld.model.UserProfile;
import com.cryptoworld.model.CoinMarketCap.Cryptocurrency;
import com.cryptoworld.model.CoinMarketCap.CryptocurrencyData;
import com.cryptoworld.model.CoinMarketCap.CurrencyChangeData;
import com.cryptoworld.service.CoinMarketCapService;

@Controller
public class CoinMarketCapController {

	@Autowired
	CoinMarketCapService coinMarketCapService;
	
	@PreAuthorize("isAuthenticated()") /// this is not required since we are using spring security and we have defined which URIs are open to all.
	@GetMapping("/coinMarketCap")
	public ModelAndView coinMarketCap(Principal principal) { 
		
		System.out.println("in the coinMarketCap method");
		
		// this should never be executed
		if(principal==null)
			throw new AccessDeniedException("Principal cannot be null at home page : User is not logged in.");
		
		UserProfile userProfile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView mv = new ModelAndView("coinMarketCap");
		
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
	
}
