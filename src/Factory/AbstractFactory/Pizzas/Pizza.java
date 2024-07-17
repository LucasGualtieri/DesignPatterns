package src.Factory.AbstractFactory.Pizzas;

import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Cheese.Cheese;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Clams.Clams;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Dough.Dough;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Pepperoni.Pepperoni;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Sauce.Sauce;
import src.Factory.AbstractFactory.IngredientFactories.Ingredients.Veggies.Veggies;

public abstract class Pizza {
	
	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Veggies veggies[];
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350.");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices.");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box.");
	}

	public void setName(String name) { this.name = name; }
	public String getName() { return name; }

	public abstract String toString();
}
