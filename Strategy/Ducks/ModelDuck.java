package DuckGame.Ducks;

import DuckGame.FlyBehaviors.FlyNoWay;
import DuckGame.QuackBehaviors.Quack;

public class ModelDuck extends Duck {

	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck.");
	}
}
