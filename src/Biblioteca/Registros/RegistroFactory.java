package src.Biblioteca.Registros;

public abstract class RegistroFactory {

	protected Registro registro;

	public abstract Registro newRegistro();
	public abstract Registro newRegistro(byte[] registroBytes);
	public abstract Registro readNewRegistro();
	public abstract Registro readNewRegistro(Registro registro);

	public void printHeader() { registro.printHeader(); }

	public void printHeaderCSV() { registro.printHeaderCSV(); }
}
