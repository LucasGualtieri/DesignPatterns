#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile the Java files
javac -d bin -sourcepath . *.java Pizzas/*.java Pizzas/GenericPizzas/*.java Pizzas/ChicagoStylePizzas/*.java Pizzas/NYStylePizzas/*.java PizzaStores/*.java

# echo "Compilation complete."

# Run the main class
java -cp bin src.Factory.FactoryMethod.PizzaTestDrive
