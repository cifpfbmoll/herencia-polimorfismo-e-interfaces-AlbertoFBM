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
public class Libro {
    // Creación del Scanner lectorLibros
    public static Scanner lectorLibros = new Scanner(System.in);
    // Creación del contador de Libros
    public static int contadorLibros;
    // Atributos de Libro
    private int ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int num_copias;
    private int num_copias_disponibles;
    
    // Constructor vacío
    
    public Libro() {
        contadorLibros++;
    }
    // Constructor con parámetros
    
    public Libro(int ISBN, String titulo, String autor, String editorial, int num_copias, int num_copias_disponibles) {
        contadorLibros++;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.num_copias = num_copias;
        this.num_copias_disponibles = num_copias_disponibles;
    }
    // Constructor copia
    
    public Libro(Libro libro1){
        contadorLibros++;
        this.setISBN(libro1.getISBN());
        this.setTitulo(libro1.getTitulo());
        this.setAutor(libro1.getAutor());
        this.setEditorial(libro1.getEditorial());
        this.setNum_copias(libro1.getNum_copias());
        this.setNum_copias_disponibles(libro1.getNum_copias_disponibles()); 
    }
    
    // GETTERS AND SETTERS
    
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNum_copias() {
        return num_copias;
    }

    public void setNum_copias(int num_copias) {
        while(num_copias < 1){
            System.out.println("No puede tener menos de una copia !");
            num_copias = lectorLibros.nextInt();
            lectorLibros.nextLine();
        }
        this.num_copias = num_copias;
        
    }

    public int getNum_copias_disponibles() {
        return num_copias_disponibles;
    }

    public void setNum_copias_disponibles(int num_copias_disponibles) {
        while(num_copias_disponibles > num_copias){
            System.out.println("No puede haber más copias disponibles que copias totales");
            num_copias_disponibles = lectorLibros.nextInt();
            lectorLibros.nextLine();
        }
        this.num_copias_disponibles = num_copias_disponibles;
        
    }
    
    // TOSTRING
    
    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" 
                + autor + ", editorial=" + editorial + ", num_copias=" 
                + num_copias + ", num_copias_disponibles=" 
                + num_copias_disponibles + '}';
    }
    
    
    // MÉTODOS
    // Añadir libros
    
    public static Libro añadirLibro(ArrayList<Libro> listaLibros){
        /* Solicitará los datos para crear un libro y añadirá dicho libro 
        a una lista de libros que recibirá como parámetro el método. */
        Libro libro1 = new Libro();
        
        System.out.println("Dime el título del libro:");
        libro1.setTitulo(lectorLibros.nextLine());
        
        
        System.out.println("Dame el ISBN del libro");
        libro1.setISBN(lectorLibros.nextInt());
        lectorLibros.nextLine();
        
        System.out.println("Dime el autor del libro:");
        libro1.setAutor(lectorLibros.nextLine());
        
        System.out.println("Dime la editorial del libro:");
        libro1.setEditorial(lectorLibros.nextLine());
        
        System.out.println("Dime el número de copias que tiene este libro");
        libro1.setNum_copias(lectorLibros.nextInt());
        lectorLibros.nextLine();
        
        System.out.println("Dime el número de copias disponibles que tiene este libro");
        libro1.setNum_copias_disponibles(lectorLibros.nextInt());
        lectorLibros.nextLine(); 
        
        listaLibros.add(libro1);
        
        return libro1;
    }
    
    public static void eliminarLibro(ArrayList<Libro> listaLibros){
        /* Eliminar libro. Solicitará al usuario un ISBN, lo buscará y lo 
        eliminará de la lista que recibirá como parámetro el método. */
        System.out.println("Pon el ISBN del libro que quieras eliminar:");
        int ISBN = lectorLibros.nextInt();
        lectorLibros.nextLine();
        int i=0;
        boolean encontrarLibro = false;
        while(!encontrarLibro && i<listaLibros.size()){
            //equals si fuera un String.
            if(listaLibros.get(i).getISBN()== ISBN){
                encontrarLibro = true;
                listaLibros.remove(i);
                System.out.println("Libro eliminado");
                System.out.println("\n");
                System.out.println("Quedan estos libros:");
                System.out.println(listaLibros);
            }
            i++;    
        }
        if(encontrarLibro == false){
            System.out.println("Libro no encontrado.");
        }
    }
    
    public static int buscarISBN(ArrayList<Libro> listaLibros){
      /*Buscar libro por ISBN. Pedirá al usuario un ISBN, lo buscará en la 
      lista que recibirá como parámetro el método. En caso de encontrarlo 
      devolverá la posición en la que se encuentra, en caso contrario 
      devolverá -1. */
      
        System.out.println("Pon el ISBN del libro que quieras buscar:");
        int ISBN = lectorLibros.nextInt();
        lectorLibros.nextLine();
        
        for(int i=0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getISBN() == ISBN){
                System.out.println("Libro encontrado.");
                System.out.println("<<" + listaLibros.get(i).getTitulo()+">>");
                return i;
            }
        }
        System.out.println("No he encontrado un libro con ese ISBN --> ¿" + ISBN + "?");
        return -1;
    }
    public static void buscarTitulo(ArrayList<Libro> listaLibros){
        /* Pedirá al usuario un título, lo buscará en la lista que recibirá como 
        parámetro el método. Mostrará cualquier libro que contenga la cadena buscada */
        
        System.out.println("Pon el título de un libro y buscaré si lo tengo:");
        String titulo = lectorLibros.nextLine();
        
        System.out.println("Este es el libro/s que he encontrado:");
        for(int i=0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getTitulo().contains(titulo)){
                                            //contains = Busca parecidos
                System.out.println(listaLibros.get(i).toString());
            }
            else{
                System.out.println("No he encontrado un libro con el titulo " + titulo);
            }
        }
    }
}
