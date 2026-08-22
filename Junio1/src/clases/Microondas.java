package clases;

public class Microondas extends Electrodomestico {
	private double potencia;

	public Microondas(String numSerie, String marca, double precio, double potencia) {
		super(numSerie, marca, precio);
		this.potencia = potencia;
	}

	@Override
	public double calcularPotencia() {
		// TODO Auto-generated method stub
		return potencia;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Microondas " + super.toString() + ", potencia=" + potencia + ")";
	}

}
