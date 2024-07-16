package src.Decorator.Condiments;

import src.Decorator.CondimentDecorator;
import src.Decorator.Beverages.Beverage;

public class SteamedMilk extends CondimentDecorator {

	Beverage beverage;

	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Steamed Milk";
	}

	@Override
	public double cost() { return .10 + beverage.cost(); }
}
