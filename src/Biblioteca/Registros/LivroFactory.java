package src.Biblioteca.Registros;

import src.Biblioteca.Entidades.Livros.Livro;

public class LivroFactory extends RegistroFactory {

	public LivroFactory() { registro = new Livro(); }

	@Override
	public Registro newRegistro() { return new Livro(); }

	@Override
	public Registro newRegistro(byte[] registroBytes) {

		Livro livro = new Livro();
		livro.fromByteArray(registroBytes);

		return livro;
	}

	@Override
	public Registro readNewRegistro() { return readNewRegistro(new Livro()); }

	@Override
	public Registro readNewRegistro(Registro registro) {

		Registro livro = registro.clone();

		//System.out.print("Insira o ISBN do livro: ");
		//String aux = readISBN(update);
		//if (aux.length() > 0) this.ISBN = aux;
		//
		//System.out.print("Insira o título do livro: ");
		//aux = Lib.readString();
		//if (aux.length() > 0) this.titulo = aux;
		//
		//System.out.print("Insira o nome do autor do livro: ");
		//aux = Lib.readString();
		//if (aux.length() > 0) this.autor = aux;
		//
		//System.out.print("Insira o preço do livro: ");
		//float auxF = Lib.readFloat();
		//if (auxF != -1) preco = auxF;

		return livro;
	}
}
