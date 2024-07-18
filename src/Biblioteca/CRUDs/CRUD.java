package src.Biblioteca.CRUDs;

import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

import src.Biblioteca.DataFileManager;
import src.Biblioteca.Lib;
import src.Biblioteca.EstruturasDeDados.Compressao.LZW;
import src.Biblioteca.Registros.Registro;
import src.Biblioteca.Registros.RegistroFactory;

public abstract class CRUD {

	protected DataFileManager fileManager;
	protected RegistroFactory registroFactory;

	public static final String PATH = "Entidades/";

	public abstract int menu();
	public abstract List<Registro> search();
	public abstract int SortList(List<Registro> list);

	void Create(DataFileManager fileManager) throws Exception {

		Lib.clearScreen();
		Lib.printdiv(1, "Cadastrando na base de dados: %s", fileManager.getNomePlural());

		Registro registro = registroFactory.readNewRegistro();
		System.out.println("\n" + registro + "\n");

		Lib.cprintf("GREEN", "1 - Confirmar cadastro.\n");
		Lib.cprintf("RED", "2 - Cancelar cadastro.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Lib.ReadChoice(2);

		Lib.clearScreen();

		if (escolha != 1) Lib.cprintf("BOLD RED", "Cadastro cancelado.\n\n");

		else {
			try {
				fileManager.create(registro);

				Lib.cprintf("BOLD GREEN", "%s cadastrado com sucesso!\n\n", fileManager.getName());

				System.out.println(registro + "\n");
			}
			catch (Exception e) {
				Lib.cprintf("BOLD RED", "Falha ao cadastrar %s.\n\n", fileManager.getNomeLowerCase());
				// Lib.cprintf("BOLD RED", "Falha ao cadastrar %s: %s\n\n", fileManager.getNomeLowerCase(), e.getMessage());
			}
		}
	}

	void Read(DataFileManager fileManager) throws Exception {

		Lib.clearScreen();
		Lib.printdiv(1, "Pesquisando na base de dados: %s", fileManager.getNomePlural());

		// Preciso pensar em como vou fazer para voltar para o menu anterior quando o usuario escolher 0, talvez com um if return; ou com uma exceção.
		try {
			List<Registro> registros = search();

			Lib.clearScreen();

			if (registros.size() == 1) {

				Registro registro = registros.get(0);
				Lib.cprintf("BOLD GREEN", "%s encontrado com sucesso!\n\n", fileManager.getName());
				System.out.println(registro + "\n");
			}

			else if (registros.size() > 1) {

				Lib.cprintf("BOLD GREEN", "Os seguintes %s foram encontrados:\n\n", fileManager.getNomePluralLowerCase());

				int[] i = {1};
				registros.forEach((obj) -> System.out.printf("%d- %s", i[0]++, obj.toCSV()));

				System.out.println();
			}

			else Lib.cprintf("BOLD RED", "Nenhum %s encontrado!\n\n", fileManager.getNomeLowerCase());
		}

		//catch (Return e) { /* simplesmente não faz nada. */ }
		catch (Exception e) {
			// Aqui deveria ser uma mensagem descritiva, houve um erro ao encontrar o livro: erro tal tal tal
			//if (print) Lib.cprintf("BOLD RED", "\n%s não encontrado.\n\n", fileManager.getName());
			//else throw new Exception("Registro não encontrado.");
		}
	}

	// Quando cancelar a atualização esta mandando mensagem de livro não encontrado
	void Update(DataFileManager fileManager) throws Exception {

		Lib.clearScreen();
		Lib.printdiv(1, "Atualizando a base de dados: %s", fileManager.getNomePlural());

		Registro oldObject, newObject;

		try {
			oldObject = chooseRegistro(search());
			if (oldObject == null) {
				// Pensar em maneiras melhores de voltar para o outro menu
				// Talvez seja importante quebrar esse metodo update em subrotinas
				Lib.clearScreen();
				return;
			}
		}
		catch (Exception e) {
			// Novamente aqui deve ser responsavel por dizer que houve um erro
			//Lib.cprintf("BOLD RED", "\n%s não encontrado.\n\n", fileManager.getName());
			return;
		}

		// -----------------------------------------------------------------------------------------------

		System.out.println("\n" + oldObject + "\n");

		Lib.cprintf("GREEN", "1 - Atualizar os dados.\n");
		Lib.cprintf("RED", "2 - Cancelar atualização.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Lib.ReadChoice(2);

		if (escolha == 1) {
			System.out.println();
			newObject = registroFactory.readNewRegistro(oldObject);
			System.out.println("\n" + newObject + "\n");
		}

		else {
			Lib.clearScreen();
			Lib.cprintf("BOLD RED", "\nAtualização cancelada.\n\n");
			return;
		}

		// -----------------------------------------------------------------------------------------------

		Lib.cprintf("GREEN", "1 - Confirmar atualização.\n");
		Lib.cprintf("RED", "2 - Cancelar atualização.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		escolha = Lib.ReadChoice(2);

		Lib.clearScreen();

		if (escolha != 1) Lib.cprintf("BOLD RED", "Atualização cancelada.\n\n");

		else {
			try {
				fileManager.update(newObject);
				Lib.cprintf("BOLD GREEN", "%s atualizado com sucesso!\n\n", fileManager.getName());
				System.out.println(newObject + "\n");
			}
			catch (Exception e) {
				Lib.cprintf("BOLD RED", "Falha ao atualizar %s.\n", fileManager.getNomeLowerCase());
				Lib.cprintf("BOLD RED", "Motivo: %s.\n\n", e.getMessage());
				// Lib.cprintf("BOLD RED", "Falha ao cadastrar %s: %s\n\n", arquivo.getNomeLowerCase(), e.getMessage());
			}
		}
	}

	void Delete(DataFileManager fileManager) throws Exception {

		Lib.clearScreen();
		Lib.printdiv(1, "Excluindo da base de dados: %s", fileManager.getNomePlural());

		Registro registro;

		try { 
			registro = chooseRegistro(search());
			// Novamente, talvez há jeitos melhores de retornar.
			if (registro == null) {
				Lib.clearScreen();
				return;
			}
		}
		catch (Exception e) {
			// Aqui deveria ser uma mensagem de erro!
			Lib.cprintf("BOLD RED", "\n%s não encontrado.\n\n", fileManager.getName());
			return;
		}

		System.out.println("\n" + registro + "\n");

		Lib.cprintf("GREEN", "1 - Confirmar exclusão.\n");
		Lib.cprintf("RED", "2 - Cancelar exclusão.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Lib.ReadChoice(2);

		Lib.clearScreen();

		if (escolha == 1) {
			// Não usei try-catch pois não encontrei motivos para falha na exclusão.
			fileManager.delete(registro);
			Lib.cprintf("BOLD GREEN", "%s excluído com sucesso!\n\n", fileManager.getName());
		}

		else Lib.printdiv("Exclusão cancelada");
	}

	void Listar(DataFileManager fileManager) throws Exception {

		Lib.clearScreen();

		List<Registro> list = fileManager.Listar();

		if (list.isEmpty()) {
			Lib.printdiv("Base de dados vazia: %s", fileManager.getNomePlural());
			return;
		}

		Lib.printdiv(1, "Listando a base de dados: %s", fileManager.getNomePlural());

		if (SortList(list) == 0) {
			Lib.clearScreen();
			return;
		}

		registroFactory.printHeaderCSV();

		int[] i = {1};
		list.forEach((teste) -> System.out.printf("%d- %s", i[0]++, teste.toCSV()));
		System.out.println();
	}

	void Backup(DataFileManager fileManager) throws Exception  {

		Lib.clearScreen();
		Lib.printdiv(1, "Realizando backup na base de dados: %s", fileManager.getNomePlural());

		Lib.cprintf("GREEN", "1 - Confirmar backup.\n");
		Lib.cprintf("RED", "2 - Cancelar backup.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Lib.ReadChoice(2);

		Lib.clearScreen();

		if (escolha != 1) {
			Lib.cprintf("BOLD RED", "Backup cancelado.\n\n");
			return;
		}

		Path folderPath = Paths.get(PATH + fileManager.getNomePlural() + "/Dados");

		LZW compress = new LZW(fileManager.getNomePlural(), PATH + "../Backups/", true);

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath)) {
			for (Path filePath : stream) {
				String fileName = filePath.getFileName().toString();
				byte[] fileBytes = Files.readAllBytes(filePath);
				compress.add(fileName, fileBytes);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			Lib.cprintf("BOLD RED", "Falha ao fazer o backup.\n\n");
			return;
		}

		Lib.cprintf("BOLD GREEN", "Dados dos %s salvos e comprimidos com sucesso!\n\n", fileManager.getNomePluralLowerCase());

		compress.close();

		System.out.println(compress);
	}

	void RecoverBackup(DataFileManager arquivo) throws Exception  {

		Lib.clearScreen();
		Lib.printdiv(1, "Recuperando backup na base de dados: %s", arquivo.getNomePlural());

		Path folderPath = Paths.get(PATH + "../Backups/");

		List<Path> files = new LinkedList<>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath)) {
			for (Path file : stream) {
				String str = file.getFileName().toString().substring(0, arquivo.getNomePlural().length());
				if (Files.isRegularFile(file) && str.equals(arquivo.getNomePlural())) files.add(file);
			}
		}

		catch (Exception e) {
			// e.printStackTrace();
			Lib.cprintf("BOLD RED", "Falha ao fazer a recuperação.\n\n");
			return;
		}

		System.out.println("Backups encontrados:\n");

		int i = 0;
		for (Path file : files) {
			String fileName = file.getFileName().toString();
			System.out.printf("%d - %s\n", ++i, fileName);
		}

		System.out.println("\n0 - Voltar.");

		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Lib.ReadChoice(i);

		if (escolha == 0) {
			Lib.clearScreen();
			Lib.cprintf("BOLD RED", "Recuperação cancelada.\n\n");
			return;
		}

		Path backup = files.get(escolha - 1);

		Lib.cprintf("GREEN", "\n1 - Confirmar recuperação.\n");
		Lib.cprintf("RED", "2 - Cancelar recuperação.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		escolha = Lib.ReadChoice(2);

		Lib.clearScreen();

		if (escolha != 1) {
			Lib.cprintf("BOLD RED", "Recuperação cancelada.\n\n");
			return;
		}

		// System.out.println("File name: " + backup.getFileName());

		LZW decompress = new LZW(arquivo.getNomePlural(), PATH + "../Backups/", false);

		decompress.recover(backup);

		Lib.clearScreen();
		Lib.cprintf("BOLD GREEN", "Dados dos %s recuperados e descomprimidos com sucesso!\n\n", arquivo.getNomePluralLowerCase());
	}

	private Registro chooseRegistro(List<Registro> list) {
		// Interface que lista os registro e permite que o usuário escolha;
		// É preciso retornar o primeiro sem perguntar nada ao usario caso a lista tenha exatamente um.
		return null;
	}
}
