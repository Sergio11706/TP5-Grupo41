package ar.edu.unju.escmi.tp5.exceptions;

public class LibroNoDisponibleException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LibroNoDisponibleException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase Exception con el mensaje
    }
}
