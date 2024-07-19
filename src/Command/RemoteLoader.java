package src.Command;

import src.Command.Commands.MacroCommand;
import src.Command.Commands.Command;
import src.Command.Commands.CeilingFan.CeilingFanHighCommand;
import src.Command.Commands.CeilingFan.CeilingFanLowCommand;
import src.Command.Commands.CeilingFan.CeilingFanMediumCommand;
import src.Command.Commands.CeilingFan.CeilingFanOffCommand;
import src.Command.Commands.GarageDoor.GarageDoorDownCommand;
import src.Command.Commands.GarageDoor.GarageDoorUpCommand;
import src.Command.Commands.Lights.LightOffCommand;
import src.Command.Commands.Lights.LightOnCommand;
import src.Command.Commands.Stereo.StereoOffCommand;
import src.Command.Commands.Stereo.StereoOnWithCDCommand;
import src.Command.Receivers.CeilingFan;
import src.Command.Receivers.GarageDoor;
import src.Command.Receivers.Light;
import src.Command.Receivers.Stereo;

public class RemoteLoader {

	static void TestingAllTheButtons(RemoteControl remote) {

		remote.offButtonWasPushed(0);
		remote.onButtonWasPushed(0);
		remote.undoButtonWasPushed();

		remote.offButtonWasPushed(1);
		remote.onButtonWasPushed(1);
		remote.undoButtonWasPushed();

		remote.offButtonWasPushed(2);
		remote.onButtonWasPushed(2);
		remote.undoButtonWasPushed();

		remote.offButtonWasPushed(3);
		remote.onButtonWasPushed(3);
		remote.undoButtonWasPushed();

		remote.offButtonWasPushed(4);
		remote.onButtonWasPushed(4);
		remote.undoButtonWasPushed();
	}

	public static void main(String[] args) {
		
		RemoteControl remote = new RemoteControl();

		Light livingRoomLight = new Light("Living Room");
		Light kitchenRoomLight = new Light("Kitchen");

		CeilingFan ceilingFan = new CeilingFan("Living Room");

		GarageDoor garageDoor = new GarageDoor();

		Stereo stereo = new Stereo("Living Room");

		Command ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		Command ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		Command ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
		Command ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
		Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

		Command kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
		Command kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);

		Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
		Command garageDoorDown = new GarageDoorDownCommand(garageDoor);

		Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		Command stereoOff = new StereoOffCommand(stereo);

		Command[] partyOn = { livingRoomLightOn, stereoOnWithCD };
		Command[] partyOff = { livingRoomLightOff, stereoOff };

		Command partyOnMacro = new MacroCommand(partyOn);
		Command partyOffMacro = new MacroCommand(partyOff);

		int slot = 0;
		remote.setCommand(slot++, ceilingFanHigh, ceilingFanOff);
		remote.setCommand(slot++, ceilingFanMedium, ceilingFanOff);
		remote.setCommand(slot++, ceilingFanLow, ceilingFanOff);
		remote.setCommand(slot++, livingRoomLightOn, livingRoomLightOff);
		remote.setCommand(slot++, kitchenRoomLightOn, kitchenRoomLightOff);
		remote.setCommand(slot++, garageDoorUp, garageDoorDown);
		remote.setCommand(slot++, stereoOnWithCD, stereoOff);

		System.out.println(remote);

		//TestingAllTheButtons(remote);

		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(1);
		remote.undoButtonWasPushed();
		remote.onButtonWasPushed(1);
		remote.undoButtonWasPushed();
	}
}
