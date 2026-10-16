package boletin4;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

public class UD1_B4_T1_JavierVerdugo {

	public static void main(String[] args) {

		try {
			
			
			File f = new File(System.getProperty("user.home") + "/AD", "peliculas.xml");

			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

			NodeList lista = document.getElementsByTagName("Pelicula");

			for (int i = 0; i < lista.getLength(); i++) {

				Element peli = (Element) lista.item(i);
				System.out.println();

				System.out.println("        PELICULA " + i + "      ");

				System.out.print("Título: " + peli.getElementsByTagName("Titulo").item(0).getTextContent());
				System.out.println();

				System.out.print("Fecha: " + peli.getElementsByTagName("Fecha").item(0).getTextContent());
				System.out.println();

				System.out.print("Director: " + peli.getElementsByTagName("Director").item(0).getTextContent());
				System.out.println();
				
				System.out.print("actores: " + peli.getElementsByTagName("Actores").item(0).getTextContent());

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}