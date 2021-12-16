/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import muestrajpa.enumera.Cargo;
import muestrajpa.persistencia.ControlJPA;
import muestrajpa.enumera.MedioDPago;
import muestrajpa.enumera.Servicios;

/**
 *
 * @author profl
 */
public class Control {

    ControlJPA ctrlJPA = new ControlJPA();

    private Date oFecha(int i) {

        int ano = 2021;
        switch (i) {
            case 0:
                ano = (int) Math.round(1900 + Math.random() * 100);
                break;
            case 1:
                ano = (int) Math.round(2000 + Math.random() * 15);
                break;

        }

        int mes = (int) Math.round(1+Math.random() * 12);
        int dia = (int) Math.round(1+Math.random() * 28);
        LocalDate fe = LocalDate.of(ano, mes, dia);
        ZoneId dZ = ZoneId.systemDefault();
        return Date.from(fe.atStartOfDay(dZ).toInstant());

    }

    public void crearFormasDPagoSolos() {

        for (MedioDPago medio : MedioDPago.values()) {
            ctrlJPA.crearFormasDPagoSolas(medio);
        }

    }

    public void crearPuestosSolos() {

        for (Cargo puesto : Cargo.values()) {
            ctrlJPA.crearPuestosSolas(puesto);
        }

    }

    public void crearPersonaSolas() {

        Persona p1 = new Persona("Juan", "Castillo", 12345678, "Developer",
                 "11258741", "", oFecha(0));
        ctrlJPA.crearPersonaSola(p1);
        Persona p2 = new Persona("Maria", "Alvarez", 23456789, "Vegano",
                 "221258741", "", oFecha(0));
        ctrlJPA.crearPersonaSola(p2);
        Persona p3 = new Persona("Esteban", "Richetti", 20202020, "Salpicado",
                 "33258741", "", oFecha(0));
        ctrlJPA.crearPersonaSola(p3);
        Persona p4 = new Persona("Rodrigo", "Gomez", 30303030, "Argentino",
                 "44258741", "", oFecha(0));
        ctrlJPA.crearPersonaSola(p4);
        Persona p5 = new Persona("Laura", "Fernandez", 40404040, "Argentino",
                 "55258741", "", oFecha(0));
        ctrlJPA.crearPersonaSola(p5);
        Persona p6 = new Persona("Estefania", "Hunt", 10101010, "Argentino",
                 "66258741", "", oFecha(0));
        ctrlJPA.crearPersonaSola(p6);

    }

    public void crearTresCliente() {
        int[] pp = new int[]{20202020, 30303030, 10101010};

        for (int i = 0; i < pp.length; i++) {
            crear1cliente(pp[i]);
        }

    }

    private void crear1cliente(int dni1) {

        //  PERSONA
        Persona pp = obtener1Persona(dni1);
        if (pp != null) {
            //  FORMA DE PAGO: 1
            FormaDPago forma1 = obtenerUnaFormadepago(MedioDPago.EFECTIVO);

            if (forma1.getMedios() != MedioDPago.EFECTIVO) {
                System.out.println("NO ENCONTRÓ EL MEDIO DE PAGO " + MedioDPago.EFECTIVO);
                System.out.println("Se asigna --> " + forma1.getMedios());
            }

            //  1) Tipo de cliente
            String tipoC = "Pagador " + forma1.getMedios().toString();

            //  2) Fecha de Alta
            Date fechaAlta = oFecha(1);

            //  3) Lista de Formas de pago
            List<FormaDPago> lsForma = new ArrayList<>();
            lsForma.add(forma1);

            ctrlJPA.crear1Cliente(tipoC, fechaAlta, lsForma, pp);

        } else {
            System.out.println("NO ENCONTRÉ A LA PERSONA con el DNI: " + dni1 + "******");
        }

    }

    public void crearTresEmpleadpos() {
        int[] pp = new int[]{40404040, 12345678, 23456789};

        for (int i = 0; i < pp.length; i++) {
            crear1Empleado(pp[i]);
        }
    }

    private void crear1Empleado(int dni1) {

        //  PERSONA
        Persona pp = obtener1Persona(dni1);
        if (pp != null) {

            //  1)  Puesto del Empleado
            Puesto pu = obtenerPuesto(Cargo.VENDEDOR);

            //  2) Tipo de SUELDO       VENDEDOR, JEFE, ADMIN
            double[] sueldos = new double[]{65000, 74500, 125500};
            double sueldo = sueldos[pu.getSuCargo().ordinal()];

            ctrlJPA.crear1Empleado(dni1, pu, sueldo, pp);

        } else {
            System.out.println("NO ENCONTRÉ A LA PERSONA con el DNI: " + dni1 + "******");
        }

    }

    private FormaDPago obtenerUnaFormadepago(MedioDPago m) {

        return ctrlJPA.obtenerUnaForma(m);

    }

    private Persona obtener1Persona(int dni) {

        return ctrlJPA.obtenerPersona(dni);
    }

    private Puesto obtenerPuesto(Cargo c) {

        return ctrlJPA.obtenerPuesto(c);
    }

    public void crearServiciosSolos() {

        for (Servicios puesto : Servicios.values()) {
            ctrlJPA.crear1Servicio(puesto);
        }

    }

    public void crearPaquetesvarios() {

        int[] lsServ1 = new int[]{1, 2, 3};
        int[] lsServ2 = new int[]{1, 2, 4};
        int[] lsServ3 = new int[]{1, 2, 4, 6, 7};
        ctrlJPA.Crear1Paquete(lsServ1);
        ctrlJPA.Crear1Paquete(lsServ2);
        ctrlJPA.Crear1Paquete(lsServ3);

    }

    public void crearVariasVentas() {

        int[] emplea = new int[]{1, 3};
        int[] client = new int[]{1, 2, 3, 2};
        int[] paquet = new int[]{1, 3, 2, 1};

        ArrayList<Date> fechas = new ArrayList<>();
        
        fechas.add(oFecha(2));
        fechas.add(oFecha(2));
        fechas.add(oFecha(2));
        fechas.add(oFecha(2));

        for (int j = 0; j < client.length - 2; j++) {
            ctrlJPA.crear1Venta(emplea[0], client[j], paquet[j], fechas.get(j));
            ctrlJPA.crear1Venta(emplea[1], client[j + 2], paquet[j + 2], fechas.get(j + 2));
        }

    }

}
