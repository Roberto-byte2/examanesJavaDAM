package clases;

import java.time.LocalDate;
import java.time.Period;

public class Moto extends Vehiculo implements Alquilable {

	private int vecesAlquilada;
	private ContratoAlquiler contrato;
	private int cilindrada;

	public Moto(String marca, String matricula, int precioVenta, int cilindrada) {
		super(marca, matricula, precioVenta);
		this.cilindrada = cilindrada;
	}

	@Override
	public boolean disponible() {
		return contrato == null;
	}

	@Override
	public int alquilar(Cliente cliente, LocalDate fecha) {
		int precio = cilindrada > 126 ? 80 : 40;
		int dias = Period.between(contrato.getFechaInicio(), fecha).getDays();
		if (contrato == null)
			return 0;
		try {
			contrato = new ContratoAlquiler(this, cliente, fecha);
			vecesAlquilada++;
			if (vecesAlquilada == 4) {
				revisar();
			}
			return dias * 25 + precio;
		} catch (Exception runTimeException) {
			System.out.println("No se puede realizar contrato");
			return 0;

		}
	}

	@Override
	public int devolver(LocalDate fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean revisado() {
		return vecesAlquilada < 4;
	}

	@Override
	public void revisar() {
		vecesAlquilada = 0;

	}

	public int getVecesAlquilada() {
		return vecesAlquilada;
	}

	public void setVecesAlquilada(int vecesAlquilada) {
		this.vecesAlquilada = vecesAlquilada;
	}

	public ContratoAlquiler getContrato() {
		return contrato;
	}

	public void setContrato(ContratoAlquiler contrato) {
		this.contrato = contrato;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Moto => " + super.toString() + " cilindrada: " + cilindrada + " veces alquilada " + vecesAlquilada
				+ " contrato: " + contrato;
	}

}
