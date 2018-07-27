package com.cryptoworld.model.CoinMarketCap;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cryptocurrency {

	private int id;
	private String name;
	private String symbol;
	private String website_slug;
	private int rank;
	private long circulating_supply;
	private long total_supply;
	private long max_supply;
	private HashMap<String,CurrencyChangeData> quotes;
	private long last_updated;
	
	public long getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(long last_updated) {
		this.last_updated = last_updated;
	}
	public long getTotal_supply() {
		return total_supply;
	}
	public void setTotal_supply(long total_supply) {
		this.total_supply = total_supply;
	}
	public long getMax_supply() {
		return max_supply;
	}
	public void setMax_supply(long max_supply) {
		this.max_supply = max_supply;
	}
	public HashMap<String, CurrencyChangeData> getQuotes() {
		return quotes;
	}
	public void setQuotes(HashMap<String, CurrencyChangeData> quotes) {
		this.quotes = quotes;
	}
	public void setCirculating_supply(long circulating_supply) {
		this.circulating_supply = circulating_supply;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getWebsite_slug() {
		return website_slug;
	}
	public void setWebsite_slug(String website_slug) {
		this.website_slug = website_slug;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getCirculating_supply() {
		return circulating_supply;
	}
	
	
}
