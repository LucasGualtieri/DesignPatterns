package src.Observer.Native.Displays;

import java.util.Observable;
import java.util.Observer;
import src.Observer.Native.WeatherData;

@SuppressWarnings("deprecation")
public class CurrentConditionsDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Observable observable;

	private float temperature, humidity;

	public CurrentConditionsDisplay(Observable observable) {

		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		
		if (observable instanceof WeatherData) {

			WeatherData weatherData = (WeatherData)observable;

			temperature = weatherData.getTemperature();
			humidity = weatherData.getHumidity();

			display();
		}
	}

	@Override
	public void display() {

		System.out.println("Current conditions:");
		System.out.printf("Temperature: %.2f° F\n", temperature);
		System.out.printf("Humidity: %.2f%%\n\n", humidity);
	}

	@Override
	public String toString() { return "Current Conditions Display"; }
}
