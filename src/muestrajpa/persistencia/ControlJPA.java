/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestrajpa.persistencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import muestrajpa.enumera.Cargo;
import muestrajpa.enumera.MedioDPago;
import muestrajpa.logica.Cliente;
import muestrajpa.logica.Empleado;
import muestrajpa.logica.FormaDPago;
import muestrajpa.logica.Persona;
import muestrajpa.logica.Puesto;

/**
 *
 * @author profl
 */
public class ControlJPA {

    PersonaJpaController persJPA = new PersonaJpaController();
    FormaDPagoJpaController forpJPA = new FormaDPagoJpaController();
    ClienteJpaController clieJPA = new ClienteJpaController();
    PuestoJpaController puesJPA = new PuestoJpaController();
    EmpleadoJpaController emplJPA = new EmpleadoJpaController();

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
            Cliente cliente = new Cliente(tipoC, fechaAlta, lsForma,
                    p.getNombre(), p.getApellido(), p.getDni(),
                    p.getPaisOrigen(), p.getCelular(), p.getEmail(),
                    p.getFechaNacio());
            clieJPA.create(cliente);
            System.out.println("GUARDÓ: " + tipoC);

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

    public void crear1Empleado(Puesto pu, double sueldo, Persona pp) {
        try {
            Empleado emp = new Empleado(sueldo, pu,
                    pp.getNombre(), pp.getApellido(), pp.getDni(),
                    pp.getPaisOrigen(), pp.getCelular(), pp.getEmail(),
                    pp.getFechaNacio());
            emplJPA.create(emp);
            System.out.println("GUARDÓ empleado : " + pp.getApellido()
                    + " es " + pu.getSuCargo());

        } catch (Exception e) {
            System.out.println("\n*<<<  uuuu  no se creo el cliente >>>>\n");

        }

    }

}
