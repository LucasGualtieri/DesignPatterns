package src.Biblioteca.EstruturasDeDados.Tuplas;

import src.Biblioteca.Registro.Registro;

public interface PairFactory<K, V> {
	public Pair<K, V> newPair(Registro registro);
}
