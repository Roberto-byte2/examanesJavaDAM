package ej1;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("¿Cuántos destinos vas a introducir?: ");
		int num = entrada.nextInt();
		entrada.nextLine();
		String[] destinos = new String[num];
		double[] distancia = new double[num];
		Metodos.registrarDestinos(destinos, entrada);
		Metodos.registrarDistancias(distancia, destinos, entrada);
		System.out.print("¿Cuántos medios de tranporte vas a introducir?: ");
		num = entrada.nextInt();
		entrada.nextLine();
		String[] mediosTransporte = new String[num];
		Metodos.registrarMediosTransporte(mediosTransporte, entrada);
		double[][] precios = new double[destinos.length][mediosTransporte.length];
		Metodos.registrarMatrizPrecios(precios, destinos, mediosTransporte, entrada);
		int opcion = 0;
		do {
			System.out.println("____________________________________________\n" + "Menú:\n" + "1. Información general\n"
					+ "2. Ver precios\n" + "3. Destino más lejano\n" + "4. Precio promedio\n"
					+ "5. Precio por kilómetro\n" + "6. Generar reserva\n" + "7. Salir\n"
					+ "____________________________________________");
			System.out.print("\n Seleccione una opcion: ");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Opcion 1");
				Metodos.mostrarInformacionGeneral(destinos, distancia, mediosTransporte);
				break;
			case 2:
				System.out.println("Opcion 2");
				Metodos.mostrarMatrizPrecios(destinos, distancia, mediosTransporte, precios);
				break;
			case 3:
				System.out.println("Opcion 3");
				Metodos.mostrarDestinoMasLejano(destinos, distancia);
				break;
			case 4:
				System.out.println("Opcion 4");
				Metodos.calcularPrecioPromedio(precios, mediosTransporte);
				break;
			case 5:
				System.out.println("Opcion 5");
				Metodos.calcularPrecioPorKM(precios, destinos, distancia, mediosTransporte);
				break;
			case 6:
				System.out.println("Opcion 6");
				boolean sal = false;
				int personas = 0;
				int vertical = 0;
				int horizontal = 0;
				do {
					System.out.print("¿Cuántas personas? ");
					personas = entrada.nextInt();
					entrada.nextLine();
					System.out.print("¿Qué destino? ");
					String ciudad = entrada.nextLine().trim();
					System.out.print("Medio de transporte: ");
					String transporte = entrada.nextLine();
					for (int i = 0; i < destinos.length; i++) {
						if (ciudad.equalsIgnoreCase(destinos[i])) {
							vertical = i;
							for (int j = 0; j < mediosTransporte.length; j++) {
								if (transporte.equalsIgnoreCase(mediosTransporte[j])) {
									sal = true;
									horizontal = j;
									break;
								}
							}
						}
					}
				} while (sal != true);
				System.out.println("Un viaje a " + destinos[vertical] + " en " + mediosTransporte[horizontal] + " para "
						+ personas + " cuesta " + (personas * precios[horizontal][vertical]) + " euros.");
				break;
			case 7:
				System.out.println("Salir!!!");
				break;

			default:
				System.out.println("Introduce una opcion entre 1 y 7!");
				break;
			}
		} while (opcion != 7);

		entrada.close();
	}

}