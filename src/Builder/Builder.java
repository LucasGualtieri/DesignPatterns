package src.Builder;

public class Builder {

	public static class PessoaBuilder {	

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

	public static class Pessoa {

		private String nome, sobrenome;
		private int idade, altura;
		private float peso;

		public Pessoa() {

			nome = sobrenome = null;
			idade = altura = 0;
			peso = 0.0f;
		}

		public void setNome(String nome) { this.nome = nome; }
		public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
		public void setIdade(int idade) { this.idade = idade; }
		public void setAltura(int altura) { this.altura = altura; }
		public void setPeso(float peso) { this.peso = peso; }

		@Override
		public String toString() {

			StringBuilder builder = new StringBuilder();

			builder.append(String.format("Nome: %s\n", nome));
			builder.append(String.format("Sobrenome: %s\n", sobrenome));
			builder.append(String.format("Idade: %d\n", idade));
			builder.append(String.format("Altura: %dcm\n", altura));
			builder.append(String.format("Peso: %.2f\n", peso));

			return builder.toString();
		}
	}

	public static void main(String[] args) {

		Pessoa p = new PessoaBuilder()
		.nome("Lucas")
		.sobrenome("Gualtieri")
		.idade(22)
		.altura(186)
		.peso(90)
		.build();

		System.out.println(p);
	}
}
