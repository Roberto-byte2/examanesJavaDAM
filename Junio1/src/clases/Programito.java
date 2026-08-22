package clases;

public class Programito {

	public static void main(String[] args) {
		TiendaElectrodomesticos tienda = new TiendaElectrodomesticos();
		tienda.altaLavadora("l1", "Zanussi", 355, 5);
		tienda.altaTelevisor("t2", "LG", 500, 40, 4001);
		tienda.altaMicroondas("m1", "Microwave", 55, 800);
		tienda.altaCliente("1", "Paco", 10000);
		tienda.altaCliente("2", "Pepe", 1000);
		tienda.volcarDatos("fichero");
		System.out.println("==== Stock ====");
		tienda.mostrarElectrodomesticos();
		System.out.println("Cliente 1=====\n" + tienda.buscarCliente("1"));
		System.out.println("Electrodomestico t2======\n" + tienda.buscarElectrodomestico("t2"));
		System.out.println("==== Financiables ====");
		tienda.mostrarFinanciables();
		tienda.financiarElectrodomestico("t2", "1", 10);
		System.out.println("==== Financiables despues ====");
		tienda.mostrarFinanciables();
		tienda.cobrarCuotas();
		System.out.println("Deudas: " + tienda.getDeudas());
		System.out.println("Ingresos: " + tienda.getIngresos());
		tienda.mostrarClientes();
		tienda.venderElectrodomestico("2", "m1");
		tienda.mostrarClientes();
		tienda.mostrarElectrodomesticos();
		tienda.volcarDatos("fichero2");
		for (int i = 1; i < 10; i++) {
			tienda.cobrarCuotas();
		}
		tienda.mostrarClientes();
		tienda.cobrarCuotas();
		tienda.mostrarClientes();
		System.out.println("Deudas: " + tienda.getDeudas());
		System.out.println("Ingresos: " + tienda.getIngresos());

	}

}
