/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="personas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    private String nombre;
    private String apellido;
    private int dni;
    private String paisOrigen;
    private String celular;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fechaNacio;

    public Persona() {

    }

    public Persona( String nombre, String apellido, int dni, String paisOrigen, String celular, String email, Date fechaNacio) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.paisOrigen = paisOrigen;
        this.celular = celular;
        this.email = email;
        this.fechaNacio = fechaNacio;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacio() {
        return fechaNacio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNacio(Date fechaNacio) {
        this.fechaNacio = fechaNacio;
    }

    @Override
    public String toString() {
        return "\n\n Persona: " + nombre + " " + apellido 
                + " (" + idPersona + "-"+ dni + " )";

    }

    
}