/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.principal;

import muestrajpa.logica.Control;

/**
 *
 * @author profl
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Control ctrl = new Control();
        
        ctrl.crearFormasDPagoSolos();
        ctrl.crearPuestosSolos();
        ctrl.crearPersonaSolas();
        
        ctrl.crearTresCliente(); 
        ctrl.crearTresEmpleadpos();
        
        
    }
    
}
