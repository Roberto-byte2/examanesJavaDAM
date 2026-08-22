package clases;

public class Rueda extends Pieza {

	public Rueda(int peso) {
		super("Rueda", peso);
	}

	@Override
	int encender() {
		return getPeso() / 3;
	}

}
