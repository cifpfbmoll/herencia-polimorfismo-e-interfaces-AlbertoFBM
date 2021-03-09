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
    private int librosReservados;
    // Constructor vacío

    public Usuario() {
        this.listaReservas = new ArrayList<Reserva>();
    }
    
    // Constructor con todos los parámetros, incluidos los de Persona

    public Usuario(int telefono, String direccion, int codigoPostal, String correo, String nombre, String apellido1, String apellido2, int edad, ArrayList<Reserva> listaReservas) {
        super(nombre, apellido1, apellido2, edad);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCodigoPostal(codigoPostal);
        this.setCorreo(correo);
        this.setListaReservas(listaReservas);
        this.setLibrosReservados(librosReservados);
        
    }
    
    

    public Usuario(Usuario copiaUsuario){
       this.setTelefono(copiaUsuario.getTelefono());
       this.setDireccion(copiaUsuario.getDireccion());
       this.setCodigoPostal(copiaUsuario.getCodigoPostal());
       this.setCorreo(copiaUsuario.getCorreo());
       this.setListaReservas(copiaUsuario.getListaReservas());
       this.setLibrosReservados(copiaUsuario.getLibrosReservados());
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

    public int getLibrosReservados() {
        return librosReservados;
    }

    public void setLibrosReservados(int librosReservados) {
        this.librosReservados = librosReservados;
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
    public static int comprobarSesionUsuario(Biblioteca biblioteca){
        int posicion = 0;
        boolean inicioSesion = false;
        int i = 0;
        
        System.out.println("Inserta tu teléfono y tu correo para iniciar sesión como Usuario:");
        System.out.println("Teléfono:");
        int telefono = lector.nextInt();
        lector.nextLine();
        
        System.out.println("Correo:");
        String correo = lector.nextLine();
        
        while(i<biblioteca.getListaUsuarios().size() && !inicioSesion){
            if(biblioteca.getListaUsuarios().get(i) instanceof Usuario){
                if(((Usuario)biblioteca.getListaUsuarios().get(i)).getTelefono()==telefono
                    && ((Usuario)biblioteca.getListaUsuarios().get(i)).getCorreo().equals(correo)){
                    posicion = 1;
                    System.out.println("Se realizó el inicio de sesión correctamente");
                    inicioSesion = true;
                    return posicion; 
                }
            }
            i++;
        }
        if(!inicioSesion){
            System.out.println("No hay ningún Usuario con esos datos, porfavor escríbalos de nuevo.");
            posicion = 0;
            return posicion;
        }
        return posicion;
    }

    public static void mostrarUsuarios(ArrayList<Usuario> listaUsuarios){
        System.out.println("Estos son los usuarios que hay:");
        for(int i=0; i<listaUsuarios.size(); i++){
            System.out.println(listaUsuarios.get(i));
        }
    }  

    public void mostrarLibrosReservados(){
        for(int i=0; i<this.getListaReservas().size(); i++){
            this.getListaReservas().get(i);
        }
    }
    
    @Override
    public void cambiarContraseña() {
        System.out.println("Quieres cambiar tu número de teléfono o tu correo?");
        System.out.println("                 1.Teléfono"                       );
        System.out.println("                 2.Correo"                         );
        byte opcion = lector.nextByte();
        
        switch (opcion) {
            case 1:
                System.out.println("Escribe tu nuevo teléfono:");
                this.setTelefono(lector.nextInt());
                lector.nextLine();
                System.out.println("Teléfono actualizado con éxito.");
                break;
            case 2:
                System.out.println("Pon tu nuevo correo:");
                this.setCorreo(lector.nextLine());
                System.out.println("Correo actualizado con éxito");
                break;
            default:
                System.out.println("Pon una opcion correcta:");
                opcion = lector.nextByte();
                break;
        }
    }
    
}
