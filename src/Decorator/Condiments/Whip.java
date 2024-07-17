package src.Decorator.Condiments;

import src.Decorator.CondimentDecorator;
import src.Decorator.Beverages.Beverage;

public class Whip extends CondimentDecorator {

	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() { return .10 + beverage.cost(); }

	@Override
	public String toString() { return getDescription(); }
}
