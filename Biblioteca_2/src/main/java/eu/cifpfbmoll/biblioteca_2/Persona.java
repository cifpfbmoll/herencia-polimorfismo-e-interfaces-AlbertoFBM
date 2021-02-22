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
        Persona persona1 = new Persona();
        
        System.out.println("Dime tu nombre:");
        persona1.setNombre(lector.nextLine());
        
        System.out.println("Primer apellido:");
        persona1.setApellido1(lector.nextLine());
        
        System.out.println("Segundo apellido:");
        persona1.setApellido2(lector.nextLine());
        
        System.out.println("Edad:");
        persona1.setEdad(lector.nextInt());
        lector.nextLine();
        
    }
}