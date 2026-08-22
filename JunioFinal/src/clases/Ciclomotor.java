package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Ciclomotor extends Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	private LocalDate fechaRevision;

	public Ciclomotor(String marca, String matricula, int precioVenta) {
		super(marca, matricula, precioVenta);

	}

	@Override
	public boolean revisado() {
		return Period.between(fechaRevision, LocalDate.now()).getYears() < 2;
	}

	@Override
	public void revisar() {
		fechaRevision = LocalDate.now();

	}

	public LocalDate getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(LocalDate fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	@Override
	public String toString() {
		return "Ciclomotor => " + super.toString() + " fechaRevision=" + fechaRevision;
	}

}
