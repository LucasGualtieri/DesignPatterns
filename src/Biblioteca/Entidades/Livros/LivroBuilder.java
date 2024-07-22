package src.Biblioteca.Entidades.Livros;

public class LivroBuilder {

	private Livro livro;

	public LivroBuilder() { livro = new Livro(); }

	public void titulo(String titulo) { livro.setTitulo(titulo); }
	public void isbn(String isbn) { livro.setISBN(isbn); }
	public void preco(float preco) { livro.setPreco(preco); }
	public void autor(String autor) { livro.setAutor(autor); }

	public Livro build() { return livro; }
}
