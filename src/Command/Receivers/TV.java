package src.Command.Receivers;

public class TV {

	private String location;

	public TV(String location) { this.location = location; }

	public void on() {
		System.out.println(location + " TV is on.");
	}

	public void off() {
		System.out.println(location + " TV is off.");
	}

	public void setInputChannel(String inputChannel) {
		System.out.printf("%s TV channel is set for %s.\n", location, inputChannel);
	}

	public void setVolume() {}
}
