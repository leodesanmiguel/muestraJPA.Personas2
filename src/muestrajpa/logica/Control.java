/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import muestrajpa.persistencia.ControlJPA;
import muestrajpa.enumera.MedioDPago;

/**
 *
 * @author profl
 */
public class Control {

    ControlJPA ctrlJPA = new ControlJPA();

    public void crearPuestosSolos() {

        for (MedioDPago medio : MedioDPago.values()) {
            ctrlJPA.crearPuestosSolos(medio);
        }

    }

}
