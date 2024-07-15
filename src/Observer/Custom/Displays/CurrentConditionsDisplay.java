package src.Observer.Custom.Displays;

import src.Observer.Custom.Observer;
import src.Observer.Custom.Subject;
import src.Observer.Custom.WeatherData;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Subject weatherData;

	private float temperature, humidity;

	public CurrentConditionsDisplay(Subject weatherData) {

		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	@Override
	public void update(Subject subject, Object data) {

		if (subject instanceof WeatherData) {
			
			WeatherData weatherData = (WeatherData)subject;

			temperature = weatherData.getTemperature();
			humidity = weatherData.getHumidity();

			diplay();
		}
	}

	@Override
	public void diplay() {

		System.out.println("Current conditions:");
		System.out.printf("Temperature: %.2f° F\n", temperature);
		System.out.printf("Humidity: %.2f%%\n\n", humidity);
	}

	@Override
	public String toString() { return "Current Conditions Display"; }
}
