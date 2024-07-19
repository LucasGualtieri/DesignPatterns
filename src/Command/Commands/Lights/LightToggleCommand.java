package src.Command.Commands.Lights;

import src.Command.Commands.Command;
import src.Command.Receivers.Light;

public class LightToggleCommand implements Command {

	Light light;

	private final boolean ON = true;
	private final boolean OFF = false;
	boolean state;

	public LightToggleCommand(Light light) {

		this.light = light;
		state = OFF;
	}

	public void execute() {

		if (state == OFF) {
			light.on(); 
			state = ON;
		}

		else {
			light.off();
			state = OFF;
		}
	}

	public void undo() { execute(); }

	@Override
	public String toString() { return "LightToggleCommand"; }
}
