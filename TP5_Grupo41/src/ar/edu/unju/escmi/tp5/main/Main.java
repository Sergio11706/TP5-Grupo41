package ar.edu.unju.escmi.tp5.main;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionLibro;
import ar.edu.unju.escmi.tp5.collections.CollectionPrestamo;
import ar.edu.unju.escmi.tp5.dominio.*;
import ar.edu.unju.escmi.tp5.collections.CollectionUsuario;
import ar.edu.unju.escmi.tp5.exceptions.*;
import ar.edu.unju.escmi.tp5.utils.FechaUtil;


public class Main {
    public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);
	        String opc;
	        
	        do {
	        
	            System.out.println("******** MENU ******** ");
	            System.out.println("1. Registrar libro");
	            System.out.println("2. Registrar usuario");
	            System.out.println("3. Prestamo de libro");
	            System.out.println("4. Devolucion de libro");
	            System.out.println("5. Listar libros");
	            System.out.println("6. Salir");
	            System.out.print("Seleccione una opción: ");
	            
	            opc = scanner.nextLine();  

	            switch(opc) {
	                case "1":
	                	registrarLibro(scanner);
	                    break;
	                case "2":
	                	registrarUsuario(scanner);
	                	break;	
	                case "3":
	                	registrarPrestamo(scanner);
	                	break;
	                case "4":
	                    registrarDevolucion(scanner);
	                    break;
	                case "5":
	                	List<Libro> libros = CollectionLibro.libros;
	                    if(libros.isEmpty()) System.out.println("\nLista de libros vacia");
	                    else CollectionLibro.mostrarLibros();
	                    break;
	                case "6":
	                    System.out.println("\nSALIENDO DEL MENU");
	                    break;
	                default:
	                    System.out.println("\nOPCION INVALIDA. Intentelo nuevamente");
	            }
	        } while(!opc.equals("6"));

	        scanner.close();
	     
	    }

    public static void registrarLibro(Scanner scanner) {
       
    	System.out.print("\nIngrese el ID del libro: ");
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
    
    public static void registrarUsuario(Scanner scanner) throws InputMismatchException {
    	
    	boolean band = true;
    	while(band) {
    		
    		band=false;
	    	try {
	            System.out.println("\nRegistrar usuario:");
	            System.out.println("1. Alumno");
	            System.out.println("2. Bibliotecario");
	            System.out.print("Seleccione una opción: ");
	            String opcion = scanner.nextLine();
	
	            switch(opcion) {
	            case "1":
	            	System.out.print("\nIngrese el ID del usuario: ");
	                String id1 = scanner.nextLine();
	                
	                System.out.print("Ingrese el nombre del alumno: ");
	                String nombreAlumno = scanner.nextLine();
	                
	                System.out.print("Ingrese el apellido del alumno: ");
	                String apellidoAlumno = scanner.nextLine();
	                
	                System.out.print("Ingrese el email del alumno: ");
	                String emailAlumno = scanner.nextLine();
	                
	                System.out.print("Ingrese el curso del alumno: ");
	                int curso = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                System.out.print("Ingrese el número de libreta del alumno: ");
	                int numeroLibreta = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                Alumno alumno = new Alumno(id1, nombreAlumno, apellidoAlumno, emailAlumno, curso, numeroLibreta);
	                CollectionUsuario.agregarUsuario(alumno);
	                
	                alumno.mostrarDatos();
	                
	                System.out.println("\nUsuario agregado correctamente");
	                
	            break;
	            case "2":
	            	System.out.print("\nIngrese el ID del usuario: ");
	                String id2 = scanner.nextLine();
	                
	                System.out.print("Ingrese el nombre del bibliotecario: ");
	                String nombreBibliotecario = scanner.nextLine();
	                
	                System.out.print("Ingrese el apellido del bibliotecario: ");
	                String apellidoBibliotecario = scanner.nextLine();
	                
	                System.out.print("Ingrese el email del bibliotecario: ");
	                String emailBibliotecario = scanner.nextLine();
	                
	                System.out.print("Ingrese el legajo del bibliotecario: ");
	                int legajo = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                Bibliotecario bibliotecario = new Bibliotecario(id2, nombreBibliotecario, apellidoBibliotecario, emailBibliotecario, legajo);
	                CollectionUsuario.agregarUsuario(bibliotecario);
	                
	                bibliotecario.mostrarDatos();
	                
	                System.out.println("\nUsuario agregado correctamente");
	                
	            break;
	            default: 
	            	System.out.println("\nError al seleccionar opcion");
	            	band=true;
	            }    
	        } 
	    	catch (InputMismatchException e) {
	            System.out.println("\nError: valor no permitido \nUsuario NO agregado");
	            scanner.nextLine();
	        }
    	}
    }
    
public static void registrarPrestamo(Scanner scanner) {
    	
		List<Libro> libros = CollectionLibro.libros;
		List<Usuario> usuarios = CollectionUsuario.usuarios;
		
		if(libros.isEmpty() || usuarios.isEmpty()) {
			System.out.println("\nNo existen los suficientes libros y usuarios para efectuar el prestamo");
		}
		
		else {
			
			boolean band=true;
			Libro libroPrestado = null;
			while(band) {
				
				band=false;
		    	
		    	for (Libro libro : libros) {
		    		libro.mostrarDatos();
		    	}
		    	
		    	try {    		
		        	System.out.print("\nIngrese el ID del libro ha prestar: ");
		        	String idLibro = scanner.nextLine();
		        	
		        	libroPrestado = CollectionLibro.buscarLibroPorCodigo(idLibro);
		        	
		        	if (libroPrestado == null) {
		                throw new LibroNoEncontradoException("El libro con ID " + idLibro + " no fue encontrado.");
		            }
		        
		        	if (libroPrestado.isEstado()==false){
		                throw new LibroNoDisponibleException("El libro con ID " + idLibro + " no está disponible para prestar.");
		            }
		    	}
		        catch(LibroNoEncontradoException | LibroNoDisponibleException e){
		        	System.out.println("\nError: " + e.getMessage());
		        	band=true;
		        }
			}
			
			band=true;
			Usuario usuarioPrestado = null;
			while(band) {
	           	
				band=false;
				
		    	for(Usuario usuario : usuarios) {
		    		usuario.mostrarDatos();
		    	}
		    	
		    	try {
			    	System.out.print("\nIngrese el ID del usuario: ");
			    	String idUsuario = scanner.nextLine();    	
			    	usuarioPrestado = CollectionUsuario.buscarUsuarioPorID(idUsuario);
			    	
			    	if (usuarioPrestado == null) {
			            throw new UsuarioNoRegistradoException("El usuario con ID " + idUsuario + " no está registrado.");
			        }
		    	}
		    	catch (UsuarioNoRegistradoException e) {
		    		System.out.println("\nError: " + e.getMessage());
		        	band=true;
		    	}
			}
			
			System.out.print("\nIngrese el ID del prestamo: ");
			String idPrestamo = scanner.nextLine();
		    				
			band=true;
			LocalDate fecPrestamo = null;
			while(band) {
			
				band=false;
				
				try {
					System.out.print("Ingrese la fecha del prestamo (dd/MM/yyyy): ");
					String fechaPrestamo = scanner.nextLine();
			        	
			        fecPrestamo = FechaUtil.convertirStringLocalDate(fechaPrestamo);
		        } 
				catch (DateTimeParseException e) {
		            System.out.println("\nError: El formato de la fecha es inválido. Debe ser dd/MM/yyyy");
		            band=true; 
		        }
			}
		    	
			Prestamo prestamo = new Prestamo(idPrestamo, fecPrestamo, null, libroPrestado, usuarioPrestado);
			CollectionPrestamo.agregarPrestamo(prestamo);
			
			prestamo.mostrarDatos();
				
			System.out.println("\nPrestamo realizado correctamente");
			libroPrestado.setEstado(false);
		}
    }
    
    public static void registrarDevolucion(Scanner scanner) {
        List<Prestamo> prestamos = CollectionPrestamo.prestamos;
        
        List<Prestamo> prestamosPendientes = prestamos.stream()
                .filter(prestamo -> prestamo.getFechaDevolucion() == null).toList();

        if (prestamosPendientes.isEmpty()) {
            System.out.println("\nNo hay prestamos pendientes de devolución.");
            return;
        }

        prestamosPendientes.forEach(Prestamo::mostrarDatos);
        
        Prestamo prestamo = null;
        while (prestamo == null) {
            
        	System.out.print("\nIngrese el ID del prestamo a devolver: ");
            String idPrestamo = scanner.nextLine();

            prestamo = prestamos.stream().filter(p -> p.getId().equals(idPrestamo)).findFirst().orElse(null);

            if (prestamo == null) {
                System.out.println("\nPrestamo no encontrado");
            }
            
        }

        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print("Ingrese la fecha de devolución (dd/MM/yyyy): ");
            String fechaDevolucion = scanner.nextLine();

            try {
                fecha = FechaUtil.convertirStringLocalDate(fechaDevolucion);
                
                if (fecha.isBefore(prestamo.getFechaPrestamo())) {
                    System.out.println("\nError: La fecha de devolución no puede ser anterior a la fecha del prestamo.");
                    fecha = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("\nError: El formato de fecha es inválido");
            } catch (Exception e) {
                System.out.println("\nError inesperado: " + e.getMessage());
            }
        }

        prestamo.registrarDevolucion(fecha);
        System.out.println("\nDevolución registrada correctamente");
    }
}