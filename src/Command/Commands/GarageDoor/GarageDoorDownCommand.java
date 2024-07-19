package src.Command.Commands.GarageDoor;

import src.Command.Commands.Command;
import src.Command.Receivers.GarageDoor;

public class GarageDoorDownCommand implements Command {

	private GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) { this.garageDoor = garageDoor; }
	
	@Override
	public void execute() { garageDoor.down(); }
	
	@Override
	public void undo() { garageDoor.up(); }

	@Override
	public String toString() { return "GarageDoorDownCommand"; }
}

