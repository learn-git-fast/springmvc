package com.intertech.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.intertech.service.CurrencyServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class TestCurrencyConverterController {
	private MockMvc mockMvc;

	@Before
	public void setup() {
		CurrencyConverterController controller = new CurrencyConverterController();
		controller.setConverterService(new CurrencyServiceImpl());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testConvertValidAmount() throws Exception {
		ModelAndView mAndV = mockMvc
				.perform(get("/convert.request").param("usd", "500"))
				.andReturn().getModelAndView();
		Assert.assertTrue("view does not match",
				"currencydisplay".equals(mAndV.getViewName()));
		Assert.assertEquals(500.0, mAndV.getModel().get("usd"));
		Assert.assertEquals(Double.POSITIVE_INFINITY,
				mAndV.getModel().get("euro"));
		Assert.assertEquals(Double.POSITIVE_INFINITY,
				mAndV.getModel().get("yen"));
	}

	@Test
	public void testConvertInvalidAmount() throws Exception {
		ModelAndView mAndV = mockMvc
				.perform(get("/convert.request").param("usd", "a pile"))
				.andReturn().getModelAndView();
		Assert.assertTrue("view does not match",
				"error".equals(mAndV.getViewName()));
	}

}
