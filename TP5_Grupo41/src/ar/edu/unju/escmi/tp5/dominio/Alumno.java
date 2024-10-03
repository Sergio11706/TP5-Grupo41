package ar.edu.unju.escmi.tp5.dominio;


public class Alumno extends Usuario {
	 	private int curso;
	    private int numeroLibreta;

	    public Alumno(String id, String nombre, String apellido, String email, int curso, int numeroLibreta) {
	        super(id, nombre, apellido, email);
	        this.curso = curso;
	        this.numeroLibreta = numeroLibreta;
	    }
	    
	    
	    public int getCurso() {
			return curso;
		}

		public void setCurso(int curso) {
			this.curso = curso;
		}

		public int getNumeroLibreta() {
			return numeroLibreta;
		}

		public void setNumeroLibreta(int numeroLibreta) {
			this.numeroLibreta = numeroLibreta;
		}


		@Override
	    public void mostrarDatos() {
			System.out.println("\nID del usuario: "+id);
	        System.out.println("Alumno: " + nombre + " " + apellido);
	        System.out.println("Curso: " + curso);
	        System.out.println("Número de libreta: " + numeroLibreta);
	    }
}
