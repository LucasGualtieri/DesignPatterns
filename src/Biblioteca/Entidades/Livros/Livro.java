package src.Biblioteca.Entidades.Livros;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

import src.Biblioteca.Registro.Registro;
import src.Biblioteca.Utils.Util;

public class Livro implements Registro {
	
	private int ID;
	private String ISBN;
	private String titulo;
	private String autor;
	private float preco;
	private long address;

	@SuppressWarnings("deprecation")
	Locale localeBR = new Locale("pt", "BR");

	public Registro clone() { return null; }

	public Livro() { this(-1, "null", "null", -0F); }

	public Livro(String titulo, String autor, float preco) { this(-1, titulo, autor, preco); }

	public Livro(int ID, String titulo, String autor, float preco) {
		this.ID = ID;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
	}

	public Livro(byte[] array) { fromByteArray(array); }

	public byte[] toByteArray() throws Exception {

		ByteArrayOutputStream ba_out = null;

		ba_out = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(ba_out);

		dos.writeInt(this.ID);
		dos.writeUTF(this.ISBN);
		dos.writeUTF(this.titulo);
		dos.writeUTF(this.autor);
		dos.writeFloat(this.preco);

		return ba_out.toByteArray();
	}

	public void fromByteArray(byte[] ba) {

		ByteArrayInputStream ba_in;
		
		try {

			ba_in = new ByteArrayInputStream(ba);
			DataInputStream dis = new DataInputStream(ba_in);

			this.ID = dis.readInt();
			this.ISBN = dis.readUTF();
			this.titulo = dis.readUTF();
			this.autor = dis.readUTF();
			this.preco = dis.readFloat();
		}

		catch (Exception e) { e.printStackTrace(); }
	}

	// Função para ler o ISBN e testar se é um ISBN valído (em termos do comprimento da string)
	public static String readISBN(boolean update) {
		
		String value = null;

		boolean invalid = false;

		do {
			if (invalid) {
				Util.cprintf(Util.BOLD + Util.RED, "Valor inválido, ");
				System.out.print("tente novamente: ");
			}

			value = Util.readString();

			if (value.length() != 13 && value.length() != 0
				|| (value.length() == 0 && !update)
				|| value.contains(" ")
				|| value.contains("-")
			) { invalid = true; }

			else invalid = false;

		} while (invalid);

		return value;
	}

	// Função para printar o ISBN com a máscara
	private String mascaraISBN() {
		StringBuilder builder = new StringBuilder();
        
		builder.append(ISBN.substring(0, 3))
		.append("-")
		.append(ISBN.substring(3, 4))
		.append("-")
		.append(ISBN.substring(4, 7))
		.append("-")
		.append(ISBN.substring(7, 12))
		.append("-")
		.append(ISBN.substring(12));

		return builder.toString();
	}

	// Função que printa o cabeçalho com os dados dos livros em formato CSV
	public void printHeader() {
		System.out.println("ID, ISBN, Título, Autor, Preço");
	}
	
	// Função que printa um livro em formato CSV
	public String toTable() {
		String str;
		str = this.ID + ", ";
		str += this.ISBN  + ", ";
		str += this.titulo  + ", ";
		str += this.autor + ", ";
		str += NumberFormat.getCurrencyInstance(localeBR).format(this.preco);
		
		return str + "\n";
	}
	
	// Função que printa o cabeçalho com os dados dos livros em formato CSV com cores
	public void printHeaderCSV() {
		System.out.println(
			Util.BOLD + Util.YELLOW + "ID, " +
			Util.CYAN + "ISBN, " +
			Util.RED + "Título, " +
			Util.BLUE + "Autor, " + 
			Util.GREEN + "Preço" + Util.RESET
		);
	}

	// Função que printa um livro em formato CSV com cores
	public String toCSV() {
		String str;

		str = Util.BOLD + Util.YELLOW + this.ID + ", ";
		str += Util.CYAN + mascaraISBN() + ", ";
		str += Util.RED + this.titulo  + ", ";
		str += Util.BLUE + this.autor  + ", ";
		str += Util.GREEN + NumberFormat.getCurrencyInstance(localeBR).format(this.preco);
		str += Util.RESET;

		return str + "\n";
	}

	public String toString() {

		String str = "";
		if (this.ID != -1) {
			str += Util.YELLOW + Util.BOLD + "ID: " + Util.RESET + this.ID + "\n";
		}
		str += Util.CYAN + Util.BOLD + "ISBN: " + Util.RESET + this.ISBN;
		str += Util.RED + Util.BOLD + "\nTítulo: " + Util.RESET + this.titulo;
		str += Util.BLUE + Util.BOLD + "\nAutor: " + Util.RESET + this.autor;
		str += Util.GREEN + Util.BOLD + "\nPreço: " + Util.RESET + NumberFormat.getCurrencyInstance(localeBR).format(this.preco);

		return str;
	}

	public void setID(int i) { this.ID = i; }
	public int getID() { return this.ID; }
	
	public void setISBN(String isbn) { this.ISBN = isbn; }
	public String getISBN() { return this.ISBN; }

	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getTitulo() { return this.titulo; }

	public void setAutor(String autor) { this.autor = autor; }
	public String getAutor() { return this.autor; }

	public float getPreco() { return this.preco; }
	public void setPreco(float preco) { this.preco = preco; }

	public void setAddress(long address) { this.address = address; }
	public long getAddress() { return address; }
}
