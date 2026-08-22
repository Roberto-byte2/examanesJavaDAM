package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class TiendaElectrodomesticos {

	private ArrayList<Cliente> clientes;
	private ArrayList<Electrodomestico> electrodomesticos;
	private double ingresos;
	private double deudas;

	public TiendaElectrodomesticos() {
		this.clientes = new ArrayList<Cliente>();
		this.electrodomesticos = new ArrayList<Electrodomestico>();
	}

	public void altaCliente(String dni, String nombre, double fondosDisponibles) {
		Cliente c = new Cliente(dni, nombre, fondosDisponibles);
		clientes.add(c);
	}

	public void altaLavadora(String numSerie, String marca, double precio, int carga) {
		Lavadora l = new Lavadora(numSerie, marca, precio, carga);
		electrodomesticos.add(l);
	}

	public void altaTelevisor(String numSerie, String marca, double precio, int pulgadas, int resolucion) {
		Televisor t = new Televisor(numSerie, marca, precio, pulgadas, resolucion);
		electrodomesticos.add(t);
	}

	public void altaMicroondas(String numSerie, String marca, double precio, int potencia) {
		Microondas m = new Microondas(numSerie, marca, precio, potencia);
		electrodomesticos.add(m);
	}

	public Electrodomestico buscarElectrodomestico(String numSerie) {
		for (Electrodomestico e : electrodomesticos) {
			if (e.getNumSerie().equalsIgnoreCase(numSerie)) {
				return e;
			}
		}
		return null;
	}

	public Cliente buscarCliente(String dni) {
		for (Cliente c : clientes) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				return c;
			}
		}
		return null;
	}

	public void eliminarElectrodomestico(String numSerie) {
		Electrodomestico e = buscarElectrodomestico(numSerie);
		electrodomesticos.remove(e);
	}

	public void venderElectrodomestico(String dni, String numSerie) {
		Cliente c = buscarCliente(dni);
		Electrodomestico e = buscarElectrodomestico(numSerie);

		if (c != null && e != null && c.getFondosDisponibles() >= e.getPrecio()) {
			c.setFondosDisponibles(c.getFondosDisponibles() - e.getPrecio());
			electrodomesticos.remove(e);
		}
	}

	public void financiarElectrodomestico(String numSerie, String dni, int plazos) {
		Cliente c = buscarCliente(dni);
		Electrodomestico e = buscarElectrodomestico(numSerie);
		if (c != null && e != null && c.getFinanciacion() == null) {
			if (e instanceof Financiable) {
				Financiacion f = ((Financiable) e).financiar(plazos);
				this.deudas += f.total();
				eliminarElectrodomestico(numSerie);
				c.setFinanciacion(f);
			}
		}
	}

	public void cobrarCuotas() {
		for (Cliente c : clientes) {

			if (c.getFinanciacion() != null) {
				double cuota = c.getFinanciacion().cuota();
				if (c.pagarCuota()) {
					deudas -= cuota;
					ingresos += cuota;
				} else {
					Electrodomestico e = c.getFinanciacion().getFinanciado();
					deudas -= c.getFinanciacion().restante();
					electrodomesticos.add(e);
					c.setFinanciacion(null);
				}
			}

		}
	}

	public void mostrarElectrodomesticos() {
		for (Electrodomestico electrodomestico : electrodomesticos) {
			System.out.println(electrodomestico);
		}
	}

	public void mostrarClientes() {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	public void mostrarFinanciables() {
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico instanceof Financiable) {
				System.out.println(electrodomestico);
			}
		}
	}

	public void volcarDatos(String ruta) {
		// PrintWriter pw = null;
		try (PrintWriter pw = new PrintWriter(new FileWriter(new File(ruta), true))) {
			pw.println("======= " + LocalDate.now() + " =======");
			pw.println("=== ELECTRODOMÉSTICOS ===");
			for (Electrodomestico electrodomestico : electrodomesticos) {
				pw.println(" - " + electrodomestico);
			}
			pw.println("=== CLIENTES ===");
			for (Cliente cliente : clientes) {
				pw.println(" - " + cliente);
			}
			pw.println(":: Ingresos: " + ingresos);
			pw.println(":: Deudas: " + deudas);

		} catch (IOException e) {
			System.err.println("Error al escribir el archivo " + e.getMessage());
		}
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public double getDeudas() {
		return deudas;
	}

	public void setDeudas(double deudas) {
		this.deudas = deudas;
	}

}
