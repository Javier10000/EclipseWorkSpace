package Boletin2;

import java.io.*;
import java.util.Scanner;

public class UD1_B2_T2_NombreApellido {

    public static void main(String[] args) {
      
        String ruta = "."; 
        String nombreArchivo = "datos.dat";

        System.out.println("=== 1. ESCRITURA EN EL FICHERO ===");
        escribir(ruta, nombreArchivo);

        System.out.println("\n=== 2. LECTURA DEL FICHERO ===");
        leer(ruta, nombreArchivo);
    }

   
    public static void escribir(String ruta, String nombreArchivo) {
        File archivo = new File(ruta, nombreArchivo);
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo));
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Introduce números enteros. (Introduce cualquier letra o pulsa algo que no sea un número para terminar):");
            
            while (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                dos.writeInt(numero); 
            }
            System.out.println("¡Datos guardados correctamente en " + nombreArchivo + "!");
            
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    
    public static void leer(String ruta, String nombreArchivo) {
        File archivo = new File(ruta, nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("El archivo " + nombreArchivo + " todavía no existe.");
            return;
        }

       
        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            
            System.out.println("Leyendo contenido de " + nombreArchivo + ":");
            
           
            while (true) {
                int numeroLeido = dis.readInt(); 
                System.out.println("Número leído: " + numeroLeido);
            }
            
        } catch (EOFException e) {
            
            System.out.println("-> Fin del archivo alcanzado (EOF). Lectura finalizada con éxito.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}