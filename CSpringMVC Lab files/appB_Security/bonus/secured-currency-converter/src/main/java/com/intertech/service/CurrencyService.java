package com.intertech.service;

import javax.annotation.security.RolesAllowed;

//@Secured("ROLE_BANKER")
@RolesAllowed({ "ROLE_ADMIN" })
public interface CurrencyService {
	public double convertYentoUSD(double yen);

	public double convertEurotoUSD(double euro);

	public double convertUSDtoYen(double usd);

	public double convertUSDtoEuro(double usd);

	public double getEuroRate();

	public double getYenRate();
}
