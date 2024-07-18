package src.Biblioteca;

import src.Biblioteca.CRUDs.*;

public class Principal {

	public static void main(String[] args) throws Exception {

		CRUD crud = null;
		int choice;

		do {
			Lib.clearScreen();
			Lib.printdiv(1, "SGBD");

			System.out.println("1 - Livros.");
			System.out.println("2 - Autores.\n");
			System.out.println("0 - Sair do programa.\n");
			System.out.print("Escolha uma das bases de dados: ");

			choice = Lib.ReadChoice(2);

			switch (choice) {
				case 1: crud = new CRUDLivro(); break;
				case 2: crud = new CRUDAutor(); break;
			}

			if (choice != 0) crud.menu();

		} while (choice != 0);

		Lib.printdiv(1, 1, "FIM DO PROGRAMA");
	}
}
