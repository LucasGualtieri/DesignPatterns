package src.Command.Commands.Stereo;

import src.Command.Commands.Command;
import src.Command.Receivers.Stereo;

public class StereoOnWithCDCommand implements Command {

	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) { this.stereo = stereo; }

	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(10);
	}

	@Override
	public void undo() { stereo.off(); }

	@Override
	public String toString() { return "StereoOnWithCDCommand"; }
}
