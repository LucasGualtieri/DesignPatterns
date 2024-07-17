package src.Builder;

public class Builder {

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

