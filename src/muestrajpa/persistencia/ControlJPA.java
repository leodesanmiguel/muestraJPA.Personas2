/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.persistencia;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.List;
import muestrajpa.enumera.Cargo;
import muestrajpa.enumera.MedioDPago;
import muestrajpa.logica.FormaDPago;
import muestrajpa.logica.Puesto;

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

    public void crearFormasDPagoSolas(MedioDPago medio) {

        try {
            boolean cc = false;

            BigDecimal comis = BigDecimal.valueOf(medio.getComision() * 10000);
            comis = comis.divide(BigDecimal.valueOf(100));
            

            List<FormaDPago> formas = forpJPA.findFormaDPagoEntities();
            for (FormaDPago f : formas) {

                if (f.getMedios() == medio) {
                    System.out.println("COINCIDENCIA : " + f.getMedios());
                    cc = true;
                    break;
                }
                if (cc) {
                    break;
                }
            }
            if (!cc) {
                FormaDPago forma = new FormaDPago(medio);
                forpJPA.create(forma);
                System.out.println("GUARDÓ: " + medio.getMedio() + " (" + comis + "%)");

            }

        } catch (Exception e) {
            System.out.println("\n************  No se Creo la forma de Pago .....\n");

        }

    }

    public void crearPuestosSolas(Cargo puesto) {

        try {
            boolean cc = false;
            
            List<Puesto> puestos = puesJPA.findPuestoEntities();
            for (Puesto f : puestos) {
                if (f.getSuCargo() == puesto) {
                    System.out.println("Ya está "+ f.getIdPuesto() + ") " + f.getSuCargo());
                    cc = true;
                    break;
                }
                if (cc) {
                    break;
                }

            }
            if (!cc) {
                Puesto forma = new Puesto(puesto);
                puesJPA.create(forma);
                System.out.println("GUARDÓ: " + forma.getSuCargo() );

            }
        } catch (Exception e) {
            System.out.println("\n************ PROBLEMAS CON LOS PUESTOS SOLOS.....\n");

        }

    }

}
