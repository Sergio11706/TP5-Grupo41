package ar.edu.unju.escmi.tp5.main;
import java.util.Scanner;
import ar.edu.unju.escmi.tp5.collections.CollectionLibro;
import ar.edu.unju.escmi.tp5.dominio.*;

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
	                case 6:
	                    System.out.println("SALIENDO DEL MENU");
	                    break;
	                default:
	                    System.out.println("OPCION INVALIDA. Intentelo nuevamente");
	            }
	        } while(opc != 9);

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
}
  

   
