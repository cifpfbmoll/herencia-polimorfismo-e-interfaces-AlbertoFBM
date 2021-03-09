/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asix
 */
public class Main {
    public static Scanner lector = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biblioteca biblioteca = crearBiblioteca();
        inicializarBiblioteca(biblioteca);
        
        Usuario U1 = new Usuario();
        System.out.println("Vamos a crear un primer administrador para gestionar la Biblioteca.");
        crearAdministrador(biblioteca);
        inicioSesion(biblioteca, U1);
        //mostrarMenuBiblioteca(biblioteca);
    }
    
    public static Biblioteca crearBiblioteca(){
        
        System.out.println("Como se llamará tu Biblioteca?");
        String nombreBiblioteca = lector.nextLine();
        Biblioteca biblioteca = new Biblioteca(nombreBiblioteca);
        
        return biblioteca;
    }    
    
    public static void inicioSesion(Biblioteca biblioteca, Usuario U1){
        int posicion = 0;
        System.out.println("------------------------------------------------------------------");
        System.out.println("   Bienvenido al menú de " + biblioteca.getNombreBiblioteca()      );
        System.out.println("------------------------------------------------------------------");
        System.out.println("       Inicia sesión como Administrador o como Usuario:"           );
        System.out.println("                      1. Administrador"                            );
        System.out.println("                      2. Usuario"                                  );
        System.out.println("------------------------------------------------------------------");
        byte opcion = lector.nextByte();
        
        switch (opcion) {
            case 1:
                posicion = Bibliotecario.comprobarSesionAdministrador(biblioteca);
                if(posicion == 0){
                    System.out.println("Bibliotecario no logueado.");
                    inicioSesion(biblioteca, U1);
                }
                menuAdministrador(biblioteca , U1);
                break;
            case 2:
                posicion = Usuario.comprobarSesionUsuario(biblioteca);
                if(posicion == 0){
                    System.out.println("Usuario no logueado.");
                    inicioSesion(biblioteca, U1);
                }
                menuUsuarios(biblioteca, U1);
                break;
            default:
                System.out.println("Pon una opción correcta:");
                opcion = lector.nextByte();
                break;
        }   
    }

    public static void crearAdministrador(Biblioteca biblioteca){
        Bibliotecario B1 = new Bibliotecario();
        B1.solicitarDatosPersona();
        biblioteca.getListaPersonal().add(B1);
    }
    
    public static void crearUsuario(Biblioteca biblioteca){
        Usuario U1 = new Usuario();
        U1.solicitarDatosPersona();
        biblioteca.getListaUsuarios().add(U1);
    }
    
    public static void menuAdministrador(Biblioteca biblioteca, Usuario U1){
        System.out.println("------------------------------------------------------------------");
        System.out.println("      Has iniciado sesión como Administrador/Bibliotecario"        );
        System.out.println("------------------------------------------------------------------");
        System.out.println("                   1. Gestionar reservas"                          );
        System.out.println("                   2. Gestionar bibliotecarios"                    );
        System.out.println("                   3. Gestionar usuarios"                          );
        System.out.println("                   4. Cambiar la contraseña"                       );
        System.out.println("                   5. Salir de esta sesión"                        );
        System.out.println("------------------------------------------------------------------");
        byte opcion = lector.nextByte();
        
        switch(opcion) {
            case 1:
                gestionarReservas(biblioteca, U1);
                break;
            case 2:
                gestionarPersonal(biblioteca, U1);
                break;
            case 3:
                gestionarUsuarios(biblioteca, U1);
                break;
            case 4:
                int i = 0;
                boolean encontrado = false;
                System.out.println("Escribe la contraseña actual:");
                String contraseña = lector.nextLine();
                
                while(!encontrado && i<biblioteca.getListaPersonal().size()){
                    if(biblioteca.getListaPersonal().get(i) instanceof Bibliotecario){
                        if(((Bibliotecario)biblioteca.getListaPersonal().get(i)).getContraseña().equals(contraseña)){
                            encontrado = true;
                            ((Bibliotecario)biblioteca.getListaPersonal().get(i)).cambiarContraseña();
                        }
                    }
                    i++;
                }
                if(!encontrado){
                    System.out.println("Esa no es tu contraseña actual");
                }
                break;
            case 5:
                inicioSesion(biblioteca, U1);
                break;
            default:
                System.out.println("Pon una opción correcta:");
                opcion = lector.nextByte();
                break;
        }  
    }
    
   public static void gestionarReservas(Biblioteca biblioteca, Usuario U1){
        boolean menuReservas = false;
        while(!menuReservas){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("        En este menú se gestionan los libros de " + biblioteca.getNombreBiblioteca());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                 1. Añadir libros"                                );
            System.out.println("                 2. Eliminar libro"                               );
            System.out.println("                 3. Buscar libro por ISBN"                        );
            System.out.println("                 4. Buscar libro por título"                      );
            System.out.println("                 5. Mostrar todos los libros de la Biblioteca"    );
            System.out.println("                 6. Mostrar solo los libros disponibles"          );
            System.out.println("                 7. Reservar libro"                               );
            System.out.println("                 8. Devolver libro"                               );
            System.out.println("                 9. Mostrar los libros reservados de un usuario"  );
            System.out.println("                 10. Volver al menú anterior"                     );
            System.out.println("-----------------------------------------------------------------");
        
            byte opcion = lector.nextByte();
            
            switch (opcion) {
                case 1:
                    Libro.añadirLibro(biblioteca.getListaLibros());
                    System.out.println(biblioteca);
                    break;
                case 2:
                    Libro.eliminarLibro(biblioteca.getListaLibros());
                    break;
                case 3:
                    Libro.buscarISBN(biblioteca.getListaLibros());
                    break;
                case 4:
                    Libro.buscarTitulo(biblioteca.getListaLibros());
                    break;
                case 5:
                    biblioteca.mostrarLibros();
                    break;
                case 6:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 7:
                    Reserva.reservarLibro(biblioteca.getListaLibros(), biblioteca.getListaUsuarios());
                    break;
                case 8:
                    Reserva.devolverLibro(biblioteca.getListaLibros(), biblioteca.getListaUsuarios());
                    break;
                case 9:
                    for(int i=0; i<biblioteca.getListaUsuarios().size(); i++){
                        biblioteca.getListaUsuarios().get(i).mostrarLibrosReservados();
                    }
                    break;
                case 10:
                    menuAdministrador(biblioteca, U1);
                    break;
                default:
                    System.out.println("Pon una opción correcta:");
                    opcion = lector.nextByte();
                    break;
            }
        }
    }
    public static void gestionarPersonal(Biblioteca biblioteca, Usuario U1){
        boolean menuPersonal = false;
        while(!menuPersonal){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("         En este menú se gestionan los trabajadores de " + biblioteca.getNombreBiblioteca());
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("                     1. Añadir bibliotecario"                                  );
            System.out.println("                     2. Encontrar y eliminar bibliotecario"                    );
            System.out.println("                     3. Mostrar todo el personal de la biblioteca"             );
            System.out.println("                     4. Volver al menú anterior"                               );
            System.out.println("------------------------------------------------------------------------------");
            
            byte opcion = lector.nextByte();
            
            switch(opcion) {
                case 1:
                    Bibliotecario B1 = new Bibliotecario();
                    B1.solicitarDatosPersona();
                    biblioteca.getListaPersonal().add(B1);
                    break;
                case 2:
                    Bibliotecario.eliminarBibliotecario(biblioteca.getListaPersonal());
                    break;
                case 3:
                    Bibliotecario.mostrarPersonal(biblioteca.getListaPersonal());
                    break;
                case 4:
                    menuAdministrador(biblioteca, U1);
                    break;
                default:
                    System.out.println("Pon una opción correcta:");
                    opcion = lector.nextByte();
                    break;
            }
        }
    }
    
    public static void gestionarUsuarios(Biblioteca biblioteca, Usuario U1){
        boolean menu_usuarios = false;
        while(!menu_usuarios){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("         En este menú se gestionan los usuarios de " + biblioteca.getNombreBiblioteca());
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                         1. Añadir usuario"                                        );
            System.out.println("                         2. Encontrar y eliminar usuario"                          );
            System.out.println("                         3. Reservar libros"                                       );
            System.out.println("                         4. Mostrar todos los usuarios de la biblioteca"           );
            System.out.println("                         5. Volver al menú anterior"                               );
            System.out.println("----------------------------------------------------------------------------------");
         
            byte opcion = lector.nextByte();
            
            
            switch (opcion) {
                case 1:
                    U1.solicitarDatosPersona();
                    biblioteca.getListaUsuarios().add(U1);
                    break;
                case 2:
                    Persona.eliminarUsuario(biblioteca.getListaUsuarios());
                    break;
                case 3:
                    Reserva.reservarLibro(biblioteca.getListaLibros(), biblioteca.getListaUsuarios());
                    break;
                case 4:
                    Usuario.mostrarUsuarios(biblioteca.getListaUsuarios());
                    break;
                case 5:
                    menuAdministrador(biblioteca, U1);
                    break;
                default:
                    System.out.println("Pon una opción correcta:");
                    opcion = lector.nextByte();
                    break;
            }
        }
    }
    public static void menuUsuarios(Biblioteca biblioteca, Usuario U1){
        boolean menuUsuarios = false;
        while(!menuUsuarios){
            System.out.println("------------------------------------------------------");
            System.out.println("         Has iniciado sesión como Usuario"             );
            System.out.println("------------------------------------------------------");
            System.out.println("           1. Mostrar todos los libros"                );
            System.out.println("           2. Mostrar los libros disponibles"          );
            System.out.println("           3. Buscar un libro por su ISBN"             );
            System.out.println("           4. Buscar un libro por su título"           );
            System.out.println("           5. Mostrar libros reservados"               );
            System.out.println("           6. Cambiar el teléfono o el correo"         );
            System.out.println("           7. Salir de esta sesión"                    );
            System.out.println("------------------------------------------------------");
            byte opcion = lector.nextByte();
        
            switch (opcion) {
                case 1:
                    biblioteca.mostrarLibros();
                    break;
                case 2:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 3:
                    Libro.buscarISBN(biblioteca.getListaLibros());
                    break;
                case 4:
                    Libro.buscarTitulo(biblioteca.getListaLibros());
                    break;
                case 5:
                    U1.mostrarLibrosReservados();
                    break;
                case 6:
                    int i = 0;
                    boolean encontrado = false;
                    
                    System.out.println("Escribe tu teléfono actual:");
                    int telefono = lector.nextInt();
                    lector.nextLine();
                    
                    while(!encontrado && i<biblioteca.getListaUsuarios().size()){
                        if(biblioteca.getListaUsuarios().get(i) instanceof Usuario){
                            if(((Usuario)biblioteca.getListaUsuarios().get(i)).getTelefono()==telefono){
                                encontrado = true;
                                ((Usuario)biblioteca.getListaUsuarios().get(i)).cambiarContraseña();
                            }
                        }
                    }
                    if(!encontrado){
                        System.out.println("Ese no es tu teléfono actual");
                    }
                    break;
                case 7:
                    inicioSesion(biblioteca, U1);
                    break;
                default:
                    System.out.println("Pon una opción correcta:");
                    opcion = lector.nextByte();
                    break;
            }
        }
    }
    
    public static Biblioteca inicializarBiblioteca(Biblioteca biblioteca){
        // Este es un método para añadir bibliotecarios, usuarios y unos cuantos libros a la Biblioteca
        
        /* Primero añadimos Bibliotecarios
        Bibliotecario : String puestoTrabajo, String NIF, String contraseña, 
                        String nombre, String apellido1, String apellido2, int edad
        */
        Bibliotecario B1 = new Bibliotecario("Mesa_01", "123A", "9876", "Alberto", "Serrano", "Ruiz", 19);
        Bibliotecario B2 = new Bibliotecario("Mesa_02", "123B", "9753", "Jose Luis", "Serrano", "Serrano", 56);
        Bibliotecario B3 = new Bibliotecario("Mesa_03", "123C", "1357", "Ainhoa", "Rosselló", "Gutiérrez", 18);
        Bibliotecario B4 = new Bibliotecario("Mesa_04", "123D", "2468", "Diego", "Moncada", "Millacura", 20);
        
        biblioteca.getListaPersonal().add(B1);
        biblioteca.getListaPersonal().add(B2);
        biblioteca.getListaPersonal().add(B3);
        biblioteca.getListaPersonal().add(B4);
        /* Segundo añadimos Usuarios
        Usuario: int telefono, String direccion, int codigoPostal, String correo,
                 String nombre, String apellido1, String apellido2, int edad
        */
        Usuario U1 = new Usuario(112233, "c/ Navas de Tolosa", 07007, "aabbcc@gmail.com", "Joel", "García", "Alcaraz", 19, new ArrayList<Reserva>());
        Usuario U2 = new Usuario(445566, "c/ Calvo Sotelo", 07010, "kkbbee@gmail.com", "Alejandra", "Aliaga", "a", 19, new ArrayList<Reserva>());
        Usuario U3 = new Usuario(778899, "c/ Illes Pitiüses", 07007, "qqwwee@hotmail.com", "Joserri", "Paterna", "Montesino", 19, new ArrayList<Reserva>());
        Usuario U4 = new Usuario(224466, "c/ Alfambra", 07001, "ooiijj@outlook.es", "Claudia", "Obrador", "Tur", 19, new ArrayList<Reserva>());
        
        biblioteca.getListaUsuarios().add(U1);
        biblioteca.getListaUsuarios().add(U2);
        biblioteca.getListaUsuarios().add(U3);
        biblioteca.getListaUsuarios().add(U4);
        
        /* Por último añadimos unos cuantos Libros
        Libro: int ISBN, String titulo, String autor, String editorial, 
               int num_copias, int num_copias_disponibles
        */
        Libro L1 = new Libro(12345, "Harry Potter y la Piedra Filosofal", "JK Rowling", "Salamanca", 1000, 100);
        Libro L2 = new Libro(24680, "Harry Potter y la Cámara Secreta", " JK Rowling ", "Salamanca", 1000, 68);
        Libro L3 = new Libro(36912, "Harry Potter y el Prisionero De Azcaban", "JK Rowling", "Salamanca", 1000, 25);
        Libro L4 = new Libro(98765, "Harry Potter y el Caliz de Fuego", "JK Rowling", "Salamanca", 1000, 89);
        Libro L5 = new Libro(97531, "Harry Potter y la Orden del Fénix", "JK Rowling", "Salamanca", 1000, 76);
        Libro L6 = new Libro(12345, "Harry Potter y el misterio del Principe", "JK Rowling", "Salamanca", 1000, 30);
        Libro L7 = new Libro(10203, "Harry Potter y las Reliquias de la Muerte", "JK Rowling", "Salamanca", 1000, 1);
        
        biblioteca.getListaLibros().add(L1);
        biblioteca.getListaLibros().add(L2);
        biblioteca.getListaLibros().add(L3);
        biblioteca.getListaLibros().add(L4);
        biblioteca.getListaLibros().add(L5);
        biblioteca.getListaLibros().add(L6);
        biblioteca.getListaLibros().add(L7);
        
        return biblioteca;        
    }
  
}
