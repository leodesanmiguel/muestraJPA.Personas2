/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.persistencia;

import muestrajpa.enumera.MedioDPago;
import muestrajpa.logica.FormaDPago;

/**
 *
 * @author profl
 */
public class ControlJPA {
    
    PersonaJpaController persJPA = new PersonaJpaController();
    FormaDPagoJpaController forpJPA = new FormaDPagoJpaController();
    ClienteJpaController clieJPA = new ClienteJpaController();
    PuestoJpaController puesJPA = new PuestoJpaController();
    EmpleadoJpaController emplJPA = new EmpleadoJpaController();

    public void crearPuestosSolos(MedioDPago medio) {
        
        try {
            
            FormaDPago forma = new FormaDPago(medio);
            
            forpJPA.create(forma);
            
        } catch (Exception e) {
            System.out.println("\n************  No se Creo la forma de Pago .....\n");
            
        }
        
    }

    
    
}
