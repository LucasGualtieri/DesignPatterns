package src.Factory.AbstractFactory.PizzaStores;

import src.Factory.AbstractFactory.IngredientFactories.NYPizzaIngredientFactory;
import src.Factory.AbstractFactory.IngredientFactories.PizzaIngredientFactory;
import src.Factory.AbstractFactory.Pizzas.CheesePizza;
import src.Factory.AbstractFactory.Pizzas.Pizza;
import src.Factory.AbstractFactory.Pizzas.PizzaType;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(PizzaType type) {

		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

		if (PizzaType.CHEESE == type) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		}

		return pizza;
	}
}
