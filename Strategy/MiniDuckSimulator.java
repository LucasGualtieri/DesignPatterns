package DuckGame;

import DuckGame.Ducks.Duck;
import DuckGame.Ducks.DuckCall;
import DuckGame.Ducks.MallardDuck;
import DuckGame.Ducks.ModelDuck;
import DuckGame.FlyBehaviors.FlyRocketPowered;

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
