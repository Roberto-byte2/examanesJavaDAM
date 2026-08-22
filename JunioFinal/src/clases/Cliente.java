package clases;

import java.time.LocalDate;

public class Cliente {

	private String dni;
	private String nombre;
	private int edad;
	private LocalDate fechaObtencionCarnet;

	public Cliente(String dni, String nombre, int edad, LocalDate fechaObtencionCarnet) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaObtencionCarnet = fechaObtencionCarnet;
	}
	
	int antiguedad(LocalDate fecha) {
		return LocalDate.now().until(fecha).getYears();
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaObtencionCarnet() {
		return fechaObtencionCarnet;
	}

	public void setFechaObtencionCarnet(LocalDate fechaObtencionCarnet) {
		this.fechaObtencionCarnet = fechaObtencionCarnet;
	}

	@Override
	public String toString() {
		return "dni:" + dni + ", nombre:" + nombre + ", edad:" + edad + ", fecha Obtencion Carnet;"
				+ fechaObtencionCarnet;
	}

}
