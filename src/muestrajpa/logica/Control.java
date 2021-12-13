/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public void crearTresCliente() {
        int[] pp = new int[]{32234565, 34234565, 20234565};

        for (int i = 0; i < pp.length; i++) {
            crear1cliente(pp[i]);
        }

    }

    private void crear1cliente(int dni1) {

        //  PERSONA
        Persona pp = obtener1Persona(dni1);
        if (pp != null) {
            //  FORMA DE PAGO: 1
            FormaDPago forma1 = obtenerUnaFormadepago(MedioDPago.EFECTIVO);

            if (forma1.getMedios() != MedioDPago.EFECTIVO) {
                System.out.println("NO ENCONTRÓ EL MEDIO DE PAGO " + MedioDPago.EFECTIVO);
                System.out.println("Se asigna --> " + forma1.getMedios());
            }
            
            //  1) Tipo de cliente
            String tipoC = "Pagador " + forma1.getMedios().toString();
            
            //  2) Fecha de Alta
            Date fechaAlta = new Date();
            
            //  3) Lista de Formas de pago
            List<FormaDPago> lsForma = new ArrayList<>();
            lsForma.add(forma1);
            
            ctrlJPA.crear1Cliente(tipoC, fechaAlta, lsForma, pp);
            
            
            
            
        } else {
            System.out.println("NO ENCONTRÉ A LA PERSONA con el DNI: " + dni1 + "******");
        }

    }

    public void crearTresEmpleadpos() {

    }

    private FormaDPago obtenerUnaFormadepago(MedioDPago m) {

        return ctrlJPA.obtenerUnaForma(m);

    }

    private Persona obtener1Persona(int dni) {

        return ctrlJPA.obtenerPersona(dni);
    }

}
