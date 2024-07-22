package src.Biblioteca.Utils;

import src.Biblioteca.EstruturasDeDados.Hash.HashExtensivel;
import src.Biblioteca.EstruturasDeDados.Tuplas.ParIDEndereco;
import src.Biblioteca.Registro.Registro;

public class IndiceDireto implements Indice {

	private HashExtensivel<ParIDEndereco> hash;

	public IndiceDireto(String dir) throws NoSuchMethodException, SecurityException, Exception {

		hash = new HashExtensivel<ParIDEndereco>(
			ParIDEndereco.getConstructor(), 3,
			dir + ".hash_d.db",
			dir + ".hash_c.db"
		);
	}

	@Override
	public void create(Registro registro) throws Exception {

		int id = registro.getID();
		long address = registro.getAddress();

		hash.create(new ParIDEndereco(id, address));
	}

	@Override
	public Registro read(Registro registro, Indice direto) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'read'");
	}

	@Override
	public void update(Registro registro) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(Registro registro) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
