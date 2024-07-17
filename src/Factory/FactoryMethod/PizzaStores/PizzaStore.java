package src.Factory.FactoryMethod.PizzaStores;

import src.Factory.FactoryMethod.Pizzas.Pizza;

public abstract class PizzaStore {

	/*
	 * You can define a default factory method to
	 * produce some concrete product. Then you
	 * always have a means of creating products
	 * even if there are no subclasses of the Creator.
	 * That would mean that PizzaStore would no longer be abstract.
	 * */
	protected abstract Pizza createPizza(String type);

	public static final String CHEESE = "cheese";

	public final Pizza orderPizza(String type) {

		Pizza pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}
