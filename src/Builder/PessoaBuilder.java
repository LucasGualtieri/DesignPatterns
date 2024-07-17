package src.Builder;

public class PessoaBuilder {	

	Pessoa p;

	public PessoaBuilder() { p = new Pessoa(); }

	public PessoaBuilder nome(String nome) {
		p.setNome(nome);
		return this;
	}

	public PessoaBuilder sobrenome(String sobrenome) {
		p.setSobrenome(sobrenome);
		return this;
	}

	public PessoaBuilder idade(int idade) {
		p.setIdade(idade);
		return this;
	}

	public PessoaBuilder altura(int altura) {
		p.setAltura(altura);
		return this;
	}

	public PessoaBuilder peso(float peso) {
		p.setPeso(peso);
		return this;
	}

	public Pessoa build() { return p; }
}
