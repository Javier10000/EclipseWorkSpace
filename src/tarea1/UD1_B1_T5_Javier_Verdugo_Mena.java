package tarea1;

import java.io.File;

public class UD1_B1_T5_Javier_Verdugo_Mena {

	public static void main(String[] args) {
		File directorio = new File("NUEVODIR");

		if (!directorio.exists()) {
			System.out.println("El directorio (NUEVODIR) no existe");
			return;
		}

		System.out.println("eliminando directorios y todos su contenido...");
		boolean exito = borrarRecursivo(directorio);

		if (exito) {
			System.out.println("Proceso finalizado con exito");
		} else {
			System.out.println("Error: No se pudieron eliminar algunos elementos");
		}
	}

	/**
	 * Borramos los ficheros y directorios de forma recursiva.
	 * 
	 * @param elemento Archivo o directorio a borrar
	 * @return true si se borró con éxito, false en caso contrario (una bandera)
	 */
	public static boolean borrarRecursivo(File elemento) {
		boolean exito = true;

		// Si es un directorio, borramos primero todo su contenido
		if (elemento.isDirectory()) {
			File[] contenido = elemento.listFiles();
			if (contenido != null) {
				for (File f : contenido) {
					// Llamada recursiva para subficheros o subcarpetas
					if (!borrarRecursivo(f)) {
						exito = false;
					}
				}
			}
		}

		// Una vez esta vacío el directorio este se borra 
		if (elemento.delete()) {
			System.out.println("Eliminado: " + elemento.getPath());
		} else {
			System.out.println("Error al borrar: " + elemento.getPath());
			exito = false;
		}

		return exito;
	}
}