package src.Factory.SimpleFactory;

import src.Factory.SimpleFactory.PizzaFactories.ChicagoPizzaFactory;
import src.Factory.SimpleFactory.PizzaFactories.NYPizzaFactory;
import src.Factory.SimpleFactory.Pizzas.Pizza;
import src.Factory.SimpleFactory.Pizzas.PizzaType;

public class PizzaTestDrive {

	public static void main(String[] args) {

		PizzaStore store = new PizzaStore(new NYPizzaFactory());

		Pizza pizza = store.orderPizza(PizzaType.CHEESE);
		System.out.println("Ethan ordered a " + pizza + "\n");

		store.setFactory(new ChicagoPizzaFactory());

		pizza = store.orderPizza(PizzaType.CHEESE);
		System.out.println("Joel ordered a " + pizza + "\n");
	}
}
