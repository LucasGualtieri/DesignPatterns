package DuckGame.Ducks;

import DuckGame.QuackBehaviors.Quack;
import DuckGame.QuackBehaviors.QuackBehavior;

public class DuckCall {

	QuackBehavior quackSound;

	public DuckCall() { quackSound = new Quack(); }

	public void call() { quackSound.quack(); }
}
