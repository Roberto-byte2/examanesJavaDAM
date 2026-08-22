package clases;

public class PeleaRobots {
	private Robot r1;
	private Robot r2;

	public PeleaRobots(Robot r1, Robot r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	public void encenderRobots() {
		r1.encender();
		r2.encender();
	}

	public int haGanado() {
		if ((r1.getVida() <= 0 || !r1.isEncendido()) && (r2.getVida() <= 0 || !r2.isEncendido())) {
			return -1;
		} else if (r2.getVida() <= 0) {
			return 1;
		} else if (r1.getVida() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	public void pelear() {
		System.out.println(r1);
		System.out.println(r2);
		int ronda = 1;
		while (haGanado() == 0) {
			System.out.println("*********** Ronda " + ronda + "************");
			if (r1.isEncendido()) {
				r1.disparar(r2);
			}
			if (r2.isEncendido()) {
				r2.disparar(r1);
			}
			ronda++;
		}
	}

}
