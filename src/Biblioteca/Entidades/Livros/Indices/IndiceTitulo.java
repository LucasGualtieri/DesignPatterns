package src.Biblioteca.Entidades.Livros.Indices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import src.Biblioteca.Arquivo;
import src.Biblioteca.Registro;
import src.Biblioteca.Entidades.Livros.Livro;
import src.Biblioteca.EstruturasDeDados.ListaInvertida;
import src.Biblioteca.Indices.Indice;

public class IndiceTitulo implements Indice {

	ListaInvertida listaInvertida;

	HashSet<String> stopWords;

	public IndiceTitulo(String string) throws Exception {

		listaInvertida = new ListaInvertida(
			4,
			string + "dicionario.listainvTitulo.db",
			string + "blocos.listainvTitulo.db"
		);

		CriarStopWordsList();
	}

	@Override
	public void create(Registro object) throws Exception {
		create(((Livro)object).getTitulo(), object.getID());
	}

	@Override
	public void update(Registro object) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(Registro object) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	private void CriarStopWordsList() {

		stopWords = new HashSet<>();
		
		String filePath = "EstruturasDeDados/StopWords.txt";
		String fileLine;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((fileLine = br.readLine()) != null) {
				stopWords.add(fileLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<String> removerStopWords(String string) {

		List<String> arrayLimpo = new ArrayList<>();

		for (String str : string.split(" ")) {
			if (!stopWords.contains(str)) {
				arrayLimpo.add(str);
			}
		}

		return arrayLimpo;
	}

	private String removerAcentos(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	private List<String> LimparString(String str) {
		str = removerAcentos(str.toLowerCase());
		return removerStopWords(str);
	}

	private void create(String string, int ID) throws Exception {

		List<String> lista = LimparString(string);

		for (String str : lista) {
			listaInvertida.create(str, ID);
		}
	}

	public List<Registro> read(Arquivo arquivo, String string) throws Exception {

		List<String> palavras = LimparString(string);

		HashSet<Integer> conjutoIDs = new HashSet<>();
		
		int[] dados = listaInvertida.read(palavras.get(0));
		
		for (int i : dados) conjutoIDs.add(i);

		for (int i = 1; i < palavras.size(); i++) {
			dados = listaInvertida.read(palavras.get(i));
			IntersecDeConjuntos(conjutoIDs, dados);
			if (conjutoIDs.isEmpty()) break;
		}

		List<Registro> objects = new LinkedList<>();

		for (int ID : conjutoIDs) {
			try { objects.add(arquivo.read(ID)); }
			catch (Exception e) {}
		}

		return objects;
	}

	public void delete(String string, int ID) throws Exception {

		List<String> lista = LimparString(string);

		for (String str : lista) {
			listaInvertida.delete(str, ID);
		}
	}

	public void IntersecDeConjuntos(HashSet<Integer> conjunto1, int[] conjunto2) {

		HashSet<Integer> conjunto2Set = new HashSet<>();

		for (int i : conjunto2) conjunto2Set.add(i);

		conjunto1.retainAll(conjunto2Set);
	}
}
