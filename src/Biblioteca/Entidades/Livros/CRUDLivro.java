package src.Biblioteca.Entidades.Livros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Utils.CRUD;
import src.Biblioteca.Utils.Util;

public class CRUDLivro extends CRUD {

	public CRUDLivro() throws FileNotFoundException, IOException, Exception {

		fileManager = new LivroFileManager();
		registroFactory = new LivroFactory();	
	}

	public int menu() {

		Util.clearScreen();

		int choice;

		do {

			Util.printdiv(1, "Base de dados: Livros");

			System.out.println("1 - Cadastrar.");
			System.out.println("2 - Pesquisar.");
			System.out.println("3 - Atualizar.");
			System.out.println("4 - Deletar.");
			System.out.println("5 - Listar todos os livros.");
			System.out.println("6 - Fazer backup compactado.");
			System.out.println("7 - Recuperar backup compactado.\n");
			System.out.println("0 - Voltar.\n");
			System.out.print("Escolha uma das opções acima: ");

			choice = Util.ReadChoice(7);
			
			try {
				if (choice == 1) create();
				else if (choice == 2) read();
				else if (choice == 3) update();
				else if (choice == 4) delete();
				else if (choice == 5) Listar();
				else if (choice == 6) Backup();
				else if (choice == 7) RecoverBackup();
			}

			catch (Exception e) { System.out.println("Houve um errro: " + e.getMessage()); }

		} while (choice != 0);

		return choice;
	}

	// Essa é uma função auxiliar à função read que permite que cada classe implemente seus métodos de busca
	// baseado nos atributos específicos daquela classe
	// Como search sempre volta uma lista, será importante tomar cuidado para printar bonitinho quando só tiver um, que será o caso da pesquisa por id e ISBN por exemplo.
	public List<Registro> search() {

		// System.out.printf("Insira o ID do %s: ", getNomeLowerCase());
		System.out.println("Buscar por:");
		System.out.println("1 - ID.");
		System.out.println("2 - ISBN.");
		System.out.println("3 - Título.");
		System.out.println("\n0 - Voltar.");
		System.out.print("\nEscolha uma das opções acima: ");

		int choice = Util.ReadChoice(3);

		List<Registro> registroList = new ArrayList<>();
		Registro registro;

		//switch (choice) {
		//	case 1:
		//	System.out.printf("Insira o ID do livro: ");
		//	int id = Util.readInt();
		//	registro = indiceDireto.read(id);
		//	if (registro != null) registroList.add(registro);
		//	break;
		//	case 2:
		//	System.out.printf("Insira o ISBN do livro: ");
		//	String ISBN = Livro.readISBN(false);
		//	// Comentário sobre o comentário abaixo, acho que falei besteira kkkk não é um problemão assim.
		//	// Problemão aqui! não temos o objeto para pode passar para o .read(); AAAAAAAAAA que programa todo MAL FEITO!!
		//	registro = ((IndiceIsbnId)indiceIndiretoISBN).read(ParIsbnId.hashIsbn(ISBN));
		//	if (registro != null) registroList.add(registro);
		//	case 3:
		//
		//	System.out.printf("Insira o título do livro: ");
		//	String titulo = Util.readString();
		//
		//	registroList.addAll(((IndiceTitulo)listaInvertidaTitulos).read(this, titulo));
		//	break;
		//	default:
		//	// System.out.printf("Insira o título do livro: ");
		//	// ID = indiceTitulo.read(Util.readString()).getId();
		//	break;
		//}

		return registroList;
	}

	// Essa função permite que o usuário escolha de que forma gostaria de apresentar os dados na listagem
	public int SortList(List<Registro> list) {

		System.out.println("Ordenar por:");
		System.out.println("1 - ID");
		System.out.println("2 - ISBN");
		System.out.println("3 - Título");
		System.out.println("4 - Autor");
		System.out.println("5 - Preço.");
		System.out.println("\n0 - Voltar.");

		System.out.print("\nEscolha uma das opções acima: ");

		int choice = Util.ReadChoice(5);

		// System.out.println("\nOrdenar por:");
		// System.out.println("1 - Ordem crescente");
		// System.out.println("2 - Ordem descrescente");
		// System.out.println("\n0 - Voltar.");

		// System.out.print("Escolha uma das opções acima: ");

		// final int choice2 = Util.ReadChoice(2);

		// final int asc = choice2 == 1 ? 1 : -1;

		switch (choice) {
			case 1:
			list.sort((l1, l2) -> Integer.compare(l1.getID(), l2.getID()));
			break;
			case 2:
			list.sort((l1, l2) -> ((Livro)l1).getISBN().compareTo(((Livro)l2).getISBN()));
			break;
			case 3:
			list.sort((l1, l2) -> ((Livro)l1).getTitulo().compareTo(((Livro)l2).getTitulo()));
			break;
			case 4:
			list.sort((l1, l2) -> ((Livro)l1).getAutor().compareTo(((Livro)l2).getAutor()));
			break;
			case 5:
			list.sort((l1, l2) -> Float.compare(((Livro)l1).getPreco(), ((Livro)l2).getPreco()));
			break;
		}

		return choice;
	}
}
