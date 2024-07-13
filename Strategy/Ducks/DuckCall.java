package Strategy.Ducks;

import Strategy.QuackBehaviors.Quack;
import Strategy.QuackBehaviors.QuackBehavior;

public class DuckCall {

	QuackBehavior quackSound;

	public DuckCall() { quackSound = new Quack(); }

	public void call() { quackSound.quack(); }
}
