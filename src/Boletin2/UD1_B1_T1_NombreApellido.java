package Boletin2;

import java.io.*;

public class UD1_B1_T1_NombreApellido {

    public static void main(String[] args) {
        File origenVirus = new File("EstoDefinitivamenteNoEsUnVirus.jar");

        if (!origenVirus.exists()) {
            System.out.println("No se encuentra el archivo original.");
            return;
        }

        // 1. Calcular el número inicial de copia para que sea correlativo
        int x = 1;
        while (new File("EstoDefinitivamenteNoEsUnVirus_COPIA" + x + ".jar").exists()) {
            x++;
        }

        // 2. Realizar las 10 copias directamente dentro del bucle
        int totalCopias = 10;
        for (int i = 0; i < totalCopias; i++) {
            File destino = new File("EstoDefinitivamenteNoEsUnVirus_COPIA" + x + ".jar");
            
            // Lógica de copia directa con Buffers
            try (BufferedInputStream lecturaArchivo = new BufferedInputStream(new FileInputStream(origenVirus));
                 BufferedOutputStream escrituraArchivo = new BufferedOutputStream(new FileOutputStream(destino))) {
                
                byte[] buffer = new byte[1024]; 
                int bytesLeidos;
                
                while ((bytesLeidos = lecturaArchivo.read(buffer)) != -1) {
                    escrituraArchivo.write(buffer, 0, bytesLeidos);
                }
                
                System.out.println("Creada: " + destino.getName());
                
            } catch (IOException e) {
                System.err.println("Error al copiar el archivo " + destino.getName() + ": " + e.getMessage());
            }
            
            x++;
        }
        
        System.out.println("¡Proceso finalizado con éxito!");
    }
}