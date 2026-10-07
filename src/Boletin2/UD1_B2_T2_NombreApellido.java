package Boletin2;

import java.io.*;
import java.util.Scanner;

public class UD1_B2_T2_NombreApellido {

	public static void main(String[] args) {
        // TODO Auto-generated method stub

        String ruta = "src" + System.getProperty("file.separator") + "Boletin2" + System.getProperty("file.separator");
        String nombre = "data.dat";

        System.out.println("escritura: ");
        escribir(ruta, nombre);

        System.out.println("lectura: ");
        leer(ruta, nombre);
    }

    public static void leer(String ruta, String nombre) {
        File fil = new File(ruta, nombre);

        if (!fil.exists()) {
            System.out.println("El archivo no existe.");

        }

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(fil));

            while (true) {
                int num = dis.readInt();
                System.out.println("Entero leido: " + num);
            }

        } catch (EOFException ew) {
            System.out.println("Fin del fichero alcanzado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    public static void escribir(String ruta, String nombre) {
        Scanner sc = new Scanner(System.in);
        File fil = new File(ruta, nombre);

        if (!fil.exists()) {
            System.out.println("El archivo no existe.");

        }

        try {
            DataOutputStream dis = new DataOutputStream(new FileOutputStream(fil));
            System.out.println("Introduce un numero: ");
            int num = sc.nextInt();
            dis.writeInt(num);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}