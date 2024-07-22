package src.Command.Commands;

public class MacroCommand implements Command {

	Command[] commands;

	public MacroCommand(Command... commands) { this.commands = commands; }

	public void execute() {
		for (Command i : commands) i.execute();
	}

	public void undo() {
		for (Command i : commands) i.undo();
	}

	@Override
	public String toString() { return "MacroCommand"; }
}
