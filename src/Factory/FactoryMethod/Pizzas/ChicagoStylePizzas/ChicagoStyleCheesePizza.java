package src.Factory.FactoryMethod.Pizzas.ChicagoStylePizzas;

import src.Factory.FactoryMethod.Pizzas.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

	public ChicagoStyleCheesePizza() {

		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Shredded Mozzarella Cheese.");
	}

	@Override
	public void cut() {
		System.out.println("Cutting the pizza into square slices.");
	}

	@Override
	public String toString() { return name; }
}
