package src.Biblioteca.EstruturasDeDados.Tuplas;

// import java.io.ByteArrayOutputStream;
// import java.io.DataOutputStream;
import java.io.IOException;

// import src.Biblioteca.ByteArrayFactory.ByteArrayFactory;
import src.Biblioteca.EstruturasDeDados.Hash.RegistroHashExtensivel;

public class Pair<K, V> implements RegistroHashExtensivel<Pair<K, V>> {

	// private K key;
	// private V value;
	// private ByteArrayFactory keyByteArray, valueByteArray;

	@Override
	public short size() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'size'");
	}

	@Override
	public byte[] toByteArray() throws IOException {

		//ByteArrayOutputStream ba_out = null;
		//
		//ba_out = new ByteArrayOutputStream();
		//DataOutputStream dos = new DataOutputStream(ba_out);
		//
		//dos.write(keyByteArray.toByteArray(key));
		//dos.write(valueByteArray.toByteArray(value));
		//
		//return ba_out.toByteArray();

		return null;
	}

	@Override
	public void fromByteArray(byte[] ba) throws IOException {

		//ByteArrayInputStream ba_in = new ByteArrayInputStream(ba);
		//DataInputStream dis = new DataInputStream(ba_in);
		//
		//key = keyByteArray(dis);
		//this.endereco = dis.readLong();
	}
}
