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
public class Persona {
    public static Scanner lector = new Scanner(System.in);
    // Atributos de Persona
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    
    // Constructor vacío
    public Persona() {
    }
    
    // Constructor con parámetros

    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }
    
    // Constructor copia
    public Persona(Persona copiaPersona){
        this.setNombre(copiaPersona.getNombre());
        this.setApellido1(copiaPersona.getApellido1());
        this.setApellido2(copiaPersona.getApellido2());
        this.setEdad(copiaPersona.getEdad());
    }
    
    // Getters / Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // To String
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }
    
    // Métodos
    
    public void solicitarDatosPersona(){
        
        System.out.println("Dime tu nombre:");
        this.setNombre(lector.nextLine());
        
        System.out.println("Primer apellido:");
        this.setApellido1(lector.nextLine());
        
        System.out.println("Segundo apellido:");
        this.setApellido2(lector.nextLine());
        
        System.out.println("Edad:");
        this.setEdad(lector.nextInt());
        lector.nextLine();
        
    }
    
    public static void eliminarBibliotecario(ArrayList<Persona> listaPersonal){
        System.out.println("Vamos a encontrar y eliminar a una Bibliotecario");
        System.out.println("Para ello escribe su nombre y sus apellidos");
        boolean encontrado = false;
        
        System.out.println("Nombre:");
        String nombre = lector.nextLine();
        
        System.out.println("Primer apellido:");
        String apellido1 = lector.nextLine();
        
        System.out.println("Segundo apellido:");
        String apellido2 = lector.nextLine();
        
        for(int i=0; i<listaPersonal.size(); i++){
            if(listaPersonal.get(i).getNombre().equals(nombre) &&
                listaPersonal.get(i).getApellido1().equals(apellido1) &&
                listaPersonal.get(i).getApellido2().equals(apellido2)){
                listaPersonal.remove(i);
                encontrado = true;
                System.out.println("Bibliotecario encontrado y eliminado. Bye Bye " +nombre);
            } 
        }
        if(!encontrado){
            System.out.println("No he encontrado a ese Bibliotecario, porfavor escriba otra vez sus datos.");
        }
    }
    public static void eliminarUsuario(ArrayList<Usuario> listaUsuarios){
        System.out.println("Vamos a encontrar y eliminar a un Usuario");
        System.out.println("Para ello escribe su nombre y sus apellidos");
        boolean encontrado = false;
        
        System.out.println("Nombre:");
        String nombre = lector.nextLine();
        
        System.out.println("Primer apellido:");
        String apellido1 = lector.nextLine();
        
        System.out.println("Segundo apellido:");
        String apellido2 = lector.nextLine();
        
        for(int i=0; i<listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(nombre) &&
                listaUsuarios.get(i).getApellido1().equals(apellido1) &&
                listaUsuarios.get(i).getApellido2().equals(apellido2)){
                listaUsuarios.remove(i);
                encontrado = true;
                System.out.println("Usuario encontrado y eliminado. Bye Bye " +nombre);
            } 
        }
        if(!encontrado){
            System.out.println("No he encontrado a ese Usuario, porfavor escriba otra vez sus datos.");
        }
    }
}