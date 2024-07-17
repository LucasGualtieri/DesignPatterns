package src.Factory.FactoryMethod.PizzaStores;

import src.Factory.FactoryMethod.Pizzas.Pizza;
import src.Factory.FactoryMethod.Pizzas.NYStylePizzas.NYStyleCheesePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {

		Pizza pizza = null;

		if (type.equals(PizzaStore.CHEESE)) {
			pizza = new NYStyleCheesePizza();
		}

		else {
			String errorMessage = "Invalid pizza, you should use the static members of the PizzaStore class.";
			throw new IllegalArgumentException(errorMessage);
		}

		return pizza;
	}
}
