package src.Decorator;

import src.Decorator.Beverages.Beverage;
import src.Decorator.Beverages.DarkRoast;
import src.Decorator.Beverages.Espresso;
import src.Decorator.Beverages.HouseBlend;
import src.Decorator.Condiments.Mocha;
import src.Decorator.Condiments.Soy;
import src.Decorator.Condiments.Whip;

public class StarbuzzCoffee {
	
	public static void main(String[] args) {
		
		Beverage beverage = new Espresso();
		System.out.printf("%s $%.2f\n", beverage, beverage.cost());

		Beverage beverage2 = new Whip(new Mocha(new Mocha(new DarkRoast())));

		System.out.printf("%s $%.2f\n", beverage2, beverage2.cost());

		Beverage beverage3 = new Soy(new Mocha(new Whip(new HouseBlend())));

		System.out.printf("%s $%.2f\n", beverage3, beverage3.cost());
	}
}

// Beverage beverage2 = new DarkRoast();
// beverage2 = new Mocha(beverage2);
// beverage2 = new Mocha(beverage2);
// beverage2 = new Whip(beverage2);
