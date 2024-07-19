package src.Singleton;

// The classic Singleton implementation
public class Singleton {

	// Other useful instance variables here.

	private static Singleton uniqueInstance;

	// Beware! The deafault visibility of a constructor is PUBLIC (I'm pretty sure it is).
	private Singleton() {
		// Other useful default initializations.
	}

	public static Singleton getInstance() {

		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}

		return uniqueInstance;
	}

	// Other useful methods here.
}
