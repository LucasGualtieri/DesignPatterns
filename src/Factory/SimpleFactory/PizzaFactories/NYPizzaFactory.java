package src.Factory.SimpleFactory.PizzaFactories;

import src.Factory.SimpleFactory.Pizzas.Pizza;
import src.Factory.SimpleFactory.Pizzas.PizzaType;
import src.Factory.SimpleFactory.Pizzas.NYStylePizzas.NYStyleCheesePizza;

public class NYPizzaFactory implements SimplePizzaFactory {

	@Override
	public Pizza createPizza(PizzaType type) {

		Pizza pizza = null;

		if (PizzaType.CHEESE == type) {
			pizza = new NYStyleCheesePizza();
		}

		return pizza;
	}

}
