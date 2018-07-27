package com.cryptoworld.model.CoinMarketCap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyChangeData {

	private float price;
	private long volume_24h;
	private long market_cap;
	private double percent_change_1h;
    private double percent_change_24h; 
    private double percent_change_7d;
    
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getVolume_24h() {
		return volume_24h;
	}
	public void setVolume_24h(long volume_24h) {
		this.volume_24h = volume_24h;
	}
	public long getMarket_cap() {
		return market_cap;		
	}
	public void setMarket_cap(long market_cap) {
		this.market_cap = market_cap;
	}
	public double getPercent_change_1h() {
		return percent_change_1h;
	}
	public void setPercent_change_1h(double percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}
	public double getPercent_change_24h() {
		return percent_change_24h;
	}
	public void setPercent_change_24h(double percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}
	public double getPercent_change_7d() {
		return percent_change_7d;
	}
	public void setPercent_change_7d(double percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}
	
}
