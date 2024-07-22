package src.Biblioteca.EstruturasDeDados.Hash;

import src.Biblioteca.EstruturasDeDados.Tuplas.Pair;
import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Utils.Indice;

public abstract class HashExtensivelWrapper<K, V> implements Indice {

	private HashExtensivel<Pair<K, V>> hash;
	protected Pair<K, V> pair;
	//protected int chave;

	//protected static HashExtensivel<ParIDEndereco> indiceDireto;
	public HashExtensivelWrapper() throws Exception {

		//index = new HashExtensivel<>(
		//	ParIsbnId.getConstructor(), 4,
		//	string + ".hashISBN_d.db",
		//	string + ".hashISBN_c.db"
		//);
	}

	protected abstract void setPair(Registro registro);

	@Override
	public void create(Registro registro) throws Exception {
		setPair(registro);
		hash.create(pair);
	}

	@Override
	public Registro read(Registro registro, Indice direto) throws Exception {
		//int id = index.read(chave).();
		//return direto.read(id, direto);
		return null;
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
