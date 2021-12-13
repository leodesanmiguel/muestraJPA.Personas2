/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.util.Date;
import muestrajpa.enumera.Cargo;
import muestrajpa.persistencia.ControlJPA;
import muestrajpa.enumera.MedioDPago;

/**
 *
 * @author profl
 */
public class Control {

    ControlJPA ctrlJPA = new ControlJPA();

    public void crearFormasDPagoSolos() {

        for (MedioDPago medio : MedioDPago.values()) {
            ctrlJPA.crearFormasDPagoSolas(medio);
        }

    }

    public void crearPuestosSolos() {

        for (Cargo puesto : Cargo.values()) {
            ctrlJPA.crearPuestosSolas(puesto);
        }

    }

    public void crearPersonaSolas() {

        Persona p1 = new Persona("Juan", "Castillo", 234565, "Argentino", "11258741", "", new Date(1987, 12, 11));
        ctrlJPA.crearPersonaSola(p1);
        Persona p2 = new Persona("Maria", "Alvarez", 12234565, "Vegano", "221258741", "", new Date(1977, 2, 1));
        ctrlJPA.crearPersonaSola(p2);
        Persona p3 = new Persona("Esteban", "Richetti", 32234565, "Salpicado", "33258741", "", new Date(1937, 10, 6));
        ctrlJPA.crearPersonaSola(p3);
        Persona p4 = new Persona("Rodrigo", "Gomez", 34234565, "Argentino", "44258741", "", new Date(1987, 1, 1));
        ctrlJPA.crearPersonaSola(p4);
        Persona p5 = new Persona("Laura", "Fernandez", 23234565, "Argentino", "55258741", "", new Date(2000, 8, 21));
        ctrlJPA.crearPersonaSola(p5);
        Persona p6 = new Persona("Estefania", "Hunt", 20234565, "Argentino", "66258741", "", new Date(2010, 12, 31));
        ctrlJPA.crearPersonaSola(p6);

        
    }

}
