package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;

public class Prestamo {
	protected String id;
	protected LocalDate fechaPrestamo;
	protected LocalDate fechaDevolucion;
	protected Libro libro;
	protected Usuario usuario;
	
    public Prestamo(String id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, Usuario usuario) {
		super();
		this.id = id;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = null;
		this.libro = libro;
		this.usuario = usuario;
	}

	public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.libro.setEstado(true);
    }
    
	public String getId() {
	    return id;
	}
	
    public void mostrarDatos() {
        System.out.println("ID del préstamo: " + id);
        System.out.println("Fecha de préstamo: " + fechaPrestamo);
        System.out.println("Fecha de devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto aun"));
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Usuario: " + usuario.getApellido() + ", " + usuario.getNombre() + ".");
    }
}
