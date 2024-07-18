package src.Biblioteca.Entidades.Livros.Indices;

import src.Biblioteca.Entidades.Livros.Livro;
import src.Biblioteca.EstruturasDeDados.RegistroHashExtensivel;
import src.Biblioteca.IndiceWrappers.HashExtensivelWrapper;
import src.Biblioteca.Registros.Registro;

public class IndiceIsbnId extends HashExtensivelWrapper {

	@Override
	@SuppressWarnings("unchecked")
	protected void setPair(Registro registro) {
		pair = (T)new ParIsbnId(((Livro)registro).getISBN(), registro.getID());
	}

	@Override
	protected void setChave(Registro registro) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setChave'");
	}

	
}
