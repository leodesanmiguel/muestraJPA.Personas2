/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "empleados")
public class Empleado extends Persona implements Serializable {

    
    int idEmpleado;
    private double sueldo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPUESTO", nullable = false)
    private Puesto cargo;

    @OneToMany( cascade = CascadeType.ALL,
             orphanRemoval = true)
    private List<Venta> ventas;

    public Empleado() {

    }

    public Empleado(int idEmpleado, double sueldo, Puesto cargo,
            String nombre, String apellido, int dni,
            String paisOrigen, String celular, String email, Date fechaNacio) {
        super(nombre, apellido, dni, paisOrigen, celular, email, fechaNacio);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public List<Venta> getIdVenta() {
        return ventas;
    }

    public void setIdVenta(List<Venta> ventas) {
        this.ventas = ventas;
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
