package src.Command.Commands.TV;

import src.Command.Commands.Command;
import src.Command.Receivers.TV;

public class TVOnCommand implements Command {

	TV tv;

	public TVOnCommand(TV tv) { this.tv = tv; }

	@Override
	public void execute() {
		tv.on();
		tv.setInputChannel("DVD");
	}

	@Override
	public void undo() { tv.off(); }

	@Override
	public String toString() { return "TVOnCommand"; }
}
