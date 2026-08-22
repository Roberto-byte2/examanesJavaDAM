package clases;

import java.io.Serializable;

public abstract class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String marca;
	private String matricula;
	private int precioVenta;

	public Vehiculo(String marca, String matricula, int precioVenta) {
		this.marca = marca;
		this.matricula = matricula;
		this.precioVenta = precioVenta;
	}

	public abstract boolean revisado();

	public abstract void revisar();

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "marca:" + marca + ", matricula:" + matricula + ", precioVenta:" + precioVenta;
	}

}
