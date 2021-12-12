/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import muestrajpa.enumera.Cargo;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "puestos")
public class Puesto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPUESTO")
    private int idPuesto;

    @Enumerated(EnumType.ORDINAL)
    private Cargo suCargo;
    
    

    public Puesto() {

    }

    public Puesto( Cargo suCargo) {
        this.suCargo = suCargo;
    }

    public int getIdPuesto() {
        return idPuesto;
    }
    
    

    public Cargo getSuCargo() {
        return suCargo;
    }

    public void setSuCargo(Cargo suCargo) {
        this.suCargo = suCargo;
    }

    
    
    
}
