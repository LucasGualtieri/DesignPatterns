package src.Observer.Native;

import src.Observer.Native.Displays.CurrentConditionsDisplay;
import src.Observer.Native.Displays.DisplayElement;
import src.Observer.Native.Displays.ForecastDisplay;
import src.Observer.Native.Displays.HeatIndexDisplay;
import src.Observer.Native.Displays.StatisticsDisplay;

public class WeatherStation {

	public static void main(String[] args) {
		
		WeatherData weatherData = new WeatherData();

		@SuppressWarnings("unused")
		DisplayElement[] displays = new DisplayElement[] {
			new HeatIndexDisplay(weatherData),
			new ForecastDisplay(weatherData),
			new StatisticsDisplay(weatherData),
			new CurrentConditionsDisplay(weatherData),
		};

		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println("-------------------------------\n");

		weatherData.setMeasurements(68, 40, 1013.25f);
		System.out.println("-------------------------------\n");

		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
