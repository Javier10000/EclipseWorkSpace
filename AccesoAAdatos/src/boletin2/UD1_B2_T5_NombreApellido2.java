package boletin2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UD1_B2_T5_NombreApellido2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("src" + System.getProperty("file.separator") + "boletin2" + System.getProperty("file.separator")
				+ "pedidos.dat");

		Pedido p1 = new Pedido("Coche", 1, 19.999);
		Pedido p2 = new Pedido("pepinillo", 3, 2.99);
		Pedido p3 = new Pedido("raton", 1, 50.98);

		Pedido p4 = new Pedido("teclado", 2, 2.33);
		Pedido p5 = new Pedido("lampara", 2, 2.1);

		Pedido[] pedidos = { p1, p2, p3 };
		Pedido[] pedidos2 = { p4, p5 };

		escribirPedidos(pedidos, f);
		leerPedidos(f);
		System.out.println("--------------------");
		annadePedidos(pedidos2, f);
		leerPedidos(f);
	}

	public static void escribirPedidos(Pedido[] pedido, File f) {

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));

			for (int i = 0; i < pedido.length; i++) {
				dos.writeUTF(pedido[i].getDescripcion());
				dos.writeInt(pedido[i].getNumUnidades());
				dos.writeDouble(pedido[i].getPrecio());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void leerPedidos(File f) {

		try {
			DataInputStream das = new DataInputStream(new FileInputStream(f));

			while (true) {
				String desc = das.readUTF();
				int unidades = das.readInt();
				double precio = das.readDouble();

				Pedido p = new Pedido(desc, unidades, precio);
				System.out.println(p);
			}
		} catch (EOFException e) {
			System.out.println("Fin de lecura");
		} catch (IOException ie) {
			System.out.println("error: " + ie.getMessage());
		}

	}

	public static void annadePedidos(Pedido[] pedidos, File f) {

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f, true))) {


			for (int i = 0; i < pedidos.length; i++) {
				dos.writeUTF(pedidos[i].getDescripcion());
				dos.writeInt(pedidos[i].getNumUnidades());
				dos.writeDouble(pedidos[i].getPrecio());
			}

		} catch (IOException e) {
			System.out.println("Error al a単adir: " + e.getMessage());
		}

	}
}
