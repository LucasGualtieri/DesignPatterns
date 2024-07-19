package src.Command.Commands.Stereo;

import src.Command.Commands.Command;
import src.Command.Receivers.Stereo;

public class StereoOffCommand implements Command {

	Stereo stereo;
	StereoOnWithCDCommand undo;

	public StereoOffCommand(Stereo stereo) {

		this.stereo = stereo;
		// Maybe this isn't such a good idea... 
		undo = new StereoOnWithCDCommand(stereo);
	}

	@Override
	public void execute() { stereo.off(); }

	@Override
	public void undo() { undo.execute(); }

	@Override
	public String toString() { return "StereoOffCommand"; }
}
