package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.spring.model.Weather;
import com.training.spring.service.WeatherService;

@Controller
public class WeatherController {
	
	private WeatherService weatherService;
	
	@Autowired(required=true)
	@Qualifier(value="weatherService")
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@RequestMapping(value = "/weatherCities", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("listPersons", this.weatherService.listcity());
		System.out.println(this.weatherService.listcity());
		return "displayCities";
	}
	
	@RequestMapping(value = "/storeCity", method = RequestMethod.GET)
	public String addPersons(Weather weather) {
		System.out.println("###########STORE CITY CALLED : "+weather);
		int maxCityId = this.weatherService.maxCityId();
		weather.setCityId(maxCityId+1);
		
		this.weatherService.addcity(weather);
		System.out.println(this.weatherService.listcity());
		return "displayCities";
	}
}
