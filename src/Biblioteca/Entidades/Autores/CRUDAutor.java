package src.Biblioteca.Entidades.Autores;

import java.util.List;

import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Utils.CRUD;
import src.Biblioteca.Utils.Util;

public class CRUDAutor extends CRUD {

	// Essa função permite que o usuário escolha de que forma gostaria de apresentar os dados na listagem
	public int SortList(List<Registro> list) {
		System.out.println("Ordenar por:");
		System.out.println("1 - ID");
		System.out.println("2 - Nome");
		System.out.println("3 - Sobrenome");
		System.out.println("4 - Idade");
		System.out.println("\n0 - Voltar.");
		System.out.print("\nEscolha uma das opções acima: ");
		
		int choice = Util.ReadChoice(4);
		
		switch (choice) {
			case 1:
				list.sort((l1, l2) -> Integer.compare(l1.getID(), l2.getID()));
			break;
			case 2:
				list.sort((l1, l2) -> ((Autor)l1).getName().compareTo(((Autor)l2).getName()));
			break;
				case 3:
				list.sort((l1, l2) -> ((Autor)l1).getSobrenome().compareTo(((Autor)l2).getSobrenome()));
			break;
				case 4:
				list.sort((l1, l2) -> Integer.compare(((Autor)l1).getIdade(), ((Autor)l2).getIdade()));
			break;
		}

		return choice;
	}

	public int menu() {

		Util.printdiv(1, "Base de dados: Autores");

		System.out.println("1 - Cadastrar.");
		System.out.println("2 - Pesquisar.");
		System.out.println("3 - Atualizar.");
		System.out.println("4 - Deletar.");
		System.out.println("5 - Listar todos os autores.");
		System.out.println("6 - Fazer backup compactado.");
		System.out.println("7 - Recuperar backup compactado.\n");
		System.out.println("0 - Voltar.\n");
		System.out.print("Escolha uma das opções acima: ");

		return Util.ReadChoice(7);
	}

	@Override
	public List<Registro> search() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'search'");
	}
}
