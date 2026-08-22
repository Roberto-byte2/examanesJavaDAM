package clases;

public abstract class Electrodomestico {
	private String numSerie;
	private String marca;
	private double precio;
	
	public Electrodomestico(String numSerie, String marca, double precio) {
		this.numSerie = numSerie;
		this.marca = marca;
		this.precio = precio;
	}
	
	public abstract double calcularPotencia();

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "(numSerie=" + numSerie + ", marca=" + marca + ", precio=" + precio;
	}
	
	
	
	

}
