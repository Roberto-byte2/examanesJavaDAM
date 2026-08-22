package programa;

import clases.PeleaRobots;
import clases.Robot;

public class Programa {

	public static void main(String[] args) {
		Robot r1 = new Robot("R2-D2");
		Robot r2 = new Robot("Número 5 H-429");
		Robot r3 = new Robot("C-3PO");
		Robot superviviente = null;
		r1.nuevoGenerador(199);
		r2.nuevoGenerador(200);
		r3.nuevoGenerador(250);
		for (int i = 0; i < 10; i++) {
			r1.nuevaRueda(i + (int) (Math.random() * 40));
			r2.nuevaRueda(i + (int) (Math.random() * 40));
			r3.nuevaRueda(i + (int) (Math.random() * 40));
			armar(r1);
			armar(r2);
			armar(r3);
		}
		PeleaRobots p1 = new PeleaRobots(r1, r2);
		p1.encenderRobots();
		p1.pelear();
		superviviente = gana(r1, r2, p1);
		if (superviviente != null) {
			PeleaRobots p2 = new PeleaRobots(superviviente, r3);
			p2.encenderRobots();
			p2.pelear();
			gana(superviviente, r3, p2);
		} else {
			System.out.println("No hay otra pelea ya que en la primera empataron");
		}
	}

	public static void armar(Robot r1) {
		int aleatorio = (int) (Math.random() * 3) + 1;
		int tiros = (int) (Math.random() * 15) + 3;
		switch (aleatorio) {
		case 1:
			r1.nuevoLanzaCohetes(tiros);
			break;

		case 2:
			r1.nuevoLaser(tiros);
			break;
		case 3:
			r1.nuevoTaser();
		}
	}

	public static Robot gana(Robot r1, Robot r2, PeleaRobots p1) {
		switch (p1.haGanado()) {
		case -1:
			System.out.println("Han empatado");
			return null;
		case 1:
			System.out.println("Ha ganado " + r1.getNombre());
			return r1;

		case 2:
			System.out.println("Ha ganado " + r2.getNombre());
			return r2;
		}
		return null;
	}
}
