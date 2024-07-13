package Strategy.Ducks;

import Strategy.FlyBehaviors.FlyWithWings;
import Strategy.QuackBehaviors.Quack;

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
