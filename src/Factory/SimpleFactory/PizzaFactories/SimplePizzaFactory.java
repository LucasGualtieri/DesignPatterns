package src.Factory.SimpleFactory.PizzaFactories;

import src.Factory.SimpleFactory.Pizzas.Pizza;
import src.Factory.SimpleFactory.Pizzas.PizzaType;

public interface SimplePizzaFactory {
	public Pizza createPizza(PizzaType type);
}
