package src.Biblioteca.Registros;

public interface Registro {

	public int getID();
	public void fromByteArray(byte[] array);
	public byte[] toByteArray() throws Exception;
	public Registro clone();

	public String toCSV();
	public String toTable();
	public void printHeader();
	public void setID(int id);
	public void printHeaderCSV();
	public void setAll(boolean update);

	public Registro newInstance();

}
