package src.Biblioteca.IndiceWrappers;

import src.Biblioteca.Registros.Registro;

// Esse é o Observador: Foi necessário mais do que um método update() nesse caso.
public interface Indice {

	public void create(Registro registro) throws Exception;
	public Registro read(Registro registro) throws Exception;
	public void update(Registro registro) throws Exception;
	public void delete(Registro registro) throws Exception;
}
