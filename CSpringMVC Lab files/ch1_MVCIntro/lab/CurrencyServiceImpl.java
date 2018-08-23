package com.intertech.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Value("#{1.36}")
	private double euroRate;
	@Value("#{104.42}")
	private double yenRate;

	public double convertYentoUSD(double yen) {
		return yen * yenRate;
	}

	public double convertEurotoUSD(double euro) {
		return euro * euroRate;
	}

	public double convertUSDtoYen(double usd) {
		return usd / yenRate;
	}

	public double convertUSDtoEuro(double usd) {
		return usd / euroRate;
	}

	public double getEuroRate() {
		return euroRate;
	}

	public void setEuroRate(double euroRate) {
		this.euroRate = euroRate;
	}

	public double getYenRate() {
		return yenRate;
	}

	public void setYenRate(double yenRate) {
		this.yenRate = yenRate;
	}

}
