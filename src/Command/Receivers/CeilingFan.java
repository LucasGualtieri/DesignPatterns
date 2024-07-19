package src.Command.Receivers;

import src.Command.Commands.CeilingFan.CeilingFanState;

public class CeilingFan {

	private String location;
	private CeilingFanState state;

	public CeilingFan(String location) {

		this.location = location;
		state = CeilingFanState.OFF;
	}

	private void printState() {
		System.out.println(String.format("%s Ceiling Fan is on %s.", location, state));
	}

	public void high() {

		state = CeilingFanState.HIGH;
		printState();
	}

	public void medium() {

		state = CeilingFanState.MEDIUM;
		printState();
	}

	public void low() {

		state = CeilingFanState.LOW;
		printState();
	}

	public void off() {

		state = CeilingFanState.OFF;
		System.out.println(String.format("%s Ceiling Fan is %s.", location, state));
	}

	public CeilingFanState getState() { return state; }

	public void setState(CeilingFanState state) {

		this.state = state;
		printState();
	}
}
