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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import muestrajpa.enumera.Contratacion;

/**
 *
 * @author profl
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @Temporal(TemporalType.TIME)
    private Date horaVenta;

    @Enumerated(EnumType.ORDINAL)
    private Contratacion tipoContrato;

    private boolean estaPago;

    @ManyToOne(targetEntity = Paquete.class)
    @JoinColumn(name = "paqueteId")
    private Paquete paqueteId;

    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "idPersona")
    private Cliente idPersona;

    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "idEmpleado")
    private Empleado idEmpleado;

    public Venta() {

    }

    public Venta(int idVenta, Date fechaVenta, Date horaVenta,
            Contratacion tipoContrato, boolean estaPago,
            Paquete paquete, Cliente cliente, Empleado empleado) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.tipoContrato = tipoContrato;
        this.estaPago = estaPago;
        this.paqueteId = paquete;
        this.idPersona = cliente;
        this.idEmpleado = empleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Date horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Contratacion getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Contratacion tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

    public Paquete getPaquete() {
        return paqueteId;
    }

    public void setPaquete(Paquete paquete) {
        this.paqueteId = paquete;
    }

    public Cliente getCliente() {
        return idPersona;
    }

    public void setCliente(Cliente cliente) {
        this.idPersona = cliente;
    }

    public Empleado getEmpleado() {
        return idEmpleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.idEmpleado = empleado;
    }

}
