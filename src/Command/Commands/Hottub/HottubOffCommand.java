package src.Command.Commands.Hottub;

import src.Command.Commands.Command;
import src.Command.Receivers.Hottub;

public class HottubOffCommand implements Command {

	Hottub hottub;
	HottubOnCommand undo;

	public HottubOffCommand(Hottub hottub) {

		this.hottub = hottub;
		undo = new HottubOnCommand(hottub);
	}

	@Override
	public void execute() {
		hottub.setTemperature();
	}

	@Override
	public void undo() { undo.execute(); }

	@Override
	public String toString() { return "HottubOffCommand"; }
}
