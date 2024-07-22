package src.Biblioteca.Entidades.Livros;

import src.Biblioteca.EstruturasDeDados.Hash.HashExtensivelWrapper;
import src.Biblioteca.EstruturasDeDados.Tuplas.Pair;
import src.Biblioteca.Registro.Registro;

public class Teste extends HashExtensivelWrapper<Integer, String> {

	public Teste() throws Exception { }

	@Override
	protected void setPair(Registro registro) {
		pair = new Pair<Integer, String>();
	}
}
