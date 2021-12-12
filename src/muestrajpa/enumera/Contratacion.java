/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.enumera;

/**
 *
 * @author profl
 */
public enum Contratacion {
    IND("Serivio Individual"),
    PAQ("paquete de Servidios");

    private String tipo;

    private Contratacion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoContratacion() {
        return this.tipo;

    }
}
