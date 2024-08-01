package src.Factory.AbstractFactory.PizzaStores;

import src.Factory.AbstractFactory.IngredientFactories.ChicagoPizzaIngredientFactory;
import src.Factory.AbstractFactory.Pizzas.CheesePizza;
import src.Factory.AbstractFactory.Pizzas.ClamPizza;
import src.Factory.AbstractFactory.Pizzas.PepperoniPizza;
import src.Factory.AbstractFactory.Pizzas.Pizza;
import src.Factory.AbstractFactory.Pizzas.PizzaType;
import src.Factory.AbstractFactory.Pizzas.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(PizzaType type) {

		Pizza pizza = null;
		ingredientFactory = new ChicagoPizzaIngredientFactory();

		if (PizzaType.CHEESE == type) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");
		}
		else if (PizzaType.CLAM == type) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");
		}
		else if (PizzaType.VEGGIE == type) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");
		}
		else if (PizzaType.PEPPERONI == type) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");
		}

		return pizza;
	}
}
