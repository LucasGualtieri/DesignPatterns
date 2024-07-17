package src.Decorator.Condiments;

import src.Decorator.CondimentDecorator;
import src.Decorator.Beverages.Beverage;

public class Mocha extends CondimentDecorator {

	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() { return .20 + beverage.cost(); }

	@Override
	public String toString() { return getDescription(); }
}
