package clases;

import java.time.LocalDate;
import java.time.Period;

public class Coche extends Vehiculo implements Alquilable {
	private ContratoAlquiler contrato;
	private LocalDate fechaRevision;

	public Coche(String marca, String matricula, int precioVenta) {
		super(marca, matricula, precioVenta);
	}

	@Override
	public boolean disponible() {
		return contrato == null;
	}

	@Override
	public int alquilar(Cliente cliente, LocalDate fecha) {
		try {
			contrato = new ContratoAlquiler(this, cliente, fecha);
		} catch (Exception runTimeException) {
			System.out.println("No se puede realizar contrato");
			;
		}
		return 40;
	}

	@Override
	public int devolver(LocalDate fecha) {
		int dias = (int) Period.between(contrato.getFechaInicio(), fecha).getDays();
		contrato = null;
		return dias * 20;
	}

	@Override
	public boolean revisado() {

		return Period.between(fechaRevision, LocalDate.now()).getYears() < 4;
	}

	@Override
	public void revisar() {
		fechaRevision = LocalDate.now();

	}

	public ContratoAlquiler getContrato() {
		return contrato;
	}

	public void setContrato(ContratoAlquiler contrato) {
		this.contrato = contrato;
	}

	public LocalDate getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(LocalDate fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	@Override
	public String toString() {
		return "Coche => " + super.toString() + ", fecha revision: " + fechaRevision + ", tiene contrato: " + contrato;
	}
}
