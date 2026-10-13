package boletin3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;



public class UD1_B3_T4_JavierVerdugo {

	public static void main(String[] args) {
		File dir = new File(System.getProperty("user.home") + File.separator + "AD");

		if (!dir.exists()) {
			dir.mkdir();
		}
		File archivosPropiedades = new File(dir, "misPropiedades.props");
		Scanner sc = new Scanner(System.in);
		int opt = 0;

		do {
			System.out.println("Menu de propiedades");
			System.out.println("1. Ver propiedades");
			System.out.println("2. Introducir / Actualizar propiedad");
			System.out.println("3. Eliminar propiedad");
			System.out.println("4. Salir");
			System.out.println("Elija una opcion: ");
			if (sc.hasNextInt()) {
				opt = sc.nextInt();
				sc.nextLine();
				switch (opt) {
				case 1:
						MostrarPropiedad(archivosPropiedades);
					break;
				case 2:
					IntroducirPropiedad(archivosPropiedades);

					break;
				case 3:
					EliminarPropiedad(archivosPropiedades);

					break;
				case 4:
					
					System.out.println("Saliendo del programa");

					break;
				default:
					System.out.println("opcion no valida");
					break;

				}
			} else {
				System.out.println("Error: Por favor, introduce un numero valido.");
				sc.nextLine();
			}

		} while (opt != 4);

		sc.close();

	}

	public static void MostrarPropiedad(File f) {
		Properties p = cargar(f);
		if (p.isEmpty()) {
			System.out.println("el archivo no existe o esta vacio ");
		} else {
			System.out.println("Listado de perfecto");
			p.list(System.out);

		}

	}

	public static void EliminarPropiedad(File f) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce el nombre clave de la propiedad que deseas eliminar");
		String clave = sc.nextLine().trim();
		Properties p = cargar(f);

		if (p.containsKey(clave)) {
			p.remove(clave);
			guardar(p, f);
			System.out.println("la propiedad " + clave + " ha sido eliminada correctamente ");
		} else {
			System.out.println("Aviso: No se ha encontrado ninguna propiedad con el nombre" + clave + ".");

		}

	}

	public static void IntroducirPropiedad(File f) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce el nombre clave de la propiedad");
		String clave = sc.nextLine().trim();
		if (clave.isEmpty()) {
			System.out.println("el nombre no puede estar vacio ");
			return;
		}
		System.out.println("introduce el valor para " + clave + " :");
		String valor = sc.nextLine();

		Properties p = cargar(f);
		String mensajes = p.containsKey(clave) ? "propiedad actualizada correctamente" : "propiedad añadida con exito";
		p.setProperty(clave, valor);

		guardar(p, f);
		System.out.println(mensajes);
	}

	private static Properties cargar(File f) {
		Properties p = new Properties();
		if(f.exists()) {
			try(FileInputStream fis = new FileInputStream(f)){
				p.load(fis);
				
			}catch (IOException e) {
				System.out.println("error al leer el archivo de las propiedades");
			}
		}
		return p;

	}

	private static void guardar(Properties p, File f) {
		try (FileOutputStream fos = new FileOutputStream(f)) {
			p.store(fos, "archivo de propiedades del usuario");

		} catch (IOException e) {
			System.err.println("error al guardar el archivo" + e.getMessage());

		}

	}

}
