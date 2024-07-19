package src.Command.Commands.Lights;

import src.Command.Commands.Command;
import src.Command.Receivers.Light;

public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light) { this.light = light; }

	public void execute() { light.on(); }

	@Override
	public void undo() { light.off(); }

	@Override
	public String toString() { return "LightOnCommand"; }
}
