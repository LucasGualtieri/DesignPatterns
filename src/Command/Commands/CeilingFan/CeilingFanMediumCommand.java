package src.Command.Commands.CeilingFan;

import src.Command.Commands.Command;
import src.Command.Receivers.CeilingFan;

public class CeilingFanMediumCommand implements Command {

	private CeilingFan ceilingFan;
	private CeilingFanState lastState;

	public CeilingFanMediumCommand(CeilingFan ceilingFan) { this.ceilingFan = ceilingFan; }

	@Override
	public void execute() {

		lastState = ceilingFan.getState();
		ceilingFan.medium();
	}

	@Override
	public void undo() { ceilingFan.setState(lastState); }

	@Override
	public String toString() { return "CeilingFanMediumCommand"; }
}
