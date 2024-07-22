package src.Biblioteca.Utils;

import java.io.*;
import java.util.*;

import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Registro.RegistroFactory;

public abstract class DataFileManager {

	// private final short registerAvgLength = 40; // 2 + 4 + (2 + 14) + (2 + 12) + 4.
	final short HEADER_SIZE = 4;
	protected static RandomAccessFile file;
	protected String name, filePath;
	public RegistroFactory registroFactory;

	protected List<Indice> indices;
	private Indice indiceDireto;

	protected DataFileManager(String name, RegistroFactory registroFactory, String filePath) throws FileNotFoundException, IOException, Exception {

		this.name = name;

		initializeDataFile(filePath + getNomePlural());

		this.registroFactory = registroFactory;
		this.filePath = filePath;

		indiceDireto = new IndiceDireto(filePath + name);

		indices = new ArrayList<>();
		indices.add(indiceDireto);
	}

	private void initializeDataFile(String filePath) throws FileNotFoundException, IOException {

		file = new RandomAccessFile(filePath + ".db", "rw");

		if (file.length() < HEADER_SIZE) {
			file.seek(0);
			file.writeInt(0);
		}
	}

	// Todos os métodos CRUD devem retornar uma Exception no caso de falha, não quero usar boolean pra determinar a falha,
	// desse jeito ao lançar a Exception eu já consigo ser especificio com relacao ao problema.
	// A partir de agora eu vou simplificar muito o TP01 (lidar com registros excluidos), vou partir por esquema % 1000.

	private void IndicesCreate(Registro registro) throws Exception {
		for (Indice i : indices) i.create(registro);
	}

	// Esse método cria um registro no final do arquivo, retorna seu ID. E atualiza seus indices. 
	public int create(Registro registro) throws Exception {

		int lastID;

		file.seek(0);
		lastID = file.readInt() + 1;

		file.seek(0);
		file.writeInt(lastID);

		byte[] ba = registro.toByteArray();

		file.seek(file.length());
		long endereco = file.getFilePointer();

		file.writeByte(' ');
		file.writeShort(ba.length);
		file.write(ba);

		registro.setID(lastID);
		registro.setAddress(endereco);

		IndicesCreate(registro);

		return registro.getID();
	}

	// Método que busca no arquivo de dados a partir do ID usando o indiceDireto
	public Registro read(int id) { return null; }

	// Rececebe o novo registro contendo um ID do registro original. E atualiza seus indices.
	public void update(Registro newRegistro) { }

	// Recebe o registro, pesquisa sua posição no indiceDireto e marca como lapide usando "*" E atualiza seus indices.
	public void delete(Registro registro) { }

	// Método que percorre o arquivo sequencialmente e adiciona ao final de uma lista encadeada todos os registros não "lapidados"
	public List<Registro> Listar() throws IOException, Exception {

		List<Registro> list = new LinkedList<>();

		file.seek(HEADER_SIZE); // mover o ponteiro para o primeiro registro (após o cabeçalho)
		long len = file.length();

		while (file.getFilePointer() < len) {

			byte lapide = file.readByte();
			short tamanhoRegistro = file.readShort();
			
			if (lapide != '*') {

				
				byte[] registroBytes = new byte[tamanhoRegistro];
				file.read(registroBytes);

				list.add(registroFactory.newRegistro(registroBytes));
			}

			else file.skipBytes(tamanhoRegistro);
		}

		// Acho que é mais elegante apenas passar a lista e testar se é nonEmpty la fora
		return list.isEmpty() ? null : list;
	}

	public String getName() { return name; }
	public String getNomeLowerCase() { return name.toLowerCase(); }
	public String getNomePlural() { return name + "s"; }
	public String getNomePluralLowerCase() { return name.toLowerCase() + "s"; }

	public void close() throws Exception { file.close(); }
}
