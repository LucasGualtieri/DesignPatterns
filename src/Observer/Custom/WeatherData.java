package src.Observer.Custom;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	
	private List<Observer> observers;
	private float temperature, humidity, pressure;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	public float getTemperature() { return temperature; }
	public float getHumidity() { return humidity; }
	public float getPressure() { return pressure; }

	public void measurementsChanged() {
		notifyObservers(null);
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {

		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		measurementsChanged();
	}

	@Override
	public void addObserver(Observer observer) { observers.add(observer); }

	@Override
	public void removeObserver(Observer observer) throws IllegalArgumentException {

		int i = observers.indexOf(observer);

		if (i == -1) {
			throw new IllegalArgumentException(observer + " is not subscribed.");
		}

		observers.remove(i);
	}

	@Override
	public void notifyObservers(Object data) {

		for (Observer observer : observers) {
			observer.update(this, data);
		}
	}
}
