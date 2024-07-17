package src.Factory.SimpleFactory.PizzaFactories;

import src.Factory.SimpleFactory.Pizzas.ChicagoStylePizzas.ChicagoStyleCheesePizza;
import src.Factory.SimpleFactory.Pizzas.Pizza;
import src.Factory.SimpleFactory.Pizzas.PizzaType;
import src.Factory.SimpleFactory.Pizzas.GenericPizzas.VeggiePizza;

public class ChicagoPizzaFactory implements SimplePizzaFactory {

	@Override
	public Pizza createPizza(PizzaType type) {

		Pizza pizza = new VeggiePizza();

		if (PizzaType.CHEESE == type) {
			pizza = new ChicagoStyleCheesePizza();
		}

		return pizza;
	}
}
