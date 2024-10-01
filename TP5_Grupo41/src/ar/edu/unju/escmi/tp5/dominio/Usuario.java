package ar.edu.unju.escmi.tp5.dominio;

public abstract class Usuario {
	protected int id;
	protected String nombre;
	protected String apellido;
	protected String email;
	
	public Usuario(int id, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public void mostrarDatos()
	{
		System.out.println("Id del Usuario: "+id);
		System.out.println("Nombre del Usuario: "+ nombre);
		System.out.println("Apellido del Usuario: "+ apellido);
		System.out.println("Email del Usuario: "+ email);
	}
	
}


