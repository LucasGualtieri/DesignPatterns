package src.Factory.SimpleFactory.PizzaFactories;

import src.Factory.SimpleFactory.Pizzas.Pizza;
import src.Factory.SimpleFactory.Pizzas.PizzaType;
import src.Factory.SimpleFactory.Pizzas.GenericPizzas.CheesePizza;
import src.Factory.SimpleFactory.Pizzas.GenericPizzas.ClamPizza;
import src.Factory.SimpleFactory.Pizzas.GenericPizzas.PepperoniPizza;
import src.Factory.SimpleFactory.Pizzas.GenericPizzas.VeggiePizza;

public abstract class StaticPizzaFactory {
	
	/*
	 * Defining a simple factory as a static method is a common technique and 
	 * is often called a static factory. Why use a static method?
	 * Because you don’t need to instantiate an object to make use of the
	 * create method. But remember it also has the disadvanage that
	 * you can’t subclass and change the behavior of the create method.
	 *
	 */
	public static Pizza createPizza(PizzaType type) {

		Pizza pizza = null;

		if (type == PizzaType.CHEESE) {
			pizza = new CheesePizza();
		}
		else if (type == PizzaType.PEPPERONI) {
			pizza = new PepperoniPizza();
		}
		else if (type == PizzaType.VEGGIE) {
			pizza = new VeggiePizza();
		}
		else if (type == PizzaType.CLAM) {
			pizza = new ClamPizza();
		}

		return pizza;
	}

}
