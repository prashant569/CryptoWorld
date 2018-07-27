package com.cryptoworld.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cryptoworld.model.CoinMarketCap.CryptocurrencyData;


@Repository
public class CoinMarketCapDaoImpl implements CoinMarketCapDao {

	
	RestTemplate restTemplate;
	//private final String coinMarketCapApiVersion = "v2";
	
	public CryptocurrencyData getAllTickerData() {
		
		CryptocurrencyData cryptocurrencyData = null;
		restTemplate = new RestTemplate();
		String allTickerDataUrl = "https://api.coinmarketcap.com/" + coinMarketCapApiVersion + "/ticker/?" + "&sort=id";
		
		try {
			System.out.println("url = " + allTickerDataUrl);
			cryptocurrencyData = restTemplate.getForObject(allTickerDataUrl,CryptocurrencyData.class);
		}
		catch (Exception e)
		{
			System.out.println("Exception : " + e);
		}
		
		finally {
			return cryptocurrencyData;
		}
		
		
	}
}
