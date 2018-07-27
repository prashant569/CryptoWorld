package com.cryptoworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cryptoworld.model.CoinMarketCap.CryptocurrencyData;
import com.cryptoworld.repository.CoinMarketCapDao;

@Service
public class CoinMarketCapServiceImpl implements CoinMarketCapService {

	@Autowired
	CoinMarketCapDao coinMarketCapDao;

	@Override
	public CryptocurrencyData getAllTickerData() {
			
		return coinMarketCapDao.getAllTickerData();
	}
	
	
}
