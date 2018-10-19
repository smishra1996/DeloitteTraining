package com.training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.dao.WeatherDAO;
import com.training.spring.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	private WeatherDAO weatherDAO;

	public void setWeatherDAO(WeatherDAO weatherDAO) {
		this.weatherDAO = weatherDAO;
	}
	
	public WeatherDAO getWeatherDAO() {
		return weatherDAO;
	}
	
	
	@Override
	@Transactional
	public void addcity(Weather c) {
	this.weatherDAO.addcity(c);	
		
	}


	@Override
	@Transactional
	public List<Weather> listcity() {
		return this.weatherDAO.listcity();
	}


	@Override
	@Transactional
	public int maxCityId() {
		// TODO Auto-generated method stub
		return this.weatherDAO.maxCityId();
	}
	

}
