package src.Command.Commands.CeilingFan;

import src.Command.Commands.Command;
import src.Command.Receivers.CeilingFan;

public class CeilingFanLowCommand implements Command {

	private CeilingFan ceilingFan;
	private CeilingFanState lastState;

	public CeilingFanLowCommand(CeilingFan ceilingFan) { this.ceilingFan = ceilingFan; }

	@Override
	public void execute() {

		lastState = ceilingFan.getState();
		ceilingFan.low();
	}

	@Override
	public void undo() { ceilingFan.setState(lastState); }

	@Override
	public String toString() { return "CeilingFanLowCommand"; }
}
