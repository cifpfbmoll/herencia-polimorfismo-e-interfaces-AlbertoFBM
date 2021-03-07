/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asix
 */
public class Reserva implements Material{
    public static Scanner lector = new Scanner(System.in);
    // Atributos de Reserva
    private Libro libro;
    private String fechaReserva;
    private String horaReserva;

    // Constructor vacío
    public Reserva() {
    }

    // Constructor con todos los parámetros
    public Reserva(Libro libro, String fechaReserva, String horaReserva) {
        this.setLibro(libro);
        this.setFechaReserva(fechaReserva);
        this.setHoraReserva(horaReserva);
    }
    
    // Constructor copia
    public Reserva(Reserva Reserva_01){
        this.setLibro(Reserva_01.getLibro());
        this.setFechaReserva(Reserva_01.getFechaReserva());
        this.setHoraReserva(Reserva_01.getHoraReserva());
    }
    
    // Getters / Setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    
    
    public static void reservarLibro(ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios){
        int i = 0; // Para el bucle de encontrarPersona
        int j = 0; // Para el bucle de encontrarLibro
        boolean personaEncontrada = false;
        boolean libroEncontrado = false;
        
        // Pedimos al bibliotecario que ponga el teléfono y el correo del Usuario
        System.out.println("Vamos a reservar un libro, para ello pidele al usuario su teléfono y su correo:");
        System.out.println("Teléfono: ");
        int telefono = lector.nextInt();
        lector.nextLine();
        System.out.println("Correo: ");
        String correo = lector.nextLine();
        
        // Vamos a encontrar al usuario
        while(!personaEncontrada && i<listaUsuarios.size()){
            if(listaUsuarios.get(i) instanceof Usuario){
                if(((Usuario)listaUsuarios.get(i)).getTelefono() == telefono 
                && ((Usuario)listaUsuarios.get(i)).getCorreo().equals(correo)){
                    personaEncontrada = true;
                    // Vamos a comprobar que no tenga más de 5 libros reservados
                    if(((Usuario)listaUsuarios.get(i)).getLibrosReservados()<5){
                        System.out.println("Hola " + listaUsuarios.get(i).getNombre());
                        System.out.println("Ahora vamos reservar un libro, para ellos pon el ISBN del libro que quieras reservar:");
                        System.out.println("ISBN: ");
                        int ISBN = lector.nextInt();
                        lector.nextLine();
                        
                        // Vamos a encontrar el libro, repetimos la acción anterior
                        while(!libroEncontrado && j<listaLibros.size()){
                            if(listaLibros.get(j).getISBN()==ISBN){
                                libroEncontrado = true;
                                // Ahora vamos a ver si hay libros disponibles
                                if(listaLibros.get(j).getNum_copias_disponibles()>=1){
                                    Libro libro = new Libro(listaLibros.get(j));
                                    LocalDateTime fecha= LocalDateTime.now();
                                    DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
                                    Reserva reserva = new Reserva(libro, fecha.format(formatoFecha),fecha.format(formatoHora));
                                    // Vamos a añadir la reserva a la Lista de Reservas
                                    ((Usuario)listaUsuarios.get(i)).getListaReservas().add(reserva);
                                    // Vamos a restar un libro a la lista de Libros y sumar uno a la lista de Reservas
                                    listaLibros.get(j).setNum_copias_disponibles(listaLibros.get(j).getNum_copias_disponibles()-1);
                                    ((Usuario)listaUsuarios.get(i)).setLibrosReservados(((Usuario)listaUsuarios.get(i)).getLibrosReservados()+1);
                                    System.out.println("Reserva realizada con éxito");
                                }else{
                                    System.out.println("Lo siento, no hay copias disponibles de este libro en este momento.");
                                }
                            }
                            j++;
                        }
                        if(!libroEncontrado){
                            System.out.println("No hay ningún libro con ese ISBN."); 
                        }
                        
                    }else{System.out.println("No puedes tener más de 5 libros reservados.");}
                }
            }
            i++;
        }
        if(!personaEncontrada){
            System.out.println("No hemos encontrado dicho Usuario, porfavor vuelva a escribir los datos.");
        }
    }
    
    public static void devolverLibro(ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios){
        int i = 0; // Para el bucle de encontrarPersona
        int j = 0; // Para el bucle de encontrarLibro
        int k = 0; // Para el bucle de libroDevuelto
        boolean personaEncontrada = false;
        boolean libroEncontrado = false;
        boolean libroDevuelto = false;
        
        System.out.println("Vamos a devolver un libro, para ello preguntale el telefono y el correo al Usuario:");
        System.out.println("Teléfono:");
        int telefono = lector.nextInt();
        lector.nextLine();
        System.out.println("Correo:");
        String correo = lector.nextLine();
        
        while(!personaEncontrada && i<listaLibros.size()){
            if(listaUsuarios.get(i) instanceof Usuario){
                if(((Usuario)listaUsuarios.get(i)).getTelefono()==telefono 
                && ((Usuario)listaUsuarios.get(i)).getCorreo().equals(correo)){
                    personaEncontrada = true;
                    
                    // Ahora vamos a encontrar el libro que quiere devolver por el ISBN
                    System.out.println("Dime el ISBN del libro que quieres devolver:");
                    int ISBN = lector.nextInt();
                    lector.nextLine();
                    while(!libroEncontrado && j<((Usuario)listaUsuarios.get(i)).getListaReservas().size()){
                        if(((Usuario)listaUsuarios.get(i)).getListaReservas().get(j).getLibro().getISBN()==ISBN){
                            libroEncontrado = true;
                            
                             /* Ahora que ya hemos encontrado al Usuario y el libro que quiere devolver,
                                es hora de devolver el libro a la lista de Libros
                            */ 
                            while(!libroDevuelto && k<listaLibros.size()){
                                if(listaLibros.get(k).getISBN()==ISBN){
                                    listaLibros.get(k).setNum_copias_disponibles(listaLibros.get(k).getNum_copias_disponibles()+1);
                                    libroDevuelto = true;
                                }
                                k++;
                            }
                            ((Usuario)listaUsuarios.get(i)).setLibrosReservados(((Usuario)listaUsuarios.get(i)).getLibrosReservados()-1);
                            ((Usuario)listaUsuarios.get(i)).getListaReservas().remove(j);
                            System.out.println("Devolución realizada con éxito");
                            
                        }
                    j++;
                    }
                    if(!libroEncontrado){
                        System.out.println("No hay ningún libro con ese ISBN.");
                    }
                }
                else{
                    System.out.println("No he encontrado a un Usuario con esos datos.");
                }
            }
            i++;
        }
        if(!personaEncontrada){
            System.out.println("No hemos encontrado dicho Usuario, porfavor vuelva a escribir los datos.");
        }
    }
    
    // Estos son los dos métodos abstractos de la interfaz Material 
    @Override
    public void obtenerFechaDevolución() {
        if(this.getLibro() instanceof Libro){
            String fechaReserva = this.getFechaReserva();
            DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaReservaDate= LocalDate.parse(fechaReserva,formatoFecha);
            LocalDate fechaDevolucion=fechaReservaDate.plusMonths(1);
            System.out.println("        Tienes que devolver el libro el día: "+fechaDevolucion.format(formatoFecha));
        }
    }

    @Override
    public void mostrarInfoChula() {
         System.out.println("-----------------------------------------------------");
         System.out.println("  RESERVA DE "+ this.getLibro().getTitulo());
         System.out.println("-----------------------------------------------------");
         System.out.println("            ISBN: "+ this.getLibro().getISBN());
         System.out.println("            Autor: "+ this.getLibro().getAutor());
         System.out.println("            Editorial: "+ this.getLibro().getEditorial());
         System.out.println("-----------------------------------------------------");
         System.out.println("            Fecha: "+ this.getFechaReserva());
         System.out.println("            Hora: "+ this.getHoraReserva());
         System.out.println("-----------------------------------------------------");
         this.obtenerFechaDevolución();
         System.out.println("-----------------------------------------------------");
    }
}
