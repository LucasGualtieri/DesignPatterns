package src.Command;

import src.Command.Commands.MacroCommand;
import src.Command.Commands.Command;
import src.Command.Commands.CeilingFan.CeilingFanHighCommand;
import src.Command.Commands.CeilingFan.CeilingFanLowCommand;
import src.Command.Commands.CeilingFan.CeilingFanMediumCommand;
import src.Command.Commands.CeilingFan.CeilingFanOffCommand;
import src.Command.Commands.GarageDoor.GarageDoorDownCommand;
import src.Command.Commands.GarageDoor.GarageDoorUpCommand;
import src.Command.Commands.Hottub.HottubOffCommand;
import src.Command.Commands.Hottub.HottubOnCommand;
import src.Command.Commands.Lights.LightOffCommand;
import src.Command.Commands.Lights.LightOnCommand;
import src.Command.Commands.Stereo.StereoOffCommand;
import src.Command.Commands.Stereo.StereoOnWithCDCommand;
import src.Command.Commands.TV.TVOffCommand;
import src.Command.Commands.TV.TVOnCommand;
import src.Command.Receivers.CeilingFan;
import src.Command.Receivers.GarageDoor;
import src.Command.Receivers.Hottub;
import src.Command.Receivers.Light;
import src.Command.Receivers.Stereo;
import src.Command.Receivers.TV;

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

	static void TestingUndo(RemoteControl remote) {

		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(1);
		remote.undoButtonWasPushed();
		remote.onButtonWasPushed(1);
		remote.undoButtonWasPushed();
		remote.undoButtonWasPushed();
	}

	static void RemoteSetup(RemoteControl remote) {
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenRoomLight = new Light("Kitchen");

		CeilingFan ceilingFan = new CeilingFan("Living Room");

		GarageDoor garageDoor = new GarageDoor();

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

		int slot = 0;
		remote.setCommand(slot++, ceilingFanHigh, ceilingFanOff);
		remote.setCommand(slot++, ceilingFanMedium, ceilingFanOff);
		remote.setCommand(slot++, ceilingFanLow, ceilingFanOff);
		remote.setCommand(slot++, livingRoomLightOn, livingRoomLightOff);
		remote.setCommand(slot++, kitchenRoomLightOn, kitchenRoomLightOff);
		remote.setCommand(slot++, garageDoorUp, garageDoorDown);
	}

	static void TestingMacro(RemoteControl remote) {

		Light livingRoomLight = new Light("Living Room");
		TV tv = new TV("Living Room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();

		Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
		Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

		Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		Command stereoOff = new StereoOffCommand(stereo);

		Command tvOn = new TVOnCommand(tv);
		Command tvOff = new TVOffCommand(tv);

		Command hottubOn = new HottubOnCommand(hottub);
		Command hottubOff = new HottubOffCommand(hottub);

		Command[] partyOff = { livingRoomLightOff, stereoOff, tvOff, hottubOff };

		Command partyOnMacro = new MacroCommand(livingRoomLightOn, stereoOnWithCD, tvOn, hottubOn);
		Command partyOffMacro = new MacroCommand(partyOff);

		remote.setCommand(6, partyOnMacro, partyOffMacro);

		System.out.println("--- Pushing Macro On ---");
		remote.onButtonWasPushed(6);
		System.out.println("--- Pushing Macro Off ---");
		remote.offButtonWasPushed(6);
	}

	public static void main(String[] args) {
		
		RemoteControl remote = new RemoteControl();

		RemoteSetup(remote);

		System.out.println(remote);

		//TestingAllTheButtons(remote);

		TestingUndo(remote);

		//TestingMacro(remote);
	}
}
