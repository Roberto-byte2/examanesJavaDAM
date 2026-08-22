package clases;

public class Lavadora extends Electrodomestico implements Financiable {
	private int carga;

	public Lavadora(String numSerie, String marca, double precio, int carga) {
		super(numSerie, marca, precio);
		this.carga = carga;

	}

	@Override
	public double calcularIntereses() {
		if (this.getMarca().equalsIgnoreCase("Balay")) {
			return 0;
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
		return carga * 75;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	@Override
	public String toString() {
		return "Lavadora " + super.toString() + ",carga=" + carga + ")";
	}

}
