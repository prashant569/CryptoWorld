package com.cryptoworld.service;

import com.cryptoworld.model.CoinMarketCap.CryptocurrencyData;

public interface CoinMarketCapService {

	public CryptocurrencyData getAllTickerData();
}
