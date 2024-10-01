package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Prestamo;

public class CollectionPrestamo {
	public static List<Prestamo> prestamos = new ArrayList<>();
	
	public static void agregarPrestamo (Prestamo prestamo) {
		prestamos.add(prestamo);
	}
}