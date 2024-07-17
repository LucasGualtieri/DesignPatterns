package src.Factory.AbstractFactory.IngredientFactories;

import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Cheese.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Clams.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Dough.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Pepperoni.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Sauce.*;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() { return new ThinCrustDough(); }

	@Override
	public Sauce createSauce() { return new MarinaraSauce(); }

	@Override
	public Cheese createCheese() { return new ReggianoCheese(); }

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() { return new SlicedPepperoni(); }

	@Override
	public Clams createClams() { return new FreshClams(); }
}
