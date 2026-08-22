package clases;

public class LanzaCohetes extends Pieza implements Disparable {
	private int tirosRestantes;

	public LanzaCohetes(int tirosRestantes) {
		super("Lanza Cohetes", (15 * tirosRestantes));
		this.tirosRestantes = tirosRestantes;
	}

	@Override
	public void disparar(Robot robot) {
		robot.recibeGolpe(30);
		tirosRestantes--;

	}

	@Override
	public boolean cargado() {
		return tirosRestantes > 0;
	}

	@Override
	public int recargar() {
		return -1;
	}

	@Override
	int encender() {
		return tirosRestantes;
	}

	@Override
	public String toString() {
		return super.toString() + " cohetes restantes: " + tirosRestantes;
	}

}
