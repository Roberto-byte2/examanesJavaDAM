package clases;

public class Televisor extends Electrodomestico implements Financiable {

	private int pulgadas;
	private int resolucion;

	public Televisor(String numSerie, String marca, double precio, int pulgadas, int resolucion) {
		super(numSerie, marca, precio);
		this.pulgadas = pulgadas;
		this.resolucion = resolucion;
	}

	@Override
	public double calcularIntereses() {
		if (resolucion < 2000) {
			return 0;
		} else if (resolucion > 4000) {
			return 4;
		} else {
			return calcularPotencia() / 300;
		}
	}

	@Override
	public Financiacion financiar(int plazos) {
		return new Financiacion(this, plazos, calcularIntereses());
	}

	@Override
	public double calcularPotencia() {
		return (resolucion / pulgadas) * 10;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	@Override
	public String toString() {
		return "Televisor " + super.toString() + ",pulgadas=" + pulgadas + ", resolucion=" + resolucion + ")";
	}

}
