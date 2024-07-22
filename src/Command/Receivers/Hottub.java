package src.Command.Receivers;

public class Hottub {

	public Hottub() {}

	public void jetsOn() {}

	public void jetsOff() {}

	public void circulate() {
		System.out.println("Hottub is bubbling!");
	}

	public void setTemperature(int temperature) {
		System.out.println("Hottub is heating to a steaming " + temperature + " degrees.");
	}

	public void setTemperature() {
		System.out.println("Hottub is cooling to ambient temperature.");
	}
}
