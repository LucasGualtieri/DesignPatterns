package src.Command.Commands.Lights;

import src.Command.Commands.Command;
import src.Command.Receivers.Light;

public class LightOffCommand implements Command {

	Light light;

	public LightOffCommand(Light light) { this.light = light; }

	@Override
	public void execute() { light.off(); }

	@Override
	public void undo() { light.on(); }

	@Override
	public String toString() { return "LightOffCommand"; }
}
