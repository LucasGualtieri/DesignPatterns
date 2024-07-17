#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile the Java files
javac -d bin -sourcepath .							\
  *.java											\
  Pizzas/*.java										\
  PizzaStores/*.java								\
  IngredientFactories/*.java						\
  IngredientFactories/Ingredients/Cheese/*.java		\
  IngredientFactories/Ingredients/Clams/*.java		\
  IngredientFactories/Ingredients/Dough/*.java		\
  IngredientFactories/Ingredients/Pepperoni/*.java	\
  IngredientFactories/Ingredients/Sauce/*.java		\
  IngredientFactories/Ingredients/Veggies/*.java

# echo "Compilation complete."

# Run the main class
java -cp bin src.Factory.AbstractFactory.PizzaTestDrive
