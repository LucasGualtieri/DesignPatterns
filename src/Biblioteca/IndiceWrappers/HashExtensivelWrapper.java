package src.Biblioteca.IndiceWrappers;

import src.Biblioteca.Registros.Registro;
import src.Biblioteca.EstruturasDeDados.HashExtensivel;
import src.Biblioteca.EstruturasDeDados.RegistroHashExtensivel;

public abstract class HashExtensivelWrapper implements Indice {

	protected HashExtensivel<Pair> index;
	protected Pair pair;
	protected int chave;
	//protected static HashExtensivel<ParIDEndereco> indiceDireto;
	//public HashExtensivelWrapper(String string) throws Exception {

		//index = new HashExtensivel<>(
		//	ParIsbnId.getConstructor(), 4,
		//	string + ".hashISBN_d.db",
		//	string + ".hashISBN_c.db"
		//);
	//}

	protected abstract void setPair(Registro registro);

	@Override
	public void create(Registro object) throws Exception {
		setPair(object);
		index.create(pair);
	}

	protected abstract void setChave(Registro registro);

	@Override
	@SuppressWarnings("unchecked")
	public Registro read(Registro registro) throws Exception {
		return index.read(chave);
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
