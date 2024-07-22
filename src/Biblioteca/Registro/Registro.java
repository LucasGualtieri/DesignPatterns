package src.Biblioteca.Registro;

public interface Registro {

	public void fromByteArray(byte[] array);
	public byte[] toByteArray() throws Exception;
	public Registro clone();

	public String toCSV();
	public String toTable();

	public int getID();
	public void setID(int id);

	public void setAddress(long address);
	public long getAddress();
}
