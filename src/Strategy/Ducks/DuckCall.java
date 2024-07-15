package src.Strategy.Ducks;

import src.Strategy.QuackBehaviors.Quack;
import src.Strategy.QuackBehaviors.QuackBehavior;

public class DuckCall {

	QuackBehavior quackSound;

	public DuckCall() { quackSound = new Quack(); }

	public void call() { quackSound.quack(); }
}
