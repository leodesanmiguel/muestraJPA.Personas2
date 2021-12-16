/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import muestrajpa.enumera.Servicios;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "serviciosicio")
public class Servicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoServicio; 
    private String nombre ;
    private String descripciónBreve; 
    private String destinoServicio; 
    
    @Temporal(TemporalType.DATE)
    private Date fechaServicio; 
    
    private double costoServicio;
    
    @Enumerated(EnumType.ORDINAL)
    private Servicios servicios;
    
    public Servicio(){
        
    }

    public Servicio( String nombre, String descripciónBreve, String destinoServicio, Date fechaServicio, double costoServicio, Servicios servicios) {
        
        this.nombre = nombre;
        this.descripciónBreve = descripciónBreve;
        this.destinoServicio = destinoServicio;
        this.fechaServicio = fechaServicio;
        this.costoServicio = costoServicio;
        this.servicios = servicios;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripciónBreve() {
        return descripciónBreve;
    }

    public void setDescripciónBreve(String descripciónBreve) {
        this.descripciónBreve = descripciónBreve;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public Servicios getServ() {
        return servicios;
    }

    public void setServ(Servicios servicios) {
        this.servicios = servicios;
    }
    
    
}
