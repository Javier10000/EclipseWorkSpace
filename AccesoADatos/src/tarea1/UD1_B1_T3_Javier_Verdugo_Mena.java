package tarea1;

import java.io.File;
import java.io.IOException;

public class UD1_B1_T3_Javier_Verdugo_Mena {

	public static void main(String[] args) {
		File f;

		if (args.length > 0) {
			f = new File(args[0]);
		} else {
			String userHome = System.getProperty("user.home");
			File directorioAD = new File(userHome, "AD");

			if (!directorioAD.exists()) {
				directorioAD.mkdirs();
			}

			f = new File(directorioAD, "ArchivoEjemploo.txt");

			if (!f.exists()) {
				try {
					f.createNewFile();
					System.out.println("Fichero de ejemplo creado en: " + f.getAbsolutePath());
				} catch (IOException e) {
					System.out.println("Error al crear el archivo de ejemplo: " + e.getMessage());
				}
			}
		}

		if (f.exists()) {
			System.out.println("----------------------");
			System.out.println("Informacion del Fichero o Directorio");
			System.out.println("Nombre del fichero: " + f.getName());
			System.out.println("Su ruta: " + f.getPath());
			System.out.println("Su ruta Absoluta: " + f.getAbsolutePath());
			System.out.println("Es fichero o directorio: " + (f.isDirectory() ? "Directorio" : "Fichero"));
			System.out.println("Se puede leer: " + f.canRead());
			System.out.println("Se puede escribir: " + f.canWrite());
			System.out.println("Su tamaño: " + f.length() + " bytes");
			System.out.println("El nombre de su directorio padre: " + f.getParent());
			System.out.println("---------------------");
		} else {
			System.out.println("El fichero o directorio especificado no existe");
		}
	}

}