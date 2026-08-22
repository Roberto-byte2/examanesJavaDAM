package clases;

public class Laser extends Pieza implements Disparable {

	private int tirosTotales;
	private int tirosRestantes;

	public Laser(int tirosTotales) {
		super("Laser", (tirosTotales * 2));
		this.tirosTotales = tirosTotales;
	}

	@Override
	public void disparar(Robot robot) {
		robot.recibeGolpe(12);
		tirosRestantes--;

	}

	@Override
	public boolean cargado() {
		return tirosRestantes > 0;
	}

	@Override
	public int recargar() {
		tirosRestantes = tirosTotales;
		return tirosTotales * 2;
	}

	@Override
	int encender() {
		return tirosTotales * 2;
	}

	public int getTirosTotales() {
		return tirosTotales;
	}

	public void setTirosTotales(int tirosTotales) {
		this.tirosTotales = tirosTotales;
	}

	public int getTirosRestantes() {
		return tirosRestantes;
	}

	public void setTirosRestantes(int tirosRestantes) {
		this.tirosRestantes = tirosRestantes;
	}

	@Override
	public String toString() {
		return super.toString() + " tiros restantes " + tirosRestantes + "/" + tirosTotales;
	}
	

}
