package clases;

public class Financiacion {
	private Electrodomestico financiado;
	private int plazos;
	private int pagados;
	private double interes;

	public Financiacion(Electrodomestico financiado, int plazos, double interes) {
		if (!(financiado instanceof Financiable)) {
			throw new RuntimeException("El electrodomestico no se puede financia");
		}
		this.financiado = financiado;
		this.plazos = plazos;
		this.interes = interes;
	}

	public double total() {
		return financiado.getPrecio() * (1 + interes / 100);

	}

	public double cuota() {
		return total() / plazos;
	}

	public void pagar() {
		pagados++;
	}

	public double restante() {
		return (plazos - pagados) * cuota();
	}

	public Electrodomestico getFinanciado() {
		return financiado;
	}

	public void setFinanciado(Electrodomestico financiado) {
		this.financiado = financiado;
	}

	public int getPlazos() {
		return plazos;
	}

	public void setPlazos(int plazos) {
		this.plazos = plazos;
	}

	public int getPagados() {
		return pagados;
	}

	public void setPagados(int pagados) {
		this.pagados = pagados;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	@Override
	public String toString() {
		return financiado.toString() + ", plazos=" + plazos + ", pagados=" + pagados + ", interes=" + interes + "]";
	}

}
