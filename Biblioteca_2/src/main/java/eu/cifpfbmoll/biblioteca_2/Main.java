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
        inicioSesion(biblioteca);
        mostrarMenuBiblioteca(biblioteca);
    }
    
    public static Biblioteca crearBiblioteca(){
        
        System.out.println("Como se llamará tu Biblioteca?");
        String nombreBiblioteca = lector.nextLine();
        Biblioteca biblioteca = new Biblioteca(nombreBiblioteca);
        
        return biblioteca;
    }    
    
    public static void inicioSesion(Biblioteca biblioteca){
        System.out.println("------------------------------------------------------------------");
        System.out.println("   Bienvenido al menú de " + biblioteca.getNombreBiblioteca()      );
        System.out.println("------------------------------------------------------------------");
        System.out.println("       Inicia sesión como Administrador o como Usuario:"           );
        System.out.println("                      1. Administrador"                            );
        System.out.println("                      2. Usuario"                                  );
        byte opcion = lector.nextByte();
        
        int menu = 1;
        while(menu != 0) {
            switch (opcion) {
            case 1:
                gestionarAdministrador(biblioteca);
                break;
            case 2:
                //gestionarUsuario();
                break;
            default:
                System.out.println("Pon una opción correcta:");
                opcion = lector.nextByte();
                break;
            }
        }
        
    }
    
    public static void gestionarAdministrador(Biblioteca biblioteca){
        System.out.println("------------------------------------------------------------------");
        System.out.println("      Has iniciado sesión como Administrador/Bibliotecario"        );
        System.out.println("------------------------------------------------------------------");
        System.out.println("                   1. Gestionar reservas"                          );
        System.out.println("                   2. Gestionar bibliotecarios"                    );
        System.out.println("                   3. Gestionar usuarios"                          );
        System.out.println("                   4. Salir de esta sesión"                        );
        System.out.println("------------------------------------------------------------------");
        byte opcion = lector.nextByte();
        
        int menu = 1;
        while(menu != 0){
            switch (opcion) {
            case 1:
                mostrarMenuReservas(biblioteca);
                break;
            case 2:
                //crearAdministrador(biblioteca);
                break;
            case 3:
                //crearUsuario(biblioteca);
                break;
            case 4:
                inicioSesion(biblioteca);
            default:
                System.out.println("Pon una opción correcta:");
                opcion = lector.nextByte();
            }  
        }
    }
    public static void mostrarMenuBiblioteca(Biblioteca biblioteca){
        int menu = 1;
        while(menu != 0){
            System.out.println("------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de " + biblioteca.getNombreBiblioteca());
            System.out.println("------------------------------------------------------------------");
            System.out.println("                   En qué menú quieres entrar?"                    );
            System.out.println("                   1.- Menú de reservas."                          );
            System.out.println("                   2.- Menú del personal."                         );
            System.out.println("                   3.- Menú de usuarios."                          );
            System.out.println("                   4.- Salir."                                     );
            System.out.println("------------------------------------------------------------------");
        
            byte opcion = lector.nextByte();
            switch(opcion){
                case 1:
                    mostrarMenuReservas(biblioteca);
                    break;
                case 2:
                    mostrarMenuPersonal(biblioteca);
                    break;
                case 3:
                    mostrarMenuUsuarios(biblioteca);
                    break;
                case 4:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("                             Adiós"                                );
                    menu = 0;
                    break;
            }
        }  
    }
   public static void mostrarMenuReservas(Biblioteca biblioteca){
        boolean menuReservas = false;
        while(!menuReservas){
            System.out.println("------------------------------------------------------------------");
            System.out.println("                   1.- Añadir libros"                              );
            System.out.println("                   2.- Eliminar libro"                             );
            System.out.println("                   3.- Buscar libro por ISBN"                      );
            System.out.println("                   4.- Buscar libro por título"                    );
            System.out.println("                   5.- Mostrar todos los libros de la Biblioteca"  );
            System.out.println("                   6.- Mostrar solo los libros disponibles"        );
            System.out.println("                   7.- Volver al menú anterior"                    );
            System.out.println("------------------------------------------------------------------");
        
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
                    mostrarMenuBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println(" El número " + opcion + " no está disponible");
                    break;
            }
        }
    }
    public static void mostrarMenuPersonal(Biblioteca biblioteca){
        boolean menuPersonal = false;
        while(!menuPersonal){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de los trabajadores de la Biblioteca del Francesc de Borja Moll !!!");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                             1. Añadir trabajador"                                     );
            System.out.println("                             2. Encontrar y eliminar trabajador"                       );
            System.out.println("                             3. Mostrar todo el personal de la biblioteca"             );
            System.out.println("                             4. Volver al menú anterior"                               );
            System.out.println("--------------------------------------------------------------------------------------");
            
            byte opcion = lector.nextByte();
            
            switch(opcion) {
                case 1:
                    //Persona.añadirTrabajador(biblioteca.getListaPersonal());
                    break;
                case 2:
                    //Persona.eliminarTrabajador(biblioteca.getListaPersonal());
                    break;
                case 3:
                    //Persona.mostrarPersonal(biblioteca.getListaPersonal());
                    break;
                case 4:
                    mostrarMenuBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println(" El número " + opcion + " no está disponible");
                    break;
            }
        }
    }
    
    public static void mostrarMenuUsuarios(Biblioteca biblioteca){
        Biblioteca usuarios = new Biblioteca("Usuarios");
        boolean menu_usuarios = false;
        while(!menu_usuarios){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de los usuarios de la Biblioteca del Francesc de Borja Moll !!!");
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
                    //Usuario.crearUsuario(usuarios.getListaUsuarios());
                    break;
                case 2:
                    //Usuario.eliminarUsuario(usuarios.getListaUsuarios());
                    break;
                case 3:
                    Biblioteca.reservarLibro(usuarios.getListaLibros());
                    break;
                case 4:
                    //Usuario.mostrarUsuarios(usuarios.getListaUsuarios());
                    break;
                case 5:
                    mostrarMenuBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println("El número " + opcion + " no está disponible");
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
