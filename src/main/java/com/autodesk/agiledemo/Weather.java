package com.autodesk.agiledemo;

import java.util.HashMap;
import java.util.Map;

public class Weather {
	private String city;
	private String region;
	private String country;
	private double temperature;
	private String condition;
	private String humidity;
	private String windSpeed;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWearingAdvice() {
		if(isTemperatureOutOfRange() ||isConditionUncovered())
			return "No Advice";
		Map<String, String> map = new HashMap<>();
		map.put("Rainingtrue","Umbrella, T-shirt");
		map.put("Rainingfalse","Raincoat");
		map.put("Sunnytrue","T-shirt");
		map.put("Sunnyfalse","Shirts");
		return map.get(this.condition+String.valueOf(isHot()));
		
	}
	private boolean isHot() {
		return this.temperature>=70d && this.temperature<80d;
	}
	private boolean isTemperatureOutOfRange() {
		return this.temperature>=80d || this.temperature <=59d;
	}
	private boolean isConditionUncovered() {
		return !this.condition.equals("Sunny") && !this.condition.equals("Raining");
	}	
}