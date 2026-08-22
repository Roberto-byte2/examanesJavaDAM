package clases;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Concesonario {
	private ArrayList<Cliente> clientes;
	private ArrayList<Vehiculo> vehiculos;
	private int totalIngresos;

	public Concesonario() {
		clientes = new ArrayList<Cliente>();
		vehiculos = new ArrayList<Vehiculo>();
	}

	public void altaCliente(String dni, String nombre, int edad, String fecha) {
		clientes.add(new Cliente(dni, nombre, edad, LocalDate.parse(fecha)));
	}

	public void altaCoche(String marca, String matricula, int precio, String fecha) {
		Coche c = new Coche(marca, matricula, precio);
		c.setFechaRevision(LocalDate.parse(fecha));
		vehiculos.add(c);
	}

	public void altaMoto(String marca, String matricula, int precio, int cilindrada) {
		vehiculos.add(new Moto(marca, matricula, precio, cilindrada));
	}

	public void altaCiclomotor(String marca, String matricula, int precio, String fecha) {
		Ciclomotor c = new Ciclomotor(marca, matricula, precio);
		c.setFechaRevision(LocalDate.parse(fecha));
		vehiculos.add(c);
	}

	public Vehiculo buscarVehiculo(String matricula) {
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equalsIgnoreCase(matricula)) {
				return v;
			}
		}
		return null;
	}

	public Cliente buscarCliente(String dni) {
		for (Cliente cliente : clientes) {
			if (cliente.getDni().equalsIgnoreCase(dni)) {
				return cliente;
			}

		}
		return null;
	}

	public boolean alquilarVehiculo(String matricula, String dni, String fecha) {
		Cliente c = buscarCliente(dni);
		Vehiculo v = buscarVehiculo(matricula);
		if (c == null || v == null)
			return false;
		if (c.getEdad() < 20 || Period.between(c.getFechaObtencionCarnet(),LocalDate.now()).getYears() < 2) {
			return false;
		}
		if (v instanceof Alquilable && ((Alquilable) v).disponible()) {
			Alquilable vAlquilable = (Alquilable) v; // Cast a la interfaz
			try {
				int costeInicio = vAlquilable.alquilar(c, LocalDate.parse(fecha));
				this.totalIngresos += costeInicio;
				return true;
			} catch (RuntimeException e) {
				System.err.println("Error en alquiler: " + e.getMessage());
				return false; // El cliente no cumplía los requisitos
			}
		}
		System.out.println("S3");
		return false;
	}

	public boolean devolverVehiculo(String matricula, String fecha) {
		Vehiculo v = buscarVehiculo(matricula);
		if (v instanceof Alquilable) {
			Alquilable vAlquilable = (Alquilable) v;

			if (!vAlquilable.disponible()) {
				int costeTiempo = vAlquilable.devolver(LocalDate.parse(fecha));
				this.totalIngresos += costeTiempo;

			}
		}
		return false;

	}

	public void venderVehiculo(String matricula) {
		Vehiculo v = buscarVehiculo(matricula);
		totalIngresos += v.getPrecioVenta();
		vehiculos.remove(v);
	}

	public void mostrarVehiculos() {
		System.out.println("=== Vehiculos ===");
		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}
	}

	public void mostrarDisponibles() {
		System.out.println("=== Disponibles ===");
		for (Vehiculo v : vehiculos) {
			if (v instanceof Alquilable && ((Alquilable) v).disponible()) {
				System.out.println(v);
			}
		}
	}

	public void mostrarAlquilados() {
		System.out.println("=== Alquilados ===");
		for (Vehiculo v : vehiculos) {
			if (v instanceof Alquilable && !((Alquilable) v).disponible()) {
				System.out.println(v);
			}
		}
	}

	public int getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(int totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

}
