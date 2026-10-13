package boletin3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UD1_B3_T1_JavierVerdugo {

	public static void main(String[] args) {
		File f = new File(System.getProperty("user.home") + File.separator + "AD" + File.separator + "refranes.txt");
		leerFileReader(f);
		leerBufferedReader(f);
	}

	public static void leerFileReader(File f) {
		System.out.println("Lectura con FileReader:");

		try (FileReader fr = new FileReader(f)) {
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			System.out.println("\nFin FileReader");

		} catch (FileNotFoundException e) {
			System.err.println("Error: No se ha encontrado el archivo en la ruta: " + f.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error de E/S durante la lectura del archivo.");
			e.printStackTrace();
		}
	}

	public static void leerBufferedReader(File f) {
		System.out.println();
		System.out.println("Lectura con BufferedReader:");

		try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			System.out.println("Fin BufferedReader");

		} catch (FileNotFoundException e) {
			System.err.println("Error: No se ha encontrado el archivo en la ruta: " + f.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error de E/S durante la lectura de líneas.");
			e.printStackTrace();
		}
	}
}