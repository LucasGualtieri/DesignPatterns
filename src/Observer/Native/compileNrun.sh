#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile the Java files
javac -d bin -sourcepath . *.java Displays/*.java

# echo "Compilation complete."

# Run the main class
java -cp bin src.Observer.Java.WeatherStation
