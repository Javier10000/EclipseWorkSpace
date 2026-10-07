package boletin2;

import java.io.*;

public class UD1_B2_T1_NombreApellido {

    public static void main(String[] args) {
        File origenVirus = new File("EstoDefinitivamenteNoEsUnVirus.jar");

        if (!origenVirus.exists()) {
            System.out.println("No se encuentra el archivo original.");
            return;
        }

       
        int x = 1;
        while (new File("EstoDefinitivamenteNoEsUnVirus_COPIA" + x + ".jar").exists()) {
            x++;
        }

       
        int totalCopias = 10;
        for (int i = 0; i < totalCopias; i++) {
            File destino = new File("EstoDefinitivamenteNoEsUnVirus_COPIA" + x + ".jar");
            
           
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