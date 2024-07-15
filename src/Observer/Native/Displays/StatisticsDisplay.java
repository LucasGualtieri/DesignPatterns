package src.Observer.Native.Displays;

import java.util.Observable;
import java.util.Observer;

import src.Observer.Native.WeatherData;

@SuppressWarnings("deprecation")
public class StatisticsDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Observable observable;

	private float temperatureSum, minTemperature, maxTemperature, avgTemperature;
	private int temperaturesMeasured;

	public StatisticsDisplay(Observable observable) {

		this.observable = observable;
		observable.addObserver(this);

		temperaturesMeasured = 0;
		temperatureSum = 0.0f;
		minTemperature = Float.MAX_VALUE;
		maxTemperature = Float.MIN_VALUE;
	}

	@Override
	public void update(Observable observable, Object object) {

		if (observable instanceof WeatherData) {

			WeatherData weatherData = (WeatherData)observable;

			float temperature = weatherData.getTemperature();

			temperatureSum += temperature;
			temperaturesMeasured++;
			avgTemperature = temperatureSum / temperaturesMeasured;

			minTemperature = Math.min(minTemperature, temperature);
			maxTemperature = Math.max(maxTemperature, temperature);
			
			display();
		}
	}

	@Override
	public void display() {

		System.out.println("Weather Stats:");
		System.out.printf("Average temperature: %.2f° F\n", avgTemperature);
		System.out.printf("Minimum temperature: %.2f° F\n", minTemperature);
		System.out.printf("Maximum temperature: %.2f° F\n\n", maxTemperature);
	}

	@Override
	public String toString() { return "Statistics Display"; }
}
