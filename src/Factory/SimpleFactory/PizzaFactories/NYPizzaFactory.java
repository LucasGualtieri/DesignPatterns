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

		else {
			String errorMessage = "Invalid pizza, you should use the static members of the PizzaStore class.";
			throw new IllegalArgumentException(errorMessage);
		}

		return pizza;
	}

}
