package src.Command.Commands.GarageDoor;

import src.Command.Commands.Command;
import src.Command.Receivers.GarageDoor;

public class GarageDoorUpCommand implements Command {

	private GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) { this.garageDoor = garageDoor; }
	
	@Override
	public void execute() { garageDoor.up(); }
	
	@Override
	public void undo() { garageDoor.down(); }

	@Override
	public String toString() { return "GarageDoorUpCommand"; }
}
