package clases;

public class Taser extends Pieza implements Disparable {
	private boolean cargado;

	public Taser() {
		super("Taser", 2);
		this.cargado = true;
	}

	@Override
	public void disparar(Robot robot) {
		robot.recibeGolpe(20);
		cargado = false;

	}

	@Override
	public boolean cargado() {
		return cargado;
	}

	@Override
	public int recargar() {
		cargado = true;
		return 10;
	}

	@Override
	int encender() {
		return 5;
	}

	@Override
	public String toString() {
		String ret = cargado ? " cargado" : "descargado";
		return super.toString() + " " + ret;

	}
}
