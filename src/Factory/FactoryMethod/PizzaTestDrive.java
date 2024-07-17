package src.Factory.FactoryMethod;

import src.Factory.FactoryMethod.PizzaStores.ChicagoPizzaStore;
import src.Factory.FactoryMethod.PizzaStores.NYPizzaStore;
import src.Factory.FactoryMethod.PizzaStores.PizzaStore;
import src.Factory.FactoryMethod.Pizzas.Pizza;

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
