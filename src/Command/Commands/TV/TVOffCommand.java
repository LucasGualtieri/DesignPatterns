package src.Command.Commands.TV;

import src.Command.Commands.Command;
import src.Command.Receivers.TV;

public class TVOffCommand implements Command {

	TV tv;

	public TVOffCommand(TV tv) { this.tv = tv; }

	@Override
	public void execute() { tv.off(); }

	@Override
	public void undo() { tv.on(); }

	@Override
	public String toString() { return "TVOffCommand"; }
}
