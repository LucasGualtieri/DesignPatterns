package src.Command.Commands.Hottub;

import src.Command.Commands.Command;
import src.Command.Receivers.Hottub;

public class HottubOnCommand implements Command {

	Hottub hottub;

	public HottubOnCommand(Hottub hottub) { this.hottub = hottub; }

	@Override
	public void execute() {
		hottub.setTemperature(40);
		hottub.circulate();
	}

	@Override
	public void undo() { hottub.setTemperature(); }

	@Override
	public String toString() { return "HottubOnCommand"; }
}
