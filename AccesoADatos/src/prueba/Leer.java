package prueba;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Leer {

	public static void main(String[] args) {
		File f = new File(System.getProperty("user.home") + "//AD", "test.dat");
		// Trato de abrir Stream
		FileInputStream FIS_f = null;
		if (f.exists() && f.canRead()) {
			try {
				FIS_f = new FileInputStream(f);
				DataInputStream DIS_f = new DataInputStream(FIS_f);
				// Uso el Stream
				String nombre;
				int edad;
				try {
					while (true) {// Leemos hasta el final del fichero
						nombre = DIS_f.readUTF();
						edad = DIS_f.readInt();
						System.out.println("Nombre: " + nombre + "\tEdad: " + edad);
					}
				} catch (EOFException eof) {
					System.out.println("Lectura completada con exito");
				}
				// Cierro el Stream
				FIS_f.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				// Por si acaso, me aseguro de cerrar el stream
				try {
					FIS_f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
