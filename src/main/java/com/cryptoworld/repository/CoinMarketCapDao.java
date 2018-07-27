package com.cryptoworld.repository;

import com.cryptoworld.model.CoinMarketCap.CryptocurrencyData;

public interface CoinMarketCapDao {

	public static final String coinMarketCapApiVersion = "v2"; 
	public CryptocurrencyData getAllTickerData();
}
