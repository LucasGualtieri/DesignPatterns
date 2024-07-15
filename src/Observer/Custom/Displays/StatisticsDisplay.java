package src.Observer.Custom.Displays;

import src.Observer.Custom.Observer;
import src.Observer.Custom.Subject;
import src.Observer.Custom.WeatherData;

public class StatisticsDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Subject weatherData;

	private float temperatureSum, minTemperature, maxTemperature, avgTemperature;
	private int temperaturesMeasured;

	public StatisticsDisplay(Subject weatherData) {

		this.weatherData = weatherData;
		weatherData.addObserver(this);

		temperaturesMeasured = 0;
		temperatureSum = 0.0f;
		minTemperature = Float.MAX_VALUE;
		maxTemperature = Float.MIN_VALUE;
	}

	@Override
	public void update(Subject subject, Object data) {

		if (subject instanceof WeatherData) {

			WeatherData weatherData = (WeatherData)subject;

			float temperature = weatherData.getTemperature();

			temperatureSum += temperature;
			temperaturesMeasured++;
			avgTemperature = temperatureSum / temperaturesMeasured;

			minTemperature = Math.min(minTemperature, temperature);
			maxTemperature = Math.max(maxTemperature, temperature);

			diplay();
		}
	}

	@Override
	public void diplay() {

		System.out.println("Weather Stats:");
		System.out.printf("Average temperature: %.2f° F\n", avgTemperature);
		System.out.printf("Minimum temperature: %.2f° F\n", minTemperature);
		System.out.printf("Maximum temperature: %.2f° F\n\n", maxTemperature);
	}

	@Override
	public String toString() { return "Statistics Display"; }
}
