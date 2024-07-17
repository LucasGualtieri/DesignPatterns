package src.Factory.SimpleFactory.Pizzas;

public enum PizzaType {
    CHEESE, PEPPERONI, VEGGIE, CLAM
}

// This is an alternative to the ENUM solution.
//public class PizzaType {
//
//	public static final PizzaType CHEESE = new PizzaType("cheese");
//	public static final PizzaType PEPPERONI = new PizzaType("pepperoni");
//	public static final PizzaType VEGGIE = new PizzaType("veggie");
//	public static final PizzaType CLAM = new PizzaType("clam");
//
//	private String type;
//
//	// Key part here! The constructor is private.
//	private PizzaType(String type) { this.type = type; }
//
//	public String getType() { return type; }
//
//	@Override
//	public String toString() { return type; }
//}
