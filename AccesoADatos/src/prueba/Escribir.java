package prueba;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escribir {

	public static void main(String[] args) {
		// Definir ficheros – Escribir DataOutputStream
		File f = new File(System.getProperty("user.home") + "//AD", "test.dat");
		// Trato de abrir Stream
		FileOutputStream FOS_f = null;
		if (f.exists() && f.canWrite() || !f.exists()) {
		try {
		FOS_f = new FileOutputStream(f);
		DataOutputStream DOS_f = new DataOutputStream(FOS_f);
		//Uso el Stream
		String nombres[] = {"Ana", "Bob", "Carla", "Daniel"};
		int edades[] = {14, 15 , 16, 17};
		for (int i = 0; i < nombres.length; i++) {
		DOS_f.writeUTF(nombres[i]);
		DOS_f.writeInt(edades[i]);
		}
		//Cierro el Stream
		FOS_f.close();
		System.out.println("Escritura completada con exito");
		} catch (IOException ioe) {
		ioe.printStackTrace();
		} finally {
		// Por si acaso, me aseguro de cerrar el stream
		try {FOS_f.close();} catch (IOException e) {
		e.printStackTrace();
		}
		}
		}

	}

}
