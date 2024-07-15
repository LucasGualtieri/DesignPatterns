#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile the Java files
# javac -d bin -sourcepath . *.java EstruturasDeDados/*.java Entidades/Autores/*.java Entidades/Autores/Indices/*.java Entidades/Livros/*.java Entidades/Livros/Indices/*.java
# javac -d bin -sourcepath . *.java
javac -d bin -sourcepath . *.java Lib.java EstruturasDeDados/*.java EstruturasDeDados/Compressao/*.java EstruturasDeDados/Tuplas/*.java Entidades/Livros/*.java Entidades/Livros/Indices/*.java Entidades/Autores/*.java Entidades/Autores/Indices/*.java

# echo "Compilation complete."

# jun the main class
java -cp bin Biblioteca.Principal
