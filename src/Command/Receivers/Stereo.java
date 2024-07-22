package src.Command.Receivers;

public class Stereo {

	private String location;

	public Stereo(String location) { this.location = location; }

	public void on() {
		System.out.println(location + " Stereo is on.");
	}

	public void off() {
		System.out.println(location + " Stereo is off.");
	}

	public void setCD() {}
	public void setDVD() {}
	public void setRadio() {}
	public void setVolume(int volume) {}
}
