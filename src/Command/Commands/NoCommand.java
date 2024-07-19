package src.Command.Commands;

public class NoCommand implements Command {

	@Override
	public void execute() {
		System.out.println("No command defined.");
	}

	@Override
	public void undo() {
		System.out.println("No command defined.");
	}

	@Override
	public String toString() { return "NoCommand"; }
}
