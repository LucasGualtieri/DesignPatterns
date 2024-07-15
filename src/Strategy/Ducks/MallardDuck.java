package src.Strategy.Ducks;

import src.Strategy.FlyBehaviors.FlyWithWings;
import src.Strategy.QuackBehaviors.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck.");
	}
}
