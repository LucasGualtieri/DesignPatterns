package src.Biblioteca.Entidades.Autores;

import src.Biblioteca.Entidades.Autores.Indices.ParCPFId;
import src.Biblioteca.EstruturasDeDados.Hash.HashExtensivel;
import src.Biblioteca.Utils.DataFileManager;

public class AutorDataManager extends DataFileManager {

	// IndicadorDeTamanho + ID + CPF + Nome + Sobrenome + Idade

	HashExtensivel<ParCPFId> indiceIndiretoCPF;
	// HashExtensivel<ParNomeID> indiceNome;

	public AutorDataManager(String filePath) throws NoSuchMethodException, SecurityException, Exception {
		
		super("Autor", new AutorFactory(), filePath);

		indiceIndiretoCPF = new HashExtensivel<>(
			ParCPFId.getConstructor(), 4,
			filePath + name + ".hashCPF_d.db",
			filePath + name + ".hashCPF_c.db"
		);
	}
}
