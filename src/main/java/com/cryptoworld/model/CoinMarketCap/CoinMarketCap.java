package com.cryptoworld.model.CoinMarketCap;

import java.util.ArrayList;
import java.util.HashMap;

public class CoinMarketCap {

	ArrayList<HashMap<String,String>> hashmap;

	public CoinMarketCap() {

	}
	
	
	public CoinMarketCap(ArrayList<HashMap<String, String>> hashmap) {
		super();
		this.hashmap = hashmap;
	}
	
	public ArrayList<HashMap<String, String>> getHashmap() {
		return hashmap;
	}

	public void setHashmap(ArrayList<HashMap<String, String>> hashmap) {
		this.hashmap = hashmap;
	}

	
	
	
}
