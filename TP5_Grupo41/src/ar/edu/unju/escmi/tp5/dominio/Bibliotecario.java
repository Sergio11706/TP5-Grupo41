package ar.edu.unju.escmi.tp5.dominio;

public class Bibliotecario extends Usuario {
	private int legajo;

    public Bibliotecario(String id, String nombre, String apellido, String email, int legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }
   
    public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	@Override
    public void mostrarDatos() {
		System.out.println("\nID del usuario: "+id);
        System.out.println("Bibliotecario: " + nombre + " " + apellido);
        System.out.println("Legajo: " + legajo);
    }
}
