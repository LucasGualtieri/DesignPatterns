package src.Biblioteca.Utils;

import src.Biblioteca.Registro.Registro;

public interface Indice {

	public void create(Registro registro) throws Exception;
	public Registro read(Registro registro, Indice direto) throws Exception;
	public void update(Registro registro) throws Exception;
	public void delete(Registro registro) throws Exception;
}
