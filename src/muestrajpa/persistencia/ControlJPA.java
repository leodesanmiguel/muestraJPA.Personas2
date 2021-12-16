/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.persistencia;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import muestrajpa.enumera.Cargo;
import muestrajpa.enumera.Contratacion;
import muestrajpa.enumera.MedioDPago;
import muestrajpa.enumera.Servicios;
import muestrajpa.logica.Cliente;
import muestrajpa.logica.Empleado;
import muestrajpa.logica.FormaDPago;
import muestrajpa.logica.Paquete;
import muestrajpa.logica.Persona;
import muestrajpa.logica.Puesto;
import muestrajpa.logica.Servicio;
import muestrajpa.logica.Venta;

/**
 *
 * @author profl
 */
public class ControlJPA {

    PersonaJpaController persJPA = new PersonaJpaController();
    FormaDPagoJpaController forpJPA = new FormaDPagoJpaController();
    ClienteJpaController clieJPA = new ClienteJpaController();
    ServicioJpaController servJPA = new ServicioJpaController();
    PaqueteJpaController paquJPA = new PaqueteJpaController();
    PuestoJpaController puesJPA = new PuestoJpaController();
    EmpleadoJpaController emplJPA = new EmpleadoJpaController();
    VentaJpaController ventJPA = new VentaJpaController();

    public void crearFormasDPagoSolas(MedioDPago medio) {

        try {
            boolean cc = false;

            BigDecimal comis = BigDecimal.valueOf(medio.getComision() * 10000);
            comis = comis.divide(BigDecimal.valueOf(100));

            List<FormaDPago> formas = forpJPA.findFormaDPagoEntities();
            for (FormaDPago f : formas) {

                if (f.getMedios() == medio) {
                    System.out.println("COINCIDENCIA : " + f.getMedios());
                    cc = true;
                    break;
                }
                if (cc) {
                    break;
                }
            }
            if (!cc) {
                FormaDPago forma = new FormaDPago(medio);
                forpJPA.create(forma);
                System.out.println("GUARDÓ: "
                        + medio.getMedio() + " (" + comis + "%)");

            }

        } catch (Exception e) {
            System.out.println("\n****"
                    + "********  No se Creo la forma de Pago .....\n");

        }

    }

    public void crearPuestosSolas(Cargo puesto) {

        try {
            boolean cc = false;

            List<Puesto> puestos = puesJPA.findPuestoEntities();
            for (Puesto f : puestos) {
                if (f.getSuCargo() == puesto) {
                    System.out.println("Ya está "
                            + f.getIdPuesto() + ") " + f.getSuCargo());
                    cc = true;
                    break;
                }
                if (cc) {
                    break;
                }

            }
            if (!cc) {
                Puesto forma = new Puesto(puesto);
                puesJPA.create(forma);
                System.out.println("GUARDÓ: " + forma.getSuCargo());

            }
        } catch (Exception e) {
            System.out.println("\n*****"
                    + "******* PROBLEMAS CON LOS PUESTOS SOLOS.....\n");

        }

    }

    public void crearPersonaSola(Persona p) {

        try {
            boolean cc = false;

            List<Persona> pp = persJPA.findPersonaEntities();
            for (Persona f : pp) {
                if (f.getDni() == p.getDni()) {
                    System.out.println("Ya está "
                            + f.getApellido() + ", " + f.getNombre());
                    cc = true;
                    break;
                }
                if (cc) {
                    break;
                }

            }
            if (!cc) {
                persJPA.create(p);
                System.out.println("GUARDÓ: " + p);

            }
        } catch (Exception e) {
            System.out.println("\n* * * *  NO SE GUARDÓ LA PERSONA .....\n");

        }

    }

    public FormaDPago obtenerUnaForma(MedioDPago m) {
        try {
            List<FormaDPago> formas = forpJPA.findFormaDPagoEntities();
            for (FormaDPago f : formas) {
                if (f.getMedios() == m) {
                    return f;
                }
            }
            return formas.get(0);
        } catch (Exception e) {
            System.out.println("\n*NO SE "
                    + "QUE PASO CON LA BUQUEDA DE LA FORMA\n");

        }
        return null;

    }

    public Persona obtenerPersona(int dni) {
        try {
            List<Persona> pp = persJPA.findPersonaEntities();
            for (Persona f : pp) {
                if (f.getDni() == dni) {
                    return f;
                }
            }
            return null;

        } catch (Exception e) {
            System.out.println("\n* * * *  NO SE   "
                    + "*E*N*C*O*N*T*R*O*   A LA PERSONA .....\n");

        }
        return null;
    }

    public void crear1Cliente(String tipoC, Date fechaAlta,
            List<FormaDPago> lsForma, Persona p) {
        try {
            Cliente cli = new Cliente();
            cli.setApellido(p.getApellido());
            cli.setCelular(p.getCelular());
            //cli.setCompras(null);
            cli.setDni(p.getDni());
            cli.setEmail(p.getEmail());
            cli.setNombre(p.getNombre());
            cli.setFechaAlta(fechaAlta);
            cli.setFormasDPago(lsForma);
            cli.setTipoCliente(tipoC);

            clieJPA.create(cli);
            System.out.println("GUARDÓ Cliente: " + tipoC
                    + "\n " + p);

        } catch (Exception e) {
            System.out.println("\n*<<<  uuuu  no se creo el cliente >>>>\n");

        }

    }

    public Puesto obtenerPuesto(Cargo c) {
        try {
            List<Puesto> formas = puesJPA.findPuestoEntities();
            for (Puesto f : formas) {
                if (f.getSuCargo() == c) {
                    return f;
                }
            }
            return formas.get(0);
        } catch (Exception e) {
            System.out.println("\n*NO SE "
                    + "QUE PASO CON LA BUQUEDA DEl /P/U/E/S/T/O/ \n");

        }
        return null;
    }

    public void crear1Empleado(int idEmpleado, Puesto pu,
            double sueldo, Persona p) {
        try {
            Empleado emp = new Empleado();
            emp.setApellido(p.getApellido());
            emp.setIdEmpleado(idEmpleado);
            emp.setCargo(pu);
            emp.setSueldo(sueldo + Math.random() * sueldo * 2);
            emp.setNombre(p.getNombre());
            emp.setDni(p.getDni());

            emplJPA.create(emp);
            System.out.println("GUARDÓ EMPLEADO  : " + pu.getSuCargo()
                    + p);

        } catch (Exception e) {
            System.out.println("\n*<<<  uuuu  no se creo el cliente >>>>\n");

        }

    }

    public void crear1Servicio(Servicios s) {

        try {
            boolean cc = false;

            List<Servicio> puestos = servJPA.findServicioEntities();
            for (Servicio f : puestos) {
                if (f.getServ() == s) {
                    System.out.println("Ya está "
                            + f.getNombre() + "Id:" + f.getCodigoServicio());
                    cc = true;
                    break;
                }
                if (cc) {
                    break;
                }

            }
            if (!cc) {
                Servicio forma = new Servicio();
                forma.setCostoServicio(Math.random() * 10000);
                forma.setDescripciónBreve("DEscripcion breve breve muy breve");
                
                
                int mes = (int) Math.round(Math.random() * 12);
                int dia = (int) Math.round(Math.random() * 28);
                LocalDate fe = LocalDate.of(2021, mes, dia);

                ZoneId dZ = ZoneId.systemDefault();
                Date fe1 = Date.from(fe.atStartOfDay(dZ).toInstant());

                forma.setFechaServicio(fe1);
                forma.setServ(s);
                forma.setNombre(s.name());
                servJPA.create(forma);
                System.out.println("GUARDÓ: " + forma.getNombre());
            }
        } catch (Exception e) {
            System.out.println("\n*****"
                    + "******* PROBLEMAS CON LOS PUESTOS SOLOS.....\n");

        }

    }

    public void Crear1Paquete(int[] lsServ) {

        try {
            // 1) Lista de Servicios
            double suma = 0;
            List<Servicio> lista = new ArrayList<>();
            for (int i = 0; i < lsServ.length; i++) {
                Servicio serv = servJPA.findServicio(lsServ[i]);
                if (serv != null) {
                    lista.add(serv);
                    suma += serv.getCostoServicio();
                }
            }

            Paquete pak = new Paquete();
            pak.setLsServicios(lista);
            pak.setCostoPaquete((lista.size() == 1) ? suma : (suma * 0.9));
            paquJPA.create(pak);
            System.out.println("GUARDÓ PAQUETE NRO: " + pak.getIdPaquete());

        } catch (Exception e) {
            System.out.println("\n*****"
                    + "******* PROBLEMAS CON LOS PUESTOS SOLOS.....\n");

        }

    }

    public void crear1Venta(int idE, int idC, int idP, Date feti) {

        try {
            //  1) Empleado
            Empleado emple = new Empleado();
            emple = emplJPA.findEmpleado(idE);

            //  2) Cliente
            Cliente clie = new Cliente();
            clie = clieJPA.findCliente(idC);

            //  3) Paquete
            Paquete paket = new Paquete();
            paket = paquJPA.findPaquete(idP);

            //  4) Fecha y Hora
            Date fec = new Date(feti.getDate());
            Date tim = new Date(feti.getTime());

            //  5) cargar la VENTA
            Venta vta = new Venta();
            vta.setCliente(clie);
            vta.setEmpleado(emple);
            vta.setPaquete(paket);

            if ((idC % 2) == 0) {
                vta.setEstaPago(true);
            } else {
                vta.setEstaPago(false);
            }

            vta.setTipoContrato(verContratacion(paket));

            ventJPA.create(vta);
            System.out.println("GUARDÓ la VENTA ");

        } catch (Exception e) {
            System.out.println("\n*****"
                    + "******* NOOOO  NO GUARDA LA VENTA .....\n");

        }

    }

    private Contratacion verContratacion(Paquete paket) {
        System.out.println("Servicios " + paket.getLsServicios().size());

        return (paket.getLsServicios().size() == 1)
                ? Contratacion.IND : Contratacion.PAQ;

    }

}
