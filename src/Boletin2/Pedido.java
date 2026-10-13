package boletin2;

public class Pedido {
	String descripcion;
	int numUnidades;
	double precio;
	
	public Pedido() {
		
	}

	public Pedido(String descripcion, int numUnidades, double precio) {
		super();
		this.descripcion = descripcion;
		this.numUnidades = numUnidades;
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumUnidades() {
		return numUnidades;
	}

	public void setNumUnidades(int numUnidades) {
		this.numUnidades = numUnidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pedido [descripcion=" + descripcion + ", numUnidades=" + numUnidades + ", precio=" + precio + "]";
	}
	
	

}
