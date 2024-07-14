package Observer2;

public class WeatherData implements Subject {
	
	float temperature, humidity, pressure;

	public WeatherData() {}

	public void measurementsChanged() {}

	public float getTemperature() { return 0.0f; }
	public float getHumidity() { return 0.0f; }
	public float getPressure() { return 0.0f; }

	@Override
	public void registerObserver() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'registerObserver'");
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeObserver'");
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
	}
}
