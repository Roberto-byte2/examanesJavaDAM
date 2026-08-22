package clases;

import java.time.LocalDate;

public interface Alquilable {
	boolean disponible();
	int alquilar(Cliente cliente, LocalDate fecha);
	int devolver(LocalDate fecha);

}
