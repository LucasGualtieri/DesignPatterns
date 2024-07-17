package src.Factory.AbstractFactory.IngredientFactories;

import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Cheese.Cheese;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Clams.Clams;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Dough.Dough;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Pepperoni.Pepperoni;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Sauce.Sauce;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Veggies.Veggies;

public interface PizzaIngredientFactory {

	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClams();
}
