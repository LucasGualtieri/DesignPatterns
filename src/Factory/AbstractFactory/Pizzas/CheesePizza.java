package src.Factory.AbstractFactory.Pizzas;

import src.Factory.AbstractFactory.IngredientFactories.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {

		System.out.println("Preparing a " + name);

		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}

	@Override
	public String toString() { return name; }
}
