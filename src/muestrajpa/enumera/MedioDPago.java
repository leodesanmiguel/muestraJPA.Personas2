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
public enum MedioDPago {
        /**
     * Los medios de pago determinan la forma de pago y una comisión.
     *
     */
    EFECTIVO("Efectivo", 0.0),
    DEBITO("Débito", 0.03),
    CREDITO("Crédito", 0.09),
    MONEDERO("Monedero", 0.0),
    TRANSFERENCIA("Transferencia", 0.0245);

    private String medio;
    private double comision;

    private MedioDPago(String medio, double comision) {
        this.medio = medio;
        this.comision = comision;
    }

    public String getMedio() {
        return this.medio;

    }

    public double getComision() {
        return this.comision;
    }
}
