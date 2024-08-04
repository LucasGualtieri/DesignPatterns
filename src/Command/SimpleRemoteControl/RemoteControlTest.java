package src.Command.SimpleRemoteControl;

import src.Command.Commands.GarageDoor.GarageDoorToggleCommand;
import src.Command.Commands.Lights.LightToggleCommand;
import src.Command.Receivers.GarageDoor;
import src.Command.Receivers.Light;

public class RemoteControlTest {

	public static void main(String[] args) {

		SimpleRemoteControl remote = new SimpleRemoteControl();

		LightToggleCommand lightToggle = new LightToggleCommand(new Light("Living Room"));
		GarageDoorToggleCommand garageDoorToggle = new GarageDoorToggleCommand(new GarageDoor());

		remote.setCommand(lightToggle);
		remote.buttonWasPressed();
		remote.buttonWasPressed();
		remote.buttonWasPressed();

		remote.setCommand(garageDoorToggle);
		remote.buttonWasPressed();
		remote.buttonWasPressed();
		remote.buttonWasPressed();
	}
}