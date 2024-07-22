package src.Biblioteca.Entidades.Livros;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.Biblioteca.Utils.CRUD;
import src.Biblioteca.Utils.DataFileManager;
import src.Biblioteca.Utils.Indice;

public class LivroFileManager extends DataFileManager {

	// IndicadorDeTamanho + ID + ISBN + Titulo + Autor + Preço
	Indice listaInvertidaTitulos, indiceIndiretoISBN;

	public LivroFileManager() throws FileNotFoundException, IOException, Exception {

		super("Livro", new LivroFactory(), CRUD.PATH + "Livros/Dados/");

		//listaInvertidaTitulos = new IndiceTitulo(filePath + nome);
		//indiceIndiretoISBN = new IndiceIsbnId(filePath + nome);

		indiceIndiretoISBN = new Teste();

		//indices.add(listaInvertidaTitulos);
		//indices.add(indiceIndiretoISBN);
	}
}
