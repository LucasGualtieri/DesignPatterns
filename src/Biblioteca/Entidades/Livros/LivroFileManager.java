package src.Biblioteca.Entidades.Livros;

import java.util.ArrayList;
import java.util.List;

import src.Biblioteca.DataFileManager;
import src.Biblioteca.Principal;
import src.Biblioteca.IndiceWrappers.Indice;
import src.Biblioteca.Registros.LivroFactory;

public class LivroFileManager extends DataFileManager {

	// IndicadorDeTamanho + ID + ISBN + Titulo + Autor + Preço
	Indice listaInvertidaTitulos, indiceIndiretoISBN;

	public LivroFileManager() {

		super(new LivroFactory(), Principal.PATH + "Livros/Dados/");

		name = "Livro";	

		//listaInvertidaTitulos = new IndiceTitulo(filePath + nome);
		//indiceIndiretoISBN = new IndiceIsbnId(filePath + nome);

		//indices.add(listaInvertidaTitulos);
		//indices.add(indiceIndiretoISBN);
	}
}
