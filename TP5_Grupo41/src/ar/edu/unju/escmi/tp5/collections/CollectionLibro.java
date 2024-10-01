package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Libro;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    public static void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("LIBRO AGREGADO CON EXITO");
    }

    public static void mostrarLibros() {
        for (Libro libro : libros) {
            libro.mostrarDatos();
            System.out.println("-------------------");
        }
    }
    
    public static Libro buscarLibroPorCodigo(String codigo) {
    	for(Libro libro : libros) {
    		if(libro.getId().equals(codigo)) return libro;
    	}
    	return null;
    }
}
