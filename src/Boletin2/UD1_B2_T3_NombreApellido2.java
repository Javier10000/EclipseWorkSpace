package boletin2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class UD1_B2_T3_NombreApellido2 {

    public static void main(String[] args) {
        String ruta = "src"+System.getProperty("file.separator")+"boletin2"+System.getProperty("file.separator"); 
        String nombreArchivo = "datosMatriz.dat";

      
        double[][] matrizOriginal = pedirDatosMatriz();

       
        escribirMatriz(ruta, nombreArchivo, matrizOriginal);

       
        double[][] matrizLeida = leerMatriz(ruta, nombreArchivo);

        
        System.out.println("\nContenido leído desde el archivo:");
        mostrarMatriz(matrizLeida);
    }

    
    public static double[][] pedirDatosMatriz() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int columnas = sc.nextInt();
        
        double[][] matriz = new double[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Introduce el número en la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }
        return matriz; 
    }

  
    public static void escribirMatriz(String ruta, String nombreArchivo, double[][] matriz) {
        File archivo = new File(ruta, nombreArchivo);
        
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
            int filas = matriz.length;
            int columnas = matriz[0].length;
            
            
            dos.writeInt(filas);
            dos.writeInt(columnas);
            
            
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    dos.writeDouble(matriz[i][j]);
                }
            }
            System.out.println("Archivo guardado correctamente en: " + archivo.getAbsolutePath());
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }
    }

    
    public static double[][] leerMatriz(String ruta, String nombreArchivo) {
        File archivo = new File(ruta, nombreArchivo);
        double[][] matriz = null;
        
       
        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
           
            int filas = dis.readInt();
            int columnas = dis.readInt();
            
          
            matriz = new double[filas][columnas];
            
           
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = dis.readDouble();
                }
            }
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
        return matriz; 
    }

   
    public static void mostrarMatriz(double[][] matriz) {
        if (matriz != null) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println(); 
            }
        }
    }
}