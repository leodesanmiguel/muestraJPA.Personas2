/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "empleados")
public class Empleado extends Persona implements Serializable {

    private double sueldo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPUESTO", nullable = false)
    private Puesto cargo;

    public Empleado() {

    }

    public Empleado(double sueldo, Puesto cargo,
            String nombre, String apellido, int dni,
            String paisOrigen, String celular, String email, Date fechaNacio) {
        super(nombre, apellido, dni, paisOrigen, celular, email, fechaNacio);
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public double getSueldo() {
        
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Puesto getCargo() {
        return cargo;
    }

    public void setCargo(Puesto cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado: " + cargo + " (" + sueldo + ")"
                + super.toString();
    }

}
