package boletin3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UD1_B3_T2_JavierVerdugo {

	public static void main(String[] args) {
		String userHome = System.getProperty("user.home");
		File dir = new File(userHome + File.separator + "AD");
		File fOriginal = new File(dir, "refranes.txt");
		
		if (!fOriginal.exists()) {
			System.out.println("El archivo 'refranes.txt' no existe en la ruta: " + fOriginal.getAbsolutePath());
			System.out.println("Por favor, asegúrate de colocar el archivo antes de ejecutar el programa.");
			return;
		}

		Scanner scanner = new Scanner(System.in);
		char vocalElegida = ' ';
		boolean vocalValida = false;

		while (!vocalValida) {
			System.out.print("Introduce una vocal (a, e, i, o, u): ");
			String entrada = scanner.nextLine().trim();
			
			if (entrada.length() == 1) {
				char c = Character.toLowerCase(entrada.charAt(0));
				if (esVocal(c)) {
					vocalElegida = c;
					vocalValida = true;
				} else {
					System.out.println("El caracter introducido no es una vocal. Inténtalo de nuevo.");
				}
			} else {
				System.out.println("Por favor, introduce exactamente un carácter.");
			}
		}
		scanner.close();

		File fDestino = new File(dir, "refranes_CON_" + vocalElegida + ".txt");

		try {
			copiaConVocal(fOriginal, fDestino, vocalElegida);
			System.out.println("¡Proceso completado con éxito!");
			System.out.println("Archivo generado en: " + fDestino.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Ha ocurrido un error de E/S durante el proceso:");
			e.printStackTrace();
		}
	}

	
	public static boolean esVocal(char c) {
		char lower = Character.toLowerCase(c);
		return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u' ||
		       lower == 'á' || lower == 'é' || lower == 'í' || lower == 'ó' || lower == 'ú' || lower == 'ü';
	}
	public static void copiaConVocal(File f1, File f2, char c) throws IOException {
		try (FileReader fr = new FileReader(f1);
			 FileWriter fw = new FileWriter(f2)) {
			
			int dato;
			while ((dato = fr.read()) != -1) {
				char leido = (char) dato;
				
				if (esVocal(leido)) {
					if (Character.isUpperCase(leido)) {
						fw.write(Character.toUpperCase(c));
					} else {
						fw.write(c);
					}
				} else {
					fw.write(leido);
				}
			}
		}
	}
}