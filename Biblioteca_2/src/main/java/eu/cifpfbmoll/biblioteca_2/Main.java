/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import java.util.Scanner;

/**
 *
 * @author asix
 */
public class Main {
    public static Scanner lectorMenu = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        crearBiblioteca();
        mostrarMenuBiblioteca();
    }
    
    public static Biblioteca crearBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        
        return biblioteca;
    }    
    public static void mostrarMenuBiblioteca(){

        boolean menu = false;
        while(!menu){
            System.out.println("------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de la Biblioteca del Francesc de Borja Moll !!!");
            System.out.println("------------------------------------------------------------------");
            System.out.println("                   En qué menú quieres entrar?"                    );
            System.out.println("                   1.- Menú de reservas."                          );
            System.out.println("                   2.- Menú del personal."                         );
            System.out.println("                   3.- Menú de usuarios."                          );
            System.out.println("                   4.- Salir."                                     );
            System.out.println("------------------------------------------------------------------");
        
            int opcion = lectorMenu.nextInt();
            lectorMenu.nextLine();
            switch(opcion){
                case 1:
                    mostrarMenuReservas();
                    break;
                case 2:
                    mostrarMenuPersonal();
                    break;
                case 3:
                    mostrarMenuUsuarios();
                    break;
                case 4:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("                             Adiós"                                );
                    menu = true;
                    break;
            }
        }  
    }
    public static void mostrarMenuReservas(){
        Scanner lectorMenuReservas = new Scanner(System.in);
        Biblioteca objetoBiblioteca = new Biblioteca("Libreria");
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
        
            int opcion = lectorMenuReservas.nextInt();
            lectorMenuReservas.nextLine();
            switch (opcion) {
                case 1:
                    Libro.añadirLibro(objetoBiblioteca.getListaLibros());
                    System.out.println(objetoBiblioteca);
                    break;
                case 2:
                    Libro.eliminarLibro(objetoBiblioteca.getListaLibros());
                    break;
                case 3:
                    Libro.buscarISBN(objetoBiblioteca.getListaLibros());
                    break;
                case 4:
                    Libro.buscarTitulo(objetoBiblioteca.getListaLibros());
                    break;
                case 5:
                    objetoBiblioteca.mostrarLibros();
                    break;
                case 6:
                    objetoBiblioteca.mostrarLibrosDisponibles();
                    break;
                case 7:
                    mostrarMenuBiblioteca();
                    break;
                default:
                    System.out.println(" El número " + opcion + " no está disponible");
                    break;
            }
        }
    }
    public static void mostrarMenuPersonal(){
        Scanner lectorMenuPersonal = new Scanner(System.in);
        Biblioteca bibliotecarios = new Biblioteca("Trabajadores");
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
            
            int opcion = lectorMenuPersonal.nextInt();
            lectorMenuPersonal.nextLine();
            
            switch(opcion) {
                case 1:
                    //Persona.añadirTrabajador(bibliotecarios.getListaPersonal());
                    break;
                case 2:
                    //Persona.eliminarTrabajador(bibliotecarios.getListaPersonal());
                    break;
                case 3:
                    //Persona.mostrarPersonal(bibliotecarios.getListaPersonal());
                    break;
                case 4:
                    mostrarMenuBiblioteca();
                    break;
                default:
                    System.out.println(" El número " + opcion + " no está disponible");
                    break;
            }
        }
    }
    
    public static void mostrarMenuUsuarios(){
        Scanner lectorMenuUsuarios = new Scanner(System.in);
        Biblioteca usuarios = new Biblioteca("Usuarios");
        boolean menu_usuarios = false;
        while(!menu_usuarios){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de los usuarios de la Biblioteca del Francesc de Borja Moll !!!");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                           1. Añadir usuario"                                      );
            System.out.println("                           2. Encontrar y eliminar usuario"                        );
            System.out.println("                           3. Reservar libros"                                     );
            System.out.println("                           4. Mostrar usuarios"                                    );
            System.out.println("                           5. Volver al menú anterior"                             );
            System.out.println("----------------------------------------------------------------------------------");
         
            int opcion = lectorMenuUsuarios.nextInt();
            lectorMenuUsuarios.nextLine();
        
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
                    mostrarMenuBiblioteca();
                    break;
                default:
                    System.out.println("El número " + opcion + " no está disponible");
            }
        }
    }

    
}
