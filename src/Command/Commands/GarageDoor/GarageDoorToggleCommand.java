package src.Command.Commands.GarageDoor;

import src.Command.Commands.Command;
import src.Command.Receivers.GarageDoor;

public class GarageDoorToggleCommand implements Command {

	private GarageDoor garageDoor;

	private final boolean UP = true;
	private final boolean DOWN = false;
	private boolean state;

	public GarageDoorToggleCommand(GarageDoor garageDoor) {

		this.garageDoor = garageDoor;
		state = DOWN;
	}
	
	@Override
	public void execute() {

		if (state == DOWN) {
			garageDoor.up(); 
			state = UP;
		}

		else {
			garageDoor.down();
			state = DOWN;
		}
	}

	@Override
	public void undo() { execute(); }

	@Override
	public String toString() { return "GarageDoorToggleCommand"; }
}
