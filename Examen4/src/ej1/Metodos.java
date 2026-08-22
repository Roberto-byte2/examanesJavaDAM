package ej1;

import java.util.Scanner;

public class Metodos {
	public static void registrarDestinos(String[] destinos, Scanner entrada) {
		for (int i = 0; i < destinos.length; i++) {
			System.out.print("Introduce el destino " + (i + 1) + ": ");
			destinos[i] = entrada.nextLine();
		}

	}

	public static void registrarDistancias(double[] distancias, String[] destinos, Scanner entrada) {
		for (int i = 0; i < destinos.length; i++) {
			System.out.print("Introduce la distancia a " + destinos[i] + ": ");
			distancias[i] = entrada.nextDouble();
		}

	}

	public static void registrarMediosTransporte(String[] mediosTransporte, Scanner entrada) {
		for (int i = 0; i < mediosTransporte.length; i++) {
			System.out.print("Introduce el medio de transporte " + (i + 1) + ": ");
			mediosTransporte[i] = entrada.nextLine();
		}
	}

	public static void registrarMatrizPrecios(double[][] matrizPrecios, String[] destinos, String[] mediosTransporte,
			Scanner entrada) {
		for (int i = 0; i < destinos.length; i++) {
			for (int j = 0; j < mediosTransporte.length; j++) {
				System.out.print("Introduce el precio a " + destinos[i] + " en " + mediosTransporte[j] + ": ");
				matrizPrecios[i][j] = entrada.nextDouble();
			}
		}
	}

	public static void mostrarInformacionGeneral(String[] destinos, double[] distancia, String[] mediosTransporte) {
		System.out.println("Destinos disponibles:");
		for (int i = 0; i < destinos.length; i++) {
				System.out.println("- Destino: " + destinos[i] + ", Distancia: " + distancia[i] + "km");
			}
		
		System.out.println("Medios de transportes disponibles:");
		for (int i = 0; i < mediosTransporte.length; i++) {
			System.out.println("- " + mediosTransporte[i]);
		}
	}

	public static void mostrarMatrizPrecios(String[] destinos, double[] distancia, String[] mediosTransporte,
			double[][] precios) {
		System.out.print("Destino||  ");
		for (int i = 0; i < mediosTransporte.length; i++) {
			System.out.print(mediosTransporte[i] + "|  ");
		}
		for (int i = 0; i < destinos.length; i++) {
			System.out.println();
			System.out.print(destinos[i] + "||  ");
			for (int j = 0; j < mediosTransporte.length; j++) {
				System.out.print(precios[i][j] + "|  ");
			}
		}
		System.out.println();

	}

	public static void mostrarDestinoMasLejano(String[] destinos, double[] distancia) {

		int opc = 0;
		double distan = Integer.MIN_VALUE;
		for (int i = 0; i < distancia.length; i++) {
			if (distan < distancia[i]) {
				opc = i;
				distan = distancia[i];
			}
		}
		System.out.println("El destion mas lejano es " + destinos[opc] + " que esta a " + distancia[opc] + " Km.");

	}

	public static void calcularPrecioPromedio(double[][] precios, String[] mediosTransporte) {
		for (int i = 0; i < mediosTransporte.length; i++) {
			double suma = 0;
			for (int j = 0; j < precios.length; j++) {
				suma += precios[j][i];
			}
			System.out.println("El precio medio en " + mediosTransporte[i] + " es " + (suma / precios.length) + " euros.");
		}
	}

	public static void calcularPrecioPorKM(double[][] precios, String[] destinos, double[] distancia,
			String[] mediosTransporte) {
		for (int i = 0; i < destinos.length; i++) {
			for (int j = 0; j < mediosTransporte.length; j++) {
				System.out.println("El precio por km a " + destinos[i] + " en " + mediosTransporte[j] + " es "+ (precios[i][j]/distancia[i]) 
						+ " euros." );
			}
		}
		
		
	}

	
	
	

}
