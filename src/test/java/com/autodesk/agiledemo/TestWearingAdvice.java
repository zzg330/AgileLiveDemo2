package com.autodesk.agiledemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWearingAdvice {

	Weather weather = new Weather();
	@Test
	public void shirts_when_temperature_60_and_condition_sunny() {
		assertWearingAdviceEquals("Sunny", 60d, "Shirts");
	}
	@Test
	public void raincoat_when_temperature_60_and_condition_raining() {
		assertWearingAdviceEquals("Raining", 60d, "Raincoat");
	}
	
	@Test
	public void tshirt_when_temperature_70_and_condition_sunny() {
		assertWearingAdviceEquals("Sunny", 70d, "T-shirt");

	}
	@Test
	public void umbrella_and_tshirt_when_temperature_70_and_condition_raining() {
		assertWearingAdviceEquals("Raining", 70d, "Umbrella, T-shirt");

	}
	@Test
	public void no_advice_when_condition_unconvered() {
		assertWearingAdviceEquals("Cloudy", 70d, "No Advice");
	}
	@Test
	public void no_advice_when_temperature_out_of_range() {
		assertWearingAdviceEquals("Sunny", 80d, "No Advice");
		assertWearingAdviceEquals("Cloudy", 59d, "No Advice");
		
	}
	

	private void assertWearingAdviceEquals(String givenCondition, double givenTemerature, String expectedWearingAdvice) {
		weather.setCondition(givenCondition);
		weather.setTemperature(givenTemerature);
		assertEquals(expectedWearingAdvice,weather.getWearingAdvice());
	}
}
