public class UD1_B3_T1_JavierVerdugo {

	public static void main(String[] args) {
		File f = new File(System.getProperty("user.home") + File.separator + "AD" + File.separator + "refranes.txt");
		leerFileReader(f);
		leerBufferedReader(f);
	}

	public static void leerFileReader(File f) {
		System.out.println("lectura con fileReader");
		FileReader fr = null;
		try {
			fr = new FileReader(f);
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			System.out.println("Fin FileReader");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void leerBufferedReader(File f) {
		System.out.println();
		System.out.println("lectura con BufferedReader");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			System.out.println("Fin BufferedReader");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	


}
