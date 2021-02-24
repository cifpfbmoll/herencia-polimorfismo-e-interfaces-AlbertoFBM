/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import java.util.ArrayList;


/**
 *
 * @author asix
 */
public class Usuario extends Persona{
    // Atributos de Usuario, aparte de los de Persona
    private int telefono;
    private String direccion;
    private int codigoPostal;
    private String correo;
    private ArrayList<Reserva> listaReservas = new ArrayList();
    //private int librosReservados;
    // Constructor vacío

    public Usuario() {
    }
    
    // Constructor con todos los parámetros, incluidos los de Persona

    public Usuario(int telefono, String direccion, int codigoPostal, String correo, String nombre, String apellido1, String apellido2, int edad, ArrayList<Reserva> listaReservas) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.listaReservas = listaReservas;
    }
    
    

    public Usuario(Usuario copiaUsuario){
       this.setTelefono(copiaUsuario.getTelefono());
       this.setDireccion(copiaUsuario.getDireccion());
       this.setCodigoPostal(copiaUsuario.getCodigoPostal());
       this.setCorreo(copiaUsuario.getCorreo());
       this.setListaReservas(copiaUsuario.getListaReservas());
    }
    
    // Getters / Setters
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    // To String
    
    @Override
    public String toString() {
        return super.toString() + "Usuario{" + "telefono=" + telefono + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", correo=" + correo + ", Reservas=" + listaReservas + '}';
    
    }
    
    // MÉTODOS

    
    public void solicitarDatosPersona() {
        
        super.solicitarDatosPersona(); 
        
        System.out.println("Pon tu número de teléfono:");
        this.setTelefono(lector.nextInt());
        lector.nextLine();
        
        System.out.println("Pon tu dirección:");
        this.setDireccion(lector.nextLine());
        
        System.out.println("Pon el número postal:");
        this.setCodigoPostal(lector.nextInt());
        lector.nextLine();
        
        System.out.println("Pon tu correo electrónico:");
        this.setCorreo(lector.nextLine());
        
    }
    
    
    
    
    
    
    
    
    
}
