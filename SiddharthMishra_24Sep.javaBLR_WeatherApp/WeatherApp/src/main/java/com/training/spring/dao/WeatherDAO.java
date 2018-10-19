
	
	package com.training.spring.dao;

	import java.util.List;

	import com.training.spring.model.Person;
	import com.training.spring.model.Weather;

	public interface WeatherDAO {
		
		public void addcity(Weather c);
		public List<Weather> listcity();
		public int maxCityId();

	}


