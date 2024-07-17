package src.Factory.AbstractFactory.PizzaStores;

import src.Factory.AbstractFactory.IngredientFactories.ChicagoPizzaIngredientFactory;
import src.Factory.AbstractFactory.IngredientFactories.PizzaIngredientFactory;
import src.Factory.AbstractFactory.Pizzas.CheesePizza;
import src.Factory.AbstractFactory.Pizzas.Pizza;
import src.Factory.AbstractFactory.Pizzas.PizzaType;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(PizzaType type) {

		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

		if (PizzaType.CHEESE == type) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");
		}

		return pizza;
	}
}
