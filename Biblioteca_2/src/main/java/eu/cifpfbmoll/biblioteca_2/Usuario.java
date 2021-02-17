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
    private ArrayList Reservas = new ArrayList();
    
    // Constructor vacío

    public Usuario() {
    }
    
    // Constructor con todos los parámetros, incluidos los de Persona
    
    public Usuario(int telefono, String direccion, int codigoPostal, String correo, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
    }

    public Usuario(Usuario copiaUsuario){
       this.setTelefono(copiaUsuario.getTelefono());
       this.setDireccion(copiaUsuario.getDireccion());
       this.setCodigoPostal(copiaUsuario.getCodigoPostal());
       this.setCorreo(copiaUsuario.getCorreo());
       this.setReservas(copiaUsuario.getReservas());
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

    public ArrayList getReservas() {
        return Reservas;
    }

    public void setReservas(ArrayList Reservas) {
        this.Reservas = Reservas;
    }
    
    // To String
    
    @Override
    public String toString() {
        return super.toString() + "Usuario{" + "telefono=" + telefono + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", correo=" + correo + ", Reservas=" + Reservas + '}';
    
    }

    
    
    
    
    
    
    
}
