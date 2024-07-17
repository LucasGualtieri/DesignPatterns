package src.Factory.FactoryMethod.PizzaStores;

import src.Factory.FactoryMethod.Pizzas.Pizza;
import src.Factory.FactoryMethod.Pizzas.ChicagoStylePizzas.ChicagoStyleCheesePizza;
import src.Factory.FactoryMethod.Pizzas.GenericPizzas.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {

		Pizza pizza = new VeggiePizza();

		if (type.equals("cheese")) {
			pizza = new ChicagoStyleCheesePizza();
		}

		return pizza;
	}
}
