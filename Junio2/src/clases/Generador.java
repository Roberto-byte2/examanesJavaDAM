package clases;

public class Generador extends Pieza {

	private int generado;

	public Generador(int peso) {
		super("Generador", peso);

	}

	public int getGenerado() {
		return generado;
	}

	public void setGenerado(int generado) {
		this.generado = generado;
	}

	@Override
	int encender() {
		return -generado;
	}

}
