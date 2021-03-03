/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Biblioteca {
    public static Scanner lector = new Scanner(System.in);
    // Atributos de la Biblioteca
    private String nombreBiblioteca;    
    private ArrayList<Libro> listaLibros = new ArrayList();
    private ArrayList<Persona> listaPersonal = new ArrayList();
    // añado un nuevo ArrayList<Usuario> para el ejercicio opcional
    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    
    
    // Constructor vacío
    public Biblioteca() {
    }
    
    // Constructor con todos los parámetros
    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }
    // Constructor copia de Biblioteca
    public Biblioteca(Biblioteca Biblioteca){
        this.setNombreBiblioteca(Biblioteca.getNombreBiblioteca());
        this.setListaLibros(Biblioteca.getListaLibros());
        this.setListaPersonal(Biblioteca.getListaPersonal());
        this.setListaUsuarios(Biblioteca.getListaUsuarios());
    }   
    
    // GETTERS AND SETTERS
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        while((Character.getType(nombreBiblioteca.charAt(0)))!=1){
            System.out.println("El nombre de la Biblioteca debe esta en mayúscula:");
            nombreBiblioteca = lector.nextLine();
        }
        this.nombreBiblioteca = nombreBiblioteca;
    }
    //
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    //
    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }
    
    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    // Los nuevos GETTER AND SETTER de Usuario
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    
    // TO-STRING

    @Override
    public String toString() {
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", listaLibros=" + listaLibros + ", "
                + "listaPersonal=" + listaPersonal + ", listaUsuarios=" + listaUsuarios + '}';
    }
    
    
    
    
    // MÉTODOS DE LA BIBLIOTECA
    
    public void mostrarLibros(){
        
        System.out.println("Estos son todos los libros que tiene " + getNombreBiblioteca());
        for(int i=0; i < listaLibros.size(); i++){
            System.out.println(listaLibros.get(i));
        }
    }
 
    public void mostrarLibrosDisponibles(){
        
        System.out.println("Estos son los libros disponibles de " + getNombreBiblioteca());
        for(int i=0; i<listaLibros.size(); i++){
            if(listaLibros.get(i).getNum_copias_disponibles()>0){
                System.out.println("El libro <<" + listaLibros.get(i).getTitulo() 
                        + ">> tiene " + listaLibros.get(i).getNum_copias_disponibles() + " copias disponibles");
            }
        }
    }
    
    public ArrayList<Libro> reservarLibro(ArrayList<Libro> listaLibros){
        
        Scanner lector = new Scanner(System.in);
        int i = 0;
        
        System.out.println("Para reservar un libro primero inicia sesión.");
        //Usuario.iniciarSesion(listaUsuarios);
        System.out.println("\n");
        System.out.println("Ahora que has iniciado sesión ya puedes reservar un libro");
        
        System.out.println("Quieres ver los libros que hay disponibles? [S/N]");
        String opcion = lector.nextLine().toUpperCase();
        
        switch (opcion) {
            case "S":
                System.out.println("Estos son los libros que hay disponibles:");
                for(i=0; i<listaLibros.size(); i++){
                    if(listaLibros.get(i).getNum_copias_disponibles()>0){
                        System.out.println("El libro <<" + listaLibros.get(i).getTitulo()
                        + ">> tiene " + listaLibros.get(i).getNum_copias_disponibles()
                        + " copias disponibles");
                    }
                    i++;
                }
            case "N":
                System.out.println("Escribe el ISBN del libro en cuestión:");
        
        
                int ISBN = lector.nextInt();
                lector.nextLine();
        
                boolean ISBNencontrado = false;
        
                while(!ISBNencontrado && i<listaLibros.size()){
                    if(listaLibros.get(i).getISBN()==ISBN){
                        if(listaLibros.get(i).getNum_copias_disponibles()==0){
                            System.out.println("Este libro tiene 0 copias disponibles");
                            return listaLibros;
                        }
                        else{
                          ISBNencontrado = true;  
                        }
                    }
                }
                
                for(i=0; i<listaLibros.size(); i++){
                    if(listaLibros.get(i).getISBN() == ISBN){
                        listaLibros.get(i).setNum_copias_disponibles(listaLibros.get(i).getNum_copias_disponibles() - 1);
                        System.out.println("Libro reservado con éxito.");
                    }
                }
                break;
            default:
                System.out.println("Escribe SI [S] o NO [N] por favor");;
        }
         
        return listaLibros;
    }
}
