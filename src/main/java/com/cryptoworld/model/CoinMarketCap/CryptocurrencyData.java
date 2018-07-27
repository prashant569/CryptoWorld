package com.cryptoworld.model.CoinMarketCap;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptocurrencyData {

	private HashMap<String, Cryptocurrency> data;

	private Metadata metadata;

	public HashMap<String, Cryptocurrency> getData() {
		return data;
	}

	public void setData(HashMap<String, Cryptocurrency> data) {
		this.data = data;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	

	
}
