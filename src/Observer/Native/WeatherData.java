package src.Observer.Native;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class WeatherData extends Observable {
	
	private float temperature, humidity, pressure;

	public WeatherData() { }

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {

		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		measurementsChanged();
	}

	public float getTemperature() { return temperature; }
	public float getHumidity() { return humidity; }
	public float getPressure() { return pressure; }
}
