package boletin4;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class UD1_B4_T2_JavierVerdugo {

	public static void main(String[] args) {

		File f = new File(System.getProperty("user.home") + "/AD", "peliculas.xml");

		ArrayList<Pelicula> lista = cargarPeliculas(f);

		for (Pelicula p : lista) {
			System.out.println(p);
			System.out.println();
		}

	}

	public static ArrayList<Pelicula> cargarPeliculas(File f) {

		ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

		try {

			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

			NodeList lista = document.getElementsByTagName("Pelicula");

			for (int i = 0; i < lista.getLength(); i++) {

				Element peli = (Element) lista.item(i);
				Pelicula p = new Pelicula();

				p.setTitulo(peli.getElementsByTagName("Titulo").item(0).getTextContent());

				if (peli.getElementsByTagName("Duracion").getLength() > 0) {
					p.setDuracion(Integer.parseInt(peli.getElementsByTagName("Duracion").item(0).getTextContent()));
				}

				if (peli.getElementsByTagName("Genero").getLength() > 0) {
					p.setGenero(peli.getElementsByTagName("Genero").item(0).getTextContent());
				}

				if (peli.getElementsByTagName("sinopsis").getLength() > 0) {
					p.setSinopsis(peli.getElementsByTagName("sinopsis").item(0).getTextContent().replace("\n", " "));
				}

				ArrayList<String> actores = new ArrayList<>();
				NodeList listaActores = peli.getElementsByTagName("Actor");
				for (int j = 0; j < listaActores.getLength(); j++) {
					actores.add(listaActores.item(j).getTextContent());
				}
				p.setActores(actores);

				if (peli.getElementsByTagName("Fecha").getLength() > 0) {
					p.setFecha(Integer.parseInt(peli.getElementsByTagName("Fecha").item(0).getTextContent()));
				}

				if (peli.getElementsByTagName("Director").getLength() > 0) {
					p.setDirector(peli.getElementsByTagName("Director").item(0).getTextContent());
				}

				listaPeliculas.add(p);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return listaPeliculas;

	}

}