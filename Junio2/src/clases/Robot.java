package clases;

import java.util.ArrayList;

public class Robot {

	private ArrayList<Pieza> listaPiezas;
	private String nombre;
	private int vida;
	private int evasion;
	private int energiaSobrante;
	private boolean encendido;

	public Robot(String nombre) {

		this.nombre = nombre;
		this.listaPiezas = new ArrayList<Pieza>();
	}

	public void nuevaRueda(int peso) {
		listaPiezas.add(new Rueda(peso));
	}

	public void nuevoGenerador(int peso) {
		listaPiezas.add(new Generador(peso));
	}

	public void nuevoLaser(int tiros) {
		listaPiezas.add(new Laser(tiros));
	}

	public void nuevoTaser() {
		listaPiezas.add(new Taser());
	}

	public void nuevoLanzaCohetes(int tiros) {
		listaPiezas.add(new LanzaCohetes(tiros));
	}

	public void encender() {
		int total = 0;
		int ruedas = 0;
		for (Pieza pieza : listaPiezas) {
			total += pieza.encender();
			vida += pieza.getPeso();
			if (pieza instanceof Rueda) {
				ruedas++;
			}
		}
		if (total >= 0) {
			encendido = true;
			energiaSobrante = total;
			evasion = ruedas - (listaPiezas.size() - ruedas);
			System.out.println("El robot " + nombre + " se ha encendido");
		} else {
			System.out.println("El robot " + nombre + " no se ha encendido");
		}

	}

	public void recibeGolpe(int danno) {
		int golpe = 0;
		if (evasion <= 0) {
			golpe = (int) (1.5 * danno);
		} else {
			golpe = (int) (danno / evasion);
		}
		System.out.println("El robot " + nombre + " recibe " + golpe + " puntos de daño");
		vida -= danno;
	}

	public int disparar(Robot rob) {
		for (Pieza pieza : listaPiezas) {
			if (pieza instanceof Disparable) {
				if (((Disparable) pieza).cargado()) {
					((Disparable) pieza).disparar(rob);
					System.out.println("El robot " + nombre + " dispara " + pieza.getNombre());
				} else if (((Disparable) pieza).recargar() == -1) {
					System.out.println("No se puede recargar " + pieza.getNombre());
				} else {
					System.out.println(nombre + " recarga " + pieza.getNombre());
				}
			}

		}
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public int getEnergiaSobrante() {
		return energiaSobrante;
	}

	public void setEnergiaSobrante(int energiaSobrante) {
		this.energiaSobrante = energiaSobrante;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	@Override
	public String toString() {
		return "Robot " + nombre + " vida: " + vida + " evasion: " + evasion + listaPiezas;
	}

}
