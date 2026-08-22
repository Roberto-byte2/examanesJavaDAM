package clases;

public class Cliente {
	private String dni;
	private String nombre;
	private Financiacion financiacion;
	private double fondosDisponibles;

	public Cliente(String dni, String nombre, double fondosDisponibles) {
		this.dni = dni;
		this.nombre = nombre;
		this.fondosDisponibles = fondosDisponibles;
	}

	public boolean pagar(double precio) {
		if (precio <= fondosDisponibles) {
			fondosDisponibles -= precio;
			return true;
		} else {
			return false;
		}

	}

	public boolean pagarCuota() {
		if (financiacion == null) {
			return false;
		}
		 else if (pagar(financiacion.cuota())) {
			financiacion.pagar();
			if (financiacion.getPlazos() == financiacion.getPagados()) {
				financiacion = null;
			}
			return true;
		} else {
			return false;
		}

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Financiacion getFinanciacion() {
		return financiacion;
	}

	public void setFinanciacion(Financiacion financiacion) {
		this.financiacion = financiacion;
	}

	public double getFondosDisponibles() {
		return fondosDisponibles;
	}

	public void setFondosDisponibles(double fondosDisponibles) {
		this.fondosDisponibles = fondosDisponibles;
	}

	@Override
	public String toString() {
		return "Cliente dni=" + dni + ", nombre=" + nombre + ", financiacion=" + financiacion + ", fondosDisponibles="
				+ fondosDisponibles;
	}

}
