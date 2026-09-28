package tarea1;

import java.io.File;
import java.io.IOException;

public class UD1_B1_T4_Javier_Verdugo_Mena {

	/*
	 * ¿Dónde se ha creado el directorio si lo ejecutas desde el IDE?
	 * 
	 * el fichero se crea en la raíz de la carpeta del proyecto Java dentro del IDE, 
	 * que es el  directorio de trabajo actual )
	 */

	public static void main(String[] args) {

	
		File directorio = new File("NUEVODIR");

		if (!directorio.exists()) {
			if (directorio.mkdir()) {
				System.out.println("Directorio 'NUEVODIR' creado correctamente");
			} else {
				System.out.println("No se pudo crear el directorio 'NUEVODIR'");
			}
		} else {
			System.out.println("El directorio 'NUEVODIR' ya existe");
		}

		
		File f1 = new File(directorio, "fichero1.txt");
		File f2 = new File(directorio, "fichero2.txt");

		try {
			if (f1.createNewFile()) {
				System.out.println("Fichero creado: " + f1.getName());
			} else {
				System.out.println("El fichero " + f1.getName() + " ya existe");
			}

			if (f2.createNewFile()) {
				System.out.println("Fichero creado: " + f2.getName());
			} else {
				System.out.println("El fichero " + f2.getName() + " ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error  al crear los ficheros: " + e.getMessage());
		}

		
		File f1Renombrado = new File(directorio, "fichero1_renombrado.txt");
		//renombramos el primer fichero 
		if (f1.exists()) {
			if (f1.renameTo(f1Renombrado)) {
				System.out.println("Fichero renombrado correctamente a: " + f1Renombrado.getName());
			} else {
				System.out.println("No se pudo renombrar el fichero " + f1.getName());
			}
		}

		//borramos el segundo fichero
		if (f2.exists()) {
			if (f2.delete()) {
				System.out.println("Fichero '" + f2.getName() + "'  se ha borrado correctamente");
			} else {
				System.out.println("No se ha podido  borrar el fichero '" + f2.getName() + "'");
			}
		}

	}

}