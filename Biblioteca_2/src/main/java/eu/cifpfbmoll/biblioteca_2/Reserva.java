/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca_2;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author asix
 */
public class Reserva {
    
    // Atributos de Reserva
    private Libro libro;
    private LocalDate fecha;
    private LocalTime hora;

    // Constructor vacío
    public Reserva() {
    }

    // Constructor con todos los parámetros
    public Reserva(Libro libro, LocalDate fecha, LocalTime hora) {
        this.libro = libro;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    // Constructor copia
    
    public Reserva(Reserva copiaReserva){
        this.setLibro(copiaReserva.getLibro());
        this.setFecha(copiaReserva.getFecha());
        this.setHora(copiaReserva.getHora());
    }
    
    // Getters / Setters

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
 
}
