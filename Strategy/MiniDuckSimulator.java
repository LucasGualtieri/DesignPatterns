package Strategy;

import Strategy.Ducks.Duck;
import Strategy.Ducks.DuckCall;
import Strategy.Ducks.MallardDuck;
import Strategy.Ducks.ModelDuck;
import Strategy.FlyBehaviors.FlyRocketPowered;

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
