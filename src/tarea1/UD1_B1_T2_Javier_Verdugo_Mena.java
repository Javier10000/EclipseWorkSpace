package tarea1;

import java.io.File;

public class UD1_B1_T2_Javier_Verdugo_Mena {

	public static void main(String[] args) {
		File f;
		
		if (args.length > 0) {
			System.out.println("Listar el contenido de :" + args[0]);
			f = new File(args[0]);
		} else {
			// Ruta por defecto construida con el Home + Desktop/PruebaT2
			String rutaDefecto = System.getProperty("user.home") + File.separator + "AD";
			System.out.println("Listar el contenido de :" + rutaDefecto);
			f = new File(rutaDefecto);
		}

		System.out.println();

		// Validaciones
		if (!f.exists()) {
			System.out.println("El archivo o directorio especificado no existe.");
		} else if (!f.isDirectory()) {
			System.out.println("La ruta introducida no es un directorio.");
		} else {
			File[] elementos = f.listFiles();

			if (elementos != null) {
				System.out.println("Ficheros en el directorio actual: " + elementos.length);
				System.out.println();

				for (File elemento : elementos) {
					String tipo = elemento.isDirectory() ? "Directorio" : "Archivo";
					System.out.println("Nombre: " + elemento.getName() + " " + tipo);
					System.out.println();
				}
			} else {
				System.out.println("Ficheros en el directorio actual: 0");
			}
		}
	}
}