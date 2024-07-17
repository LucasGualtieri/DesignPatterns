package src.Factory.AbstractFactory.IngredientFactories;

import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Cheese.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Clams.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Dough.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Pepperoni.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Sauce.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Veggies.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() { return new ThickCrustDough(); }

	@Override
	public Sauce createSauce() { return new PlumTomatoSauce(); }

	@Override
	public Cheese createCheese() { return new MozzarellaCheese(); }

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = { new Spinach(), new EggPlant(), new BlackOlives() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() { return new SlicedPepperoni(); }

	@Override
	public Clams createClams() { return new FrozenClams(); }
}
