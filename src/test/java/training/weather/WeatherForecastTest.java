package training.weather;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class WeatherForecastTest {
	WeatherForecast weatherForecast;

	@Test
	public void getCityWeatherTest() throws IOException {
		String forecast = weatherForecast.getCityWeather("Madrid", LocalDate.now());
		Assert.assertEquals(ForecastEnum.getEnumByCode(2).getDescription(), "Partly cloudy");
		Assert.assertFalse(forecast.isEmpty());
	}

	@Test
	public void IfDateBefore() throws IOException {
		String forecast = weatherForecast.getCityWeather("Madrid", LocalDate.of(2000,01,01));
		Assert.assertEquals("", forecast);
	}

	@Test
	public void IfDatetimeIsNull() throws IOException {
		Optional<String> opt = Optional.of(WeatherForecast.getCityWeather("Madrid", null));
		Assert.assertTrue(opt.isPresent());
	}
}
