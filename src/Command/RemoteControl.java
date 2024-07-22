package src.Command;

import java.util.Stack;

import src.Command.Commands.Command;
import src.Command.Commands.NoCommand;

public class RemoteControl {

	Command[] onCommands;
	Command[] offCommands;
	Stack<Command> undoCommands;

	public RemoteControl() {

		onCommands = new Command[7];
		offCommands = new Command[7];
		undoCommands = new Stack<>();

		Command noCommand = new NoCommand();

		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {

		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {

		onCommands[slot].execute();
		undoCommands.add(onCommands[slot]);
	}

	public void offButtonWasPushed(int slot) {

		offCommands[slot].execute();
		undoCommands.add(offCommands[slot]);
	}

	public void undoButtonWasPushed() {
		if (!undoCommands.isEmpty()) undoCommands.pop().undo();
		//else System.out.println("No previous action.");
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("----- Remote Control -----\n");

		for (int i = 0; i < onCommands.length; i++) {
			builder.append(String.format("[slot %d] %s\t%s\n", i, onCommands[i], offCommands[i]));
		}

		return builder.toString();
	}
}
