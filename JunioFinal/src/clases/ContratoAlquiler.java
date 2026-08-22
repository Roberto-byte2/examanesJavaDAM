package clases;

import java.time.LocalDate;

public class ContratoAlquiler {
	private Vehiculo vehiculo;
	private Cliente cliente;
	private LocalDate fechaInicio;
	
	public ContratoAlquiler(Vehiculo vehiculo, Cliente cliente, LocalDate fechaInicio) throws Exception {
		if(cliente.getEdad() < 20 || cliente.antiguedad(fechaInicio) > 2){
			throw new RuntimeException("El cliente debe tener minimo 20 años y 2 años de carnet");
		}
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fechaInicio = fechaInicio;
	}
	

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
	
	
	

}
