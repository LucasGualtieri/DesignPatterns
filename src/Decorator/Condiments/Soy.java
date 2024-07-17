package src.Decorator.Condiments;

import src.Decorator.CondimentDecorator;
import src.Decorator.Beverages.Beverage;

public class Soy extends CondimentDecorator {

	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() { return .15 + beverage.cost(); }

	@Override
	public String toString() { return getDescription(); }
}
