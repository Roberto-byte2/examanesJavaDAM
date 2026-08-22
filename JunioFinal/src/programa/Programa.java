package programa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import clases.Ciclomotor;
import clases.Concesonario;

public class Programa {

	public static void main(String[] args) {
		Concesonario mio = new Concesonario();
		mio.altaCliente("1234566H", "Juan", 22, "2020-02-02");
		mio.altaCliente("3456787R", "Maria", 28, "2018-04-05");
		mio.altaCoche("Seat", "1234ABC", 20000, "2023-02-02");
		mio.altaCoche("Citroën", "6313BCN", 23000, "2020-02-02");
		mio.altaMoto("Honda", "1983GNM", 15000, 250);
		mio.altaCiclomotor("Xiaomi", "C123GTY", 1800, "2022-02-02");
		mio.altaCiclomotor("Silence", "C546NMC", 1100, "2025-02-02");
		mio.mostrarVehiculos();
		mio.mostrarAlquilados();
		mio.mostrarDisponibles();
		mio.alquilarVehiculo("1234ABC", "1234566H", "2026-06-10");
		mio.alquilarVehiculo("6313BCN", "3456787R", "2026-05-10");
		mio.alquilarVehiculo("1983GNM", "1234566H", "2026-06-10");
		mio.mostrarAlquilados();
		mio.devolverVehiculo("1234ABC", "2026-06-10");
		mio.mostrarAlquilados();
		Ciclomotor c = new Ciclomotor("Xiaomi", "C123GTY", 2000);
		File archivo = new File("archivo.txt");
		try (PrintWriter pw = new PrintWriter(archivo)){
				if(!archivo.exists()) archivo.createNewFile();
				pw.print(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try (Scanner ent = new Scanner(archivo)){
			while(ent.hasNextLine()) {
				String lin = ent.nextLine();
				String[] datos = lin.split(":");
				String[] datos2 = datos[1].split(",");
				String marca = datos2[0];
				datos2 = datos[2].split(",");
				String matricula = datos2[0];
				datos2 = datos[3].split(" ");
				String precio = datos2[0];
				System.out.println(marca + " " + matricula + " " + precio);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fichero.bin"))) {
			oos.writeObject(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
