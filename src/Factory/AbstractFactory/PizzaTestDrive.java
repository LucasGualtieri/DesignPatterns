package src.Factory.AbstractFactory;

import src.Factory.AbstractFactory.PizzaStores.ChicagoPizzaStore;
import src.Factory.AbstractFactory.PizzaStores.NYPizzaStore;
import src.Factory.AbstractFactory.PizzaStores.PizzaStore;
import src.Factory.AbstractFactory.Pizzas.Pizza;

public class PizzaTestDrive {

	public static void main(String[] args) {

		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		Pizza pizza = nyStore.orderPizza(PizzaStore.CHEESE);
		System.out.println("Ethan ordered a " + pizza + "\n");

		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza + "\n");
	}
}
