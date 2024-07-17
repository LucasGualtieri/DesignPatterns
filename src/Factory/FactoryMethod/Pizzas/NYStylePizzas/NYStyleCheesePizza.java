package src.Factory.FactoryMethod.Pizzas.NYStylePizzas;

import src.Factory.FactoryMethod.Pizzas.Pizza;

public class NYStyleCheesePizza extends Pizza {

	public NYStyleCheesePizza() {

		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add("Grated Reggiano Cheese.");
	}

	@Override
	public String toString() { return name; }
}
