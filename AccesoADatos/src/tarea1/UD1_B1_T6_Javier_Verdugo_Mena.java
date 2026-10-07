package tarea1;

import java.io.File;
import java.io.IOException;

public class UD1_B1_T6_Javier_Verdugo_Mena {

	public static void main(String[] args) {
		File directorio;

		if (args.length > 0) {
			directorio = new File(args[0]);
		} else {
			
			directorio = new File("user.home", "AD");

			// Si el directorio AD no existe, lo creamos 
			if (!directorio.exists()) {
				crearEstructuraEjemplo(directorio);
			}
		}

		if (directorio.exists() && directorio.isDirectory()) {
			System.out.println("Listado jerárquico de: " + directorio.getAbsolutePath());
			System.out.println("--------------------------------------------------");
			listarDirectorioRecursivo(directorio, 0);
		} else {
			System.out.println("El directorio especificado no existe o no es válido");
		}
	}

	/**
	 * Crea archivos/subdirectorios de prueba
	 */
	private static void crearEstructuraEjemplo(File directorioBase) {
		try {
			directorioBase.mkdirs();

			File f1 = new File(directorioBase, "Archivo1.txt");
			File f2 = new File(directorioBase, "Imagen.png");
			File subDir1 = new File(directorioBase, "subdirectorio1");
			File subDirImg = new File(subDir1, "imágenes");
			File f3 = new File(subDir1, "Tema5.pdf");
			File f4 = new File(subDirImg, "París.jpg");
			File f5 = new File(directorioBase, "ZArchivo2.txt");

			f1.createNewFile();
			f2.createNewFile();
			subDir1.mkdirs();
			f3.createNewFile();
			subDirImg.mkdirs();
			f4.createNewFile();
			f5.createNewFile();

			System.out.println("Se ha creado la estructura de ejemplo en: " + directorioBase.getAbsolutePath() + "\n");
		} catch (IOException e) {
			System.out.println("Error al crear la estructura de ejemplo: " + e.getMessage());
		}
	}

	/**
	 * Muestra el contenido de un directorio de forma recursiva y jerárquica
	 */
	public static void listarDirectorioRecursivo(File dir, int nivel) {
		File[] contenido = dir.listFiles();

		if (contenido == null) {
			return;
		}

		StringBuilder sangria = new StringBuilder();
		for (int i = 0; i < nivel; i++) {
			sangria.append("    ");
		}

		for (File f : contenido) {
			if (f.isDirectory()) {
				System.out.println(sangria + "/" + f.getName());
				listarDirectorioRecursivo(f, nivel + 1);
			} else {
				System.out.println(sangria + f.getName());
			}
		}
	}
}