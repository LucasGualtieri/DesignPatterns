package src.Factory.SimpleFactory;

import src.Factory.SimpleFactory.Pizzas.Pizza;
import src.Factory.SimpleFactory.Pizzas.PizzaType;
import src.Factory.SimpleFactory.PizzaFactories.SimplePizzaFactory;

// The PizzaStore in this implementation is full on using the Strategy Pattern
public class PizzaStore {

	private SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory) { this.factory = factory; }

	public void setFactory(SimplePizzaFactory factory) { this.factory = factory; }

	public Pizza orderPizza(PizzaType type) {

		Pizza pizza = factory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}
