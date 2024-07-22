package src.Biblioteca.Registro;

public abstract class RegistroFactory {

	protected Registro registro;

	public abstract Registro newRegistro();
	public abstract Registro newRegistro(byte[] registroBytes);
	public abstract Registro readNewRegistro();
	public abstract Registro readNewRegistro(Registro registro);
	public abstract void printHeader();
	public abstract void printHeaderCSV();
}
