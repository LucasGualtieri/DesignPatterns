package src.Biblioteca.Entidades.Livros;

import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Registro.RegistroFactory;
import src.Biblioteca.Utils.Util;

public class LivroFactory extends RegistroFactory {

	@Override
	public Registro newRegistro() { return new Livro(); }

	@Override
	public Registro newRegistro(byte[] registroBytes) {
		
		Livro livro = new Livro(registroBytes);

		return livro;
	}

	private String readISBN(String msg) {
		
		System.out.print(msg);

		String value = null;

		boolean invalid = false;

		do {
			if (invalid) {
				Util.cprintf(Util.BOLD + Util.RED, "Valor inválido, ");
				System.out.print("tente novamente: ");
			}

			value = Util.readString();

			if (value.length() != 13 && value.length() != 0
				|| (value.length() == 0)
				|| value.contains(" ")
				|| value.contains("-")
			) { invalid = true; }

			else invalid = false;

		} while (invalid);

		return value;
	}

	@Override
	public Registro readNewRegistro() {
		
		LivroBuilder builder = new LivroBuilder();

		String aux = readISBN("Insira o ISBN do livro: ");
		if (!aux.isEmpty()) builder.isbn(aux);
		
		aux = Util.readString("Insira o título do livro: ");
		if (!aux.isEmpty()) builder.titulo(aux);

		System.out.print("Insira o nome do autor do livro: ");
		aux = Util.readString();
		if (!aux.isEmpty()) builder.autor(aux);

		float auxF = Util.readFloat("Insira o preço do livro: ");
		if (auxF != -1) builder.preco(auxF);

		return builder.build();
	}

	@Override
	public Registro readNewRegistro(Registro registro) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'readNewRegistro'");
	}

	@Override
	public void printHeader() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'printHeader'");
	}

	@Override
	public void printHeaderCSV() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'printHeaderCSV'");
	} }
