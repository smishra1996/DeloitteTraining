package com.training.spring.service;

import java.util.List;

import com.training.spring.model.Weather;

public interface WeatherService {
	
	public void addcity(Weather c);
	List<Weather>listcity();
	public int maxCityId();

}
