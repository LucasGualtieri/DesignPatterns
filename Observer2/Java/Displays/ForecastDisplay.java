package Observer2.Java.Displays;

import java.util.Observable;
import java.util.Observer;

import Observer2.Java.WeatherData;

@SuppressWarnings("deprecation")
public class ForecastDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Observable observable;

	private float temperature, humidity, pressure;

	public ForecastDisplay(Observable observable) {

		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {

		if (observable instanceof WeatherData) {

			WeatherData weatherData = (WeatherData)observable;

			temperature = weatherData.getTemperature();
			humidity = weatherData.getHumidity();
			pressure = weatherData.getPressure();

			display();
		}
	}

	@Override
	public void display() {

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
