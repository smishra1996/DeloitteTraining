	package com.training.spring.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table(name="weather")
	public class Weather {

		@Id
		@Column(name="cityId")
		private int cityId;
		
		
		public void setCityId(int cityId) {
			this.cityId = cityId;
		}
		
		public int getCityId() {
			return cityId;
		}
		public int setCityId() {
			return cityId;
		}
		
		@Column(name="search")
		private String search; 


	

		public String getCity() {
			return search;
		}

		public void setCity(String city) {
			this.search = city;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

		@Override
		public String toString() {
			return "Weather [cityId=" + cityId + ", search=" + search + "]";
		}

	

	}



