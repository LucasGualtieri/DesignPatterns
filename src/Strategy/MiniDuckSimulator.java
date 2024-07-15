package src.Strategy;

import src.Strategy.Ducks.Duck;
import src.Strategy.Ducks.DuckCall;
import src.Strategy.Ducks.MallardDuck;
import src.Strategy.Ducks.ModelDuck;
import src.Strategy.FlyBehaviors.FlyRocketPowered;

public class MiniDuckSimulator {

	public static void main(String[] args) {

		Duck mallard = new MallardDuck();

		mallard.performQuack();
		mallard.performFly();

		System.out.println("-----------------------");

		Duck model = new ModelDuck();

		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		System.out.println("-----------------------");

		DuckCall caller = new DuckCall();

		caller.call();
	}
}
