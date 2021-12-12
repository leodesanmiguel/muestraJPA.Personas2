/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import muestrajpa.enumera.MedioDPago;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "formasdepago")
public class FormaDPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaDPago;

    @Enumerated(EnumType.ORDINAL)
    private MedioDPago medios;

    public FormaDPago() {

    }

    public FormaDPago(MedioDPago medios) {
        this.medios = medios;
    }

    public int getIdFormaDPago() {
        return idFormaDPago;
    }

    public MedioDPago getMedios() {
        return medios;
    }

    public void setMedios(MedioDPago medios) {
        this.medios = medios;
    }

}
