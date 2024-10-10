package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;

public class Prestamo {
	private String id;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private Libro libro;
	private Usuario usuario;
	
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
	
	public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
	
    public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void mostrarDatos() {
        System.out.println("\nID del préstamo: " + id);
        System.out.println("Fecha de préstamo: " + fechaPrestamo.getDayOfMonth() + "/" + fechaPrestamo.getMonthValue() + "/" + fechaPrestamo.getYear());
        System.out.println("Fecha de devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto aun"));
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Usuario: " + usuario.getApellido() + ", " + usuario.getNombre() + ".");
    }
}
