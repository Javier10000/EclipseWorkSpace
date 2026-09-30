package pruebaprocesos;

import java.io.IOException;

public class ProcesosPrueba {

	public static void main(String[] args) throws IOException  {
		
		 
		 
		/**
		 *Para Mac
		 *  ProcessBuilder pb = new ProcessBuilder("open", "-e", "src/prueba/HplaMundo.java");
		 *  pb.start();
		 */
		 
		 
		 
		
		
		  ProcessBuilder pb = new ProcessBuilder("open", "-e", "src/prueba/HplaMundo.java");
		  
		  ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", "bin", "pruebaprocesos.Hola");
			
			pb1.inheritIO();
			Process proceso = pb1.start();
		 
		 
			
			
			
		

	}

}
