package ar.edu.unju.escmi.tp5.main;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.escmi.tp5.collections.CollectionLibro;
import ar.edu.unju.escmi.tp5.dominio.*;
import ar.edu.unju.escmi.tp5.collections.CollectionUsuario;


public class Main {
    public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);
	        int opc;
	        
	        do {
	        
	            System.out.println("******** MENU ******** ");
	            System.out.println("1. Registrar libro");
	            System.out.println("2. Registrar usuario");
	            System.out.println("3. Prestamo de libro");
	            System.out.println("4. Devolucion de libro");
	            System.out.println("5. Listar libros");
	            System.out.println("6. Salir");
	            System.out.print("Seleccione una opción: ");
	            
	            opc = scanner.nextInt();
	            scanner.nextLine();  

	            switch(opc) {
	                case 1:
	                	registrarLibro(scanner);
	                    break;
	                case 2:
	                	registrarUsuario(scanner);
	                break;	
	                case 6:
	                    System.out.println("SALIENDO DEL MENU");
	                    break;
	                default:
	                    System.out.println("OPCION INVALIDA. Intentelo nuevamente");
	            }
	        } while(opc != 6);

	        scanner.close();
	     
	    }

    public static void registrarLibro(Scanner scanner) {
        System.out.print("Ingrese el ID del libro: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(id, titulo, autor, isbn);
        CollectionLibro.agregarLibro(libro);
    }
    
    public static void registrarUsuario(Scanner scanner) throws InputMismatchException
    {
    	try {
            System.out.println("Registrar usuario:");
            System.out.println("1. Alumno");
            System.out.println("2. Bibliotecario");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                System.out.print("Ingrese el nombre del alumno: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el apellido del alumno: ");
                String apellido = scanner.nextLine();
                System.out.print("Ingrese el email del alumno: ");
                String email = scanner.nextLine();
                System.out.print("Ingrese el curso del alumno: ");
                int curso = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Ingrese el número de libreta del alumno: ");
                int numeroLibreta = scanner.nextInt();
                scanner.nextLine(); 
                

                Alumno alumno = new Alumno(1, nombre, apellido, email, curso, numeroLibreta);
                CollectionUsuario.agregarUsuario(alumno);
            } else if (opcion == 2) {
                System.out.print("Ingrese el nombre del bibliotecario: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el apellido del bibliotecario: ");
                String apellido = scanner.nextLine();
                System.out.print("Ingrese el email del bibliotecario: ");
                String email = scanner.nextLine();
                System.out.print("Ingrese el legajo del bibliotecario: ");
                int legajo = scanner.nextInt();
                scanner.nextLine(); 
                
                Bibliotecario bibliotecario = new Bibliotecario(1, nombre, apellido, email, legajo);
                CollectionUsuario.agregarUsuario(bibliotecario);
            }

            System.out.println("Usuarios registrados:");
            CollectionUsuario.mostrarUsuarios();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
  

   
