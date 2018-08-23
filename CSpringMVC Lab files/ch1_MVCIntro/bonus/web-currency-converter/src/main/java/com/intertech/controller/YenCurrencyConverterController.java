package com.intertech.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intertech.service.CurrencyService;

@Controller
public class YenCurrencyConverterController {

	@Autowired
	private CurrencyService converterService;

	public void setConverterService(CurrencyService converterService) {
		this.converterService = converterService;
	}

	@RequestMapping("convertYen.request")
	protected ModelAndView convert(HttpServletRequest request) {
		try {
			double euro = 0;
			double yen = 0;
			double usd = 0;
			String yenString = request.getParameter("yen");
			if ((yenString != null) && (yenString.length() > 0)) {
				yen = Double.parseDouble(yenString);
				usd = converterService.convertYentoUSD(yen);
				euro = converterService.convertUSDtoEuro(usd);
			}
			HashMap<String, Double> map = new HashMap<String, Double>();
			map.put("usd", usd);
			map.put("euro", euro);
			map.put("yen", yen);
			return new ModelAndView("yencurrencydisplay", map);
		} catch (NumberFormatException numberException) {
			return new ModelAndView("erroryen");
		}
	}
}
