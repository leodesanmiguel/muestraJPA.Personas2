/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaquete;

    private double costoPaquete;

    @ManyToMany()
    List<Servicio> lsServicios;

    
    
    public Paquete() {

    }

    public Paquete(int idPaquete, double costoPaquete, List<Servicio> lsServicios) {
        this.idPaquete = idPaquete;
        this.costoPaquete = costoPaquete;
        this.lsServicios = lsServicios;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public double getCostoPaquete() {
        return costoPaquete;
    }

    public void setCostoPaquete(double costoPaquete) {
        this.costoPaquete = costoPaquete;
    }

    public List<Servicio> getLsServicios() {
        return lsServicios;
    }

    public void setLsServicios(List<Servicio> lsServicios) {
        this.lsServicios = lsServicios;
    }

    public int cantidadServicios() {
        return lsServicios.size();
    }
}
