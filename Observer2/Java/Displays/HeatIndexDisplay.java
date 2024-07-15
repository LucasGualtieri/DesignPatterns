package Observer2.Java.Displays;

import java.util.Observable;
import java.util.Observer;

import Observer2.Java.WeatherData;

@SuppressWarnings("deprecation")
public class HeatIndexDisplay implements DisplayElement, Observer {

	@SuppressWarnings("unused")
	private Observable observable;

	private float temperature, humidity;

	public HeatIndexDisplay(Observable observable) {

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

	float heatIndex() {

		float T = temperature, RH = humidity;
		
		return (float)(
		16.923 + 1.85212e-1 * T
		+ 5.37941 * RH
		- 1.00254e-1 * T * RH
		+ 9.41695e-3 * T * T
		+ 7.28898e-3 * RH * RH
		+ 3.45372e-4 * T * T * RH
		- 8.14971e-4 * T * RH * RH
		+ 1.02102e-5 * T * T * RH * RH
		- 3.8646e-5 * T * T * T
		+ 2.91583e-5 * RH * RH * RH
		+ 1.42721e-6 * T * T * T * RH
		+ 1.97483e-7 * T * RH * RH * RH
		- 2.18429e-8 * T * T * T * RH * RH
		+ 8.43296e-10 * T * T * RH * RH * RH
		- 4.81975e-11 * T * T * T * RH * RH * RH);
	}

	@Override
	public void display() {
		System.out.printf("Heat index is %.2f° F\n\n", heatIndex());
	}

	@Override
	public String toString() { return "Heat Index Display"; }
}
