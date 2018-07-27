package com.cryptoworld.model.CoinMarketCap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {

	private String error;
	private int num_cryptocurrencies;
	private long timestamp;
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getNum_cryptocurrencies() {
		return num_cryptocurrencies;
	}
	public void setNum_cryptocurrencies(int num_cryptocurrencies) {
		this.num_cryptocurrencies = num_cryptocurrencies;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
