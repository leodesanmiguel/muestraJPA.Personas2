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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente extends Persona implements Serializable {

    private String tipoCliente;

    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormaDPago> formasDPago;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> compras;
    
    
    public Cliente() {

    }

    public Cliente(String tipoCliente, Date fechaAlta,
             List<FormaDPago> formasDPago
            , String nombre, String apellido, int dni
             , String paisOrigen, String celular, String email,
             Date fechaNacio) {
        super(nombre, apellido, dni, paisOrigen, celular, email, fechaNacio);
        this.tipoCliente = tipoCliente;
        this.fechaAlta = fechaAlta;
        this.formasDPago = formasDPago;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<FormaDPago> getFormasDPago() {
        return formasDPago;
    }

    public void setFormasDPago(List<FormaDPago> formasDPago) {
        this.formasDPago = formasDPago;
    }

    public List<Venta> getCompras() {
        return compras;
    }

    public void setCompras(List<Venta> compras) {
        this.compras = compras;
    }

    
    
    
}
