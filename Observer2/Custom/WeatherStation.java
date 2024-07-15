package Observer2.Custom;

import Observer2.Custom.Displays.CurrentConditionsDisplay;
import Observer2.Custom.Displays.ForecastDisplay;
import Observer2.Custom.Displays.HeatIndexDisplay;
import Observer2.Custom.Displays.StatisticsDisplay;

public class WeatherStation {

	public static void main(String[] args) {

		WeatherData weatherData = new WeatherData();

		@SuppressWarnings("unused")
		Observer[] displays = new Observer[] {
			new CurrentConditionsDisplay(weatherData),
			new StatisticsDisplay(weatherData),
			new ForecastDisplay(weatherData),
			new HeatIndexDisplay(weatherData),
		};

		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println("-------------------------------\n");

		weatherData.setMeasurements(68, 40, 1013.25f);
		System.out.println("-------------------------------\n");

		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
