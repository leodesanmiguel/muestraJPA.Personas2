/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.enumera;

/**
 *
 * @author profl
 */
public enum Servicios {
HOTEL("Hotel por noche/s"), 
ALQUILER("Alquiler de auto"), 
BUS("Pasajes de colectivo"), 
AVION("Pasajes de avión"), 
TREN("Pasajes de tren"), 
EXCURSION("Excursiones"),
EVENTO("Entradas a Eventos");

String nomServicio;

private Servicios(String nomServicio) {
        this.nomServicio = nomServicio;
        
    }

    public String getServicio() {
        return this.nomServicio;

    }
}
