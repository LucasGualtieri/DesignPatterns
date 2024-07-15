package src.Observer.Custom.Displays;

import src.Observer.Custom.Observer;
import src.Observer.Custom.Subject;
import src.Observer.Custom.WeatherData;

public class ForecastDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Subject weatherData;

	private float temperature, humidity, pressure;

	public ForecastDisplay(Subject weatherData) {

		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	@Override
	public void update(Subject subject, Object data) {

		if (subject instanceof WeatherData) {

			WeatherData weatherData = (WeatherData)subject;

			temperature = weatherData.getTemperature();
			humidity = weatherData.getHumidity();
			pressure = weatherData.getPressure();

			diplay();
		}
	}

	@Override
	public void diplay() {

		String forecast;

		if (pressure > 1020 && humidity < 50) forecast = "Clear skies";

		else if (pressure < 1000 && humidity > 80) forecast = "Rainy weather";

		else if (temperature > 30 && humidity > 60) forecast = "Hot && humid";

		else if (temperature < 0) forecast = "Cold weather";

		else if (1000 < pressure && pressure < 1020 && humidity < 60) forecast = "Partly cloudy";

		else forecast = "Moderate weather";

		System.out.println("Forecast: " + forecast + "\n");
	}

	@Override
	public String toString() { return "Forecast Display"; }
} 
