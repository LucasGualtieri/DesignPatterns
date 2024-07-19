package src.Command.Commands.CeilingFan;

import src.Command.Commands.Command;
import src.Command.Receivers.CeilingFan;

public class CeilingFanOffCommand implements Command {

	private CeilingFan ceilingFan;
	private CeilingFanState lastState;

	public CeilingFanOffCommand(CeilingFan ceilingFan) { this.ceilingFan = ceilingFan; }

	@Override
	public void execute() {

		lastState = ceilingFan.getState();
		ceilingFan.off();
	}

	@Override
	public void undo() { ceilingFan.setState(lastState); }

	@Override
	public String toString() { return "CeilingFanOffCommand"; }
}
