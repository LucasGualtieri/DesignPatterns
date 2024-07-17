package src.Factory.AbstractFactory.Pizzas;

import src.Factory.AbstractFactory.IngredientFactories.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {

		System.out.println("Preparing a " + name);

		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
	}

	@Override
	public String toString() { return name; }
}
