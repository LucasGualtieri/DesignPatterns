package src.Factory.AbstractFactory;

import src.Factory.AbstractFactory.PizzaStores.ChicagoPizzaStore;
import src.Factory.AbstractFactory.PizzaStores.NYPizzaStore;
import src.Factory.AbstractFactory.PizzaStores.PizzaStore;
import src.Factory.AbstractFactory.Pizzas.Pizza;
import src.Factory.AbstractFactory.Pizzas.PizzaType;

public class PizzaTestDrive {

	public static void main(String[] args) {

		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		Pizza pizza = nyStore.orderPizza(PizzaType.CHEESE);
		System.out.println("Ethan ordered a " + pizza + "\n");

		pizza = chicagoStore.orderPizza(PizzaType.VEGGIE);
		System.out.println("Joel ordered a " + pizza + "\n");
	}
}
