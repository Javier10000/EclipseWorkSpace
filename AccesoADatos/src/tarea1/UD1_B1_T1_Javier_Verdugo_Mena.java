package tarea1;

public class UD1_B1_T1_Javier_Verdugo_Mena {

	public static void main(String[] args) {
		System.out.println("Sistema Operativo");
		System.out.println("el nombre del sistema operativo: "+ System.getProperty("os.name"));
		System.out.println("la version del SO es: "+ System.getProperty("os.version"));
		System.out.println("earquitectura del sistema operativo es: "+System.getProperty("os.arch"));
		System.out.println("---------------------");
		System.out.println("Del Usuario:");
		System.out.println("nombre del usuario: "+ System.getProperty("user.name"));
		System.out.println("Directorio Home: "+System.getProperty("user.home"));
		System.out.println("directorio donde se ejecuta el programa: "+System.getProperty("user.dir"));
		System.out.println("---------------------");
		System.out.println("De Java");
		System.out.println("directorio home:"+System.getProperty("java.home"));
		System.out.println("Version: "+System.getProperty("java.version"));
		System.out.println("Nombre distribuidor: "+System.getProperty("java.vendor"));
		System.out.println("---------------------");
		System.out.println("Del sistema de Archivos:");
		System.out.println("Caracter especial para las rutas: "+System.getProperty("file.separator"));
		System.out.println("Caracter especial para separar las lineas de los ficheros de texto: "+System.getProperty("path.separator"));
		
		//las salidas se diferencian en los datos de java y en el directorio en donde se ejecuta el programa
		
	}

}
