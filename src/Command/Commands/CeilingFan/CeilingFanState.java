package src.Command.Commands.CeilingFan;

public enum CeilingFanState { 

	OFF, LOW, MEDIUM, HIGH;

	@Override
	public String toString() { return name().toLowerCase(); }
}

