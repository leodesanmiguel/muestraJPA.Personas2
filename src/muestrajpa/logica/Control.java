/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

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
    
    
}
