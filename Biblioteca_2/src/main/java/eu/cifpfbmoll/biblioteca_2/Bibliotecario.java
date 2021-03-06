/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import static eu.cifpfbmoll.biblioteca_2.Main.lector;
import java.util.ArrayList;


/**
 *
 * @author asix
 */
public class Bibliotecario extends Persona{
    // Atributos de Bibliotecario, a parte de los de Persona
    private String puestoTrabajo;
    private String NIF;
    private String contraseña;

    // Constructor vacío
    
    public Bibliotecario() {
    }
    
    // Constructor con todos los parámetros
    
    public Bibliotecario(String puestoTrabajo, String NIF, String contraseña, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.puestoTrabajo = puestoTrabajo;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }
    
    // Constructor copia
    
    public Bibliotecario(Bibliotecario copiaBibliotecario){
        this.setPuestoTrabajo(copiaBibliotecario.getPuestoTrabajo());
        this.setNIF(copiaBibliotecario.getNIF());
        this.setContraseña(copiaBibliotecario.getContraseña());
    }
    
    // Getters / Setters
    
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    // To String
    
    @Override
    public String toString() {
        return super.toString() +"Bibliotecario{" + "puestoTrabajo=" + puestoTrabajo + ", NIF=" + NIF + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    // MÉTODOS

    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona(); 
        
        System.out.println("Qué puesto de trabajo tienes?");
        this.setPuestoTrabajo(lector.nextLine());
        
        System.out.println("Escriba su NIF:");
        this.setNIF(lector.nextLine());
        
        System.out.println("Escriba su contraseña:");
        this.setContraseña(lector.nextLine());
    }
    public static int comprobarSesionAdministrador(Biblioteca biblioteca){
        int posicion = 0;
        boolean inicioSesion = false;
        int i = 0;
        
        System.out.println("Inserta tu NIF y contraseña para iniciar sesión como Aministrador:");
        System.out.println("NIF:");
        String NIF = lector.nextLine();
        System.out.println("Contraseña de trabajador:");
        String contraseña = lector.nextLine();
        
        while(i<biblioteca.getListaPersonal().size() && !inicioSesion){
            if(biblioteca.getListaPersonal().get(i) instanceof Bibliotecario){
                if(((Bibliotecario)biblioteca.getListaPersonal().get(i)).getContraseña().equals(contraseña) 
                    && ((Bibliotecario)biblioteca.getListaPersonal().get(i)).getNIF().equals(NIF)){
                    posicion = 1;
                    System.out.println("Se realizó el inicio de sesión correctamente");
                    inicioSesion = true;
                    return posicion;
                }
            }
            i++;
        }
        if(!inicioSesion){
            System.out.println("No hay ningún Bibliotecario con esos datos, porfavor vuelvalo a intentar");
            posicion = 0;
        }
        return posicion;
        
    }
    
    public static void mostrarPersonal(ArrayList<Persona> listaPersonal){
        System.out.println("Estos son los Bibliotecarios que hay:");
        for(int i=0;i<listaPersonal.size(); i++){
            System.out.println(listaPersonal.get(i));
        }
    }

    @Override
    public void cambiarContraseña() {
        System.out.println("Escribe tu nueva contraseña como Administrador:");
        this.setContraseña(lector.nextLine());
        System.out.println("Contraseña actualizada con éxito.");
    }
}
