package boletin2;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class UD1_B2_T4_NombreApellido2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		do {
			System.out.println("Hay " + contador() + " numeros guardados");
			System.out.println("1. Escribir numeros");
			System.out.println("2. Mostrar con saltos X");
			System.out.println("3. Salir");
			System.out.println("Selecciona una opcion: ");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				Escribir10();
				System.out.println("Numeros escritos");
				break;
			case 2:
				if (contador() != 0) {
					System.out.print("Introduce el valor del salto (X): ");
					int salto = sc.nextInt();
					MostrarConSalto(salto);
				} else {
					System.out.println("No hay numeros escritos");
				}
				break;
			case 3:
				System.out.println("Saliendo del programa");
			default:
				break;
			}

		} while (op != 3);
		sc.close();
	}

	public static void Escribir10() {
		File f = new File(System.getProperty("user.home") + File.separator + "AD", "datosFibonacci.dat");
		try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			
			if (contador() == 0) {
				raf.writeLong(0L);
				raf.writeLong(1L);

				for (int i = 0; i < 8; i++) {
					long tam = raf.length();

					raf.seek(tam - 16);
					long n1 = raf.readLong();

					raf.seek(tam - 8);
					long n2 = raf.readLong();

					raf.seek(tam);
					raf.writeLong(n1 + n2);
				}
			} else {
				for (int i = 0; i < 10; i++) {
					long tam = raf.length();

					raf.seek(tam - 16);
					long n1 = raf.readLong();

					raf.seek(tam - 8);
					long n2 = raf.readLong();

					raf.seek(tam);
					raf.writeLong(n1 + n2);
				}
			}
		} catch (IOException e) {
			System.out.println("La operacion ha dado error" + e.getMessage());
		}
	}

	public static void MostrarConSalto(int salto) {
		File f = new File(System.getProperty("user.home") + File.separator + "AD", "datosFibonacci.dat");
		try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {

			for (long p = 0; p < raf.length(); p += (long) salto * 8) {
				raf.seek(p);
				System.out.println(raf.readLong());
			}
		} catch (IOException e) {
			System.out.println("La operacion ha dado error" + e.getMessage());
		}
	}

	public static long contador() {
		File f = new File(System.getProperty("user.home") + File.separator + "AD", "datosFibonacci.dat");
		if (!f.exists()) {
			return 0;
		}
		return f.length() / 8;
	}
}


