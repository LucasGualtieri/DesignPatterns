package src.Biblioteca.Utils;

import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

import src.Biblioteca.EstruturasDeDados.Compressao.LZW;
import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Registro.RegistroFactory;

public abstract class CRUD {

	protected DataFileManager fileManager;
	protected RegistroFactory registroFactory;

	public static final String PATH = "Entidades/";

	public abstract int menu();
	public abstract List<Registro> search();
	public abstract int SortList(List<Registro> list);

	protected void create() throws Exception {

		Util.clearScreen();
		Util.printdiv(1, "Cadastrando na base de dados: %s", fileManager.getNomePlural());

		Registro registro = registroFactory.readNewRegistro();
		System.out.println("\n" + registro + "\n");

		Util.cprintf("GREEN", "1 - Confirmar cadastro.\n");
		Util.cprintf("RED", "2 - Cancelar cadastro.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Util.ReadChoice(2);

		Util.clearScreen();

		if (escolha != 1) Util.cprintf("BOLD RED", "Cadastro cancelado.\n\n");

		else {
			try {
				fileManager.create(registro);

				Util.cprintf("BOLD GREEN", "%s cadastrado com sucesso!\n\n", fileManager.getName());

				System.out.println(registro + "\n");
			}
			catch (Exception e) {
				Util.cprintf("BOLD RED", "Falha ao cadastrar %s.\n\n", fileManager.getNomeLowerCase());
				// Util.cprintf("BOLD RED", "Falha ao cadastrar %s: %s\n\n", fileManager.getNomeLowerCase(), e.getMessage());
			}
		}
	}

	protected void read() throws Exception {

		Util.clearScreen();
		Util.printdiv(1, "Pesquisando na base de dados: %s", fileManager.getNomePlural());

		// Preciso pensar em como vou fazer para voltar para o menu anterior quando o usuario escolher 0, talvez com um if return; ou com uma exceção.
		try {
			List<Registro> registros = search();

			Util.clearScreen();

			if (registros.size() == 1) {

				Registro registro = registros.get(0);
				Util.cprintf("BOLD GREEN", "%s encontrado com sucesso!\n\n", fileManager.getName());
				System.out.println(registro + "\n");
			}

			else if (registros.size() > 1) {

				Util.cprintf("BOLD GREEN", "Os seguintes %s foram encontrados:\n\n", fileManager.getNomePluralLowerCase());

				int[] i = {1};
				registros.forEach((obj) -> System.out.printf("%d- %s", i[0]++, obj.toCSV()));

				System.out.println();
			}

			else Util.cprintf("BOLD RED", "Nenhum %s encontrado!\n\n", fileManager.getNomeLowerCase());
		}

		//catch (Return e) { /* simplesmente não faz nada. */ }
		catch (Exception e) {
			// Aqui deveria ser uma mensagem descritiva, houve um erro ao encontrar o livro: erro tal tal tal
			//if (print) Util.cprintf("BOLD RED", "\n%s não encontrado.\n\n", fileManager.getName());
			//else throw new Exception("Registro não encontrado.");
		}
	}

	// Quando cancelar a atualização esta mandando mensagem de livro não encontrado
	protected void update() throws Exception {

		Util.clearScreen();
		Util.printdiv(1, "Atualizando a base de dados: %s", fileManager.getNomePlural());

		Registro oldObject, newObject;

		try {
			oldObject = chooseRegistro(search());
			if (oldObject == null) {
				// Pensar em maneiras melhores de voltar para o outro menu
				// Talvez seja importante quebrar esse metodo update em subrotinas
				Util.clearScreen();
				return;
			}
		}
		catch (Exception e) {
			// Novamente aqui deve ser responsavel por dizer que houve um erro
			//Util.cprintf("BOLD RED", "\n%s não encontrado.\n\n", fileManager.getName());
			return;
		}

		// -----------------------------------------------------------------------------------------------

		System.out.println("\n" + oldObject + "\n");

		Util.cprintf("GREEN", "1 - Atualizar os dados.\n");
		Util.cprintf("RED", "2 - Cancelar atualização.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Util.ReadChoice(2);

		if (escolha == 1) {
			System.out.println();
			newObject = registroFactory.readNewRegistro(oldObject);
			System.out.println("\n" + newObject + "\n");
		}

		else {
			Util.clearScreen();
			Util.cprintf("BOLD RED", "\nAtualização cancelada.\n\n");
			return;
		}

		// -----------------------------------------------------------------------------------------------

		Util.cprintf("GREEN", "1 - Confirmar atualização.\n");
		Util.cprintf("RED", "2 - Cancelar atualização.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		escolha = Util.ReadChoice(2);

		Util.clearScreen();

		if (escolha != 1) Util.cprintf("BOLD RED", "Atualização cancelada.\n\n");

		else {
			try {
				fileManager.update(newObject);
				Util.cprintf("BOLD GREEN", "%s atualizado com sucesso!\n\n", fileManager.getName());
				System.out.println(newObject + "\n");
			}
			catch (Exception e) {
				Util.cprintf("BOLD RED", "Falha ao atualizar %s.\n", fileManager.getNomeLowerCase());
				Util.cprintf("BOLD RED", "Motivo: %s.\n\n", e.getMessage());
				// Util.cprintf("BOLD RED", "Falha ao cadastrar %s: %s\n\n", fileManager.getNomeLowerCase(), e.getMessage());
			}
		}
	}

	protected void delete() throws Exception {

		Util.clearScreen();
		Util.printdiv(1, "Excluindo da base de dados: %s", fileManager.getNomePlural());

		Registro registro;

		try { 
			registro = chooseRegistro(search());
			// Novamente, talvez há jeitos melhores de retornar.
			if (registro == null) {
				Util.clearScreen();
				return;
			}
		}
		catch (Exception e) {
			// Aqui deveria ser uma mensagem de erro!
			Util.cprintf("BOLD RED", "\n%s não encontrado.\n\n", fileManager.getName());
			return;
		}

		System.out.println("\n" + registro + "\n");

		Util.cprintf("GREEN", "1 - Confirmar exclusão.\n");
		Util.cprintf("RED", "2 - Cancelar exclusão.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Util.ReadChoice(2);

		Util.clearScreen();

		if (escolha == 1) {
			// Não usei try-catch pois não encontrei motivos para falha na exclusão.
			fileManager.delete(registro);
			Util.cprintf("BOLD GREEN", "%s excluído com sucesso!\n\n", fileManager.getName());
		}

		else Util.printdiv("Exclusão cancelada");
	}

	protected void Listar() throws Exception {

		Util.clearScreen();

		List<Registro> list = fileManager.Listar();

		if (list.isEmpty()) {
			Util.printdiv("Base de dados vazia: %s", fileManager.getNomePlural());
			return;
		}

		Util.printdiv(1, "Listando a base de dados: %s", fileManager.getNomePlural());

		if (SortList(list) == 0) {
			Util.clearScreen();
			return;
		}

		registroFactory.printHeaderCSV();

		int i = 0;
		for (Registro r : list) {
			System.out.printf("%d- %s", i++, r.toCSV());
		}

		System.out.println();
	}

	protected void Backup() throws Exception  {

		Util.clearScreen();
		Util.printdiv(1, "Realizando backup na base de dados: %s", fileManager.getNomePlural());

		Util.cprintf("GREEN", "1 - Confirmar backup.\n");
		Util.cprintf("RED", "2 - Cancelar backup.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		int escolha = Util.ReadChoice(2);

		Util.clearScreen();

		if (escolha != 1) {
			Util.cprintf("BOLD RED", "Backup cancelado.\n\n");
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
			Util.cprintf("BOLD RED", "Falha ao fazer o backup.\n\n");
			return;
		}

		Util.cprintf("BOLD GREEN", "Dados dos %s salvos e comprimidos com sucesso!\n\n", fileManager.getNomePluralLowerCase());

		compress.close();

		System.out.println(compress);
	}

	protected void RecoverBackup() throws Exception  {

		Util.clearScreen();
		Util.printdiv(1, "Recuperando backup na base de dados: %s", fileManager.getNomePlural());

		Path folderPath = Paths.get(PATH + "../Backups/");

		List<Path> files = new LinkedList<>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath)) {
			for (Path file : stream) {
				String str = file.getFileName().toString().substring(0, fileManager.getNomePlural().length());
				if (Files.isRegularFile(file) && str.equals(fileManager.getNomePlural())) files.add(file);
			}
		}

		catch (Exception e) {
			// e.printStackTrace();
			Util.cprintf("BOLD RED", "Falha ao fazer a recuperação.\n\n");
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

		int escolha = Util.ReadChoice(i);

		if (escolha == 0) {
			Util.clearScreen();
			Util.cprintf("BOLD RED", "Recuperação cancelada.\n\n");
			return;
		}

		Path backup = files.get(escolha - 1);

		Util.cprintf("GREEN", "\n1 - Confirmar recuperação.\n");
		Util.cprintf("RED", "2 - Cancelar recuperação.\n");
		System.out.print("\nEscolha uma das opções acima: ");

		escolha = Util.ReadChoice(2);

		Util.clearScreen();

		if (escolha != 1) {
			Util.cprintf("BOLD RED", "Recuperação cancelada.\n\n");
			return;
		}

		// System.out.println("File name: " + backup.getFileName());

		LZW decompress = new LZW(fileManager.getNomePlural(), PATH + "../Backups/", false);

		decompress.recover(backup);

		Util.clearScreen();
		Util.cprintf("BOLD GREEN", "Dados dos %s recuperados e descomprimidos com sucesso!\n\n", fileManager.getNomePluralLowerCase());
	}

	private Registro chooseRegistro(List<Registro> list) {
		// Interface que lista os registro e permite que o usuário escolha;
		// É preciso retornar o primeiro sem perguntar nada ao usario caso a lista tenha exatamente um.
		return null;
	}
}
