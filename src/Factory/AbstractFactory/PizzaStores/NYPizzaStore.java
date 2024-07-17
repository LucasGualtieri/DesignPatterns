package src.Factory.AbstractFactory.PizzaStores;

import src.Factory.AbstractFactory.IngredientFactories.NYPizzaIngredientFactory;
import src.Factory.AbstractFactory.Pizzas.CheesePizza;
import src.Factory.AbstractFactory.Pizzas.ClamPizza;
import src.Factory.AbstractFactory.Pizzas.PepperoniPizza;
import src.Factory.AbstractFactory.Pizzas.Pizza;
import src.Factory.AbstractFactory.Pizzas.PizzaType;
import src.Factory.AbstractFactory.Pizzas.VeggiePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(PizzaType type) {

		Pizza pizza = null;
		ingredientFactory = new NYPizzaIngredientFactory();

		if (PizzaType.CHEESE == type) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		}
		else if (PizzaType.CLAM == type) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
		}
		else if (PizzaType.CLAM == type) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		}
		else if (PizzaType.CLAM == type) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		}

		return pizza;
	}
}
