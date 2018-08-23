package com.intertech.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intertech.service.CurrencyService;

@Controller
public class EuroCurrencyConverterController {

	@Autowired
	private CurrencyService converterService;

	public void setConverterService(CurrencyService converterService) {
		this.converterService = converterService;
	}

	@RequestMapping("convertEuro.request")
	protected ModelAndView convert(HttpServletRequest request) {
		try {
			double euro = 0;
			double yen = 0;
			double usd = 0;
			String euroString = request.getParameter("euro");
			if ((euroString != null) && (euroString.length() > 0)) {
				euro = Double.parseDouble(euroString);
				usd = converterService.convertEurotoUSD(euro);
				yen = converterService.convertUSDtoYen(usd);
			}
			HashMap<String, Double> map = new HashMap<String, Double>();
			map.put("usd", usd);
			map.put("euro", euro);
			map.put("yen", yen);
			return new ModelAndView("eurocurrencydisplay", map);
		} catch (NumberFormatException numberException) {
			return new ModelAndView("erroreuro");
		}
	}
}
