package src.Factory.AbstractFactory.Pizzas;

import src.Factory.AbstractFactory.IngredientFactories.PizzaIngredientFactory;

public class ClamPizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;

	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {

		System.out.println("Preparing " + name);

		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clam = ingredientFactory.createClams();
	}

	@Override
	public String toString() { return name; }
}
