#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile the Java files
javac -d bin -sourcepath .		\
  *.java						\
  Receivers/*.java				\
  Commands/*.java				\
  Commands/CeilingFan/*.java	\
  Commands/GarageDoor/*.java	\
  Commands/Lights/*.java		\
  Commands/Stereo/*.java		\
  Commands/Hottub/*.java		\
  Commands/TV/*.java			\

# echo "Compilation complete."

# Run the main class
java -cp bin src.Command.RemoteLoader
