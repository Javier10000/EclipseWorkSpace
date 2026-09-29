package pruebaprocesos;

import java.io.IOException;

public class ProcesosPrueba {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("open", "-e", "src/prueba/HplaMundo.java");
		try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fsf");
			System.out.println("fsffs");
			System.out.println("todo hereda");
		}
		

	}

}
