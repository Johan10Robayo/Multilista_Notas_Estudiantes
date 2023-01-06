/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Compact
 */
import javax.swing.JOptionPane;

public class Multilista implements Imultilista {

    private NodoCurso cabecera;

    public Multilista() {
        cabecera = null;

    }

    public NodoCurso getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoCurso cabecera) {
        this.cabecera = cabecera;
    }

    @Override
    public void insertarcurso(NodoCurso curso, int codigo, String nombre) {//recibo un nodocurso porque primero lo busco para saber si está,
        //porque no se puede insertar un curso con códigos y nombres iguales  
        NodoCurso nuevo = new NodoCurso(codigo, nombre);
        if (cabecera == null) {//se inserta el primero, único dato
            cabecera = nuevo;
        } else {
            if (curso == null) {//me aseguro de que no hayan cursos con el mismo nombre o código, 
                NodoCurso ant = null;
                NodoCurso actual = cabecera;
                while (actual.getSiguiente() != null && actual.getCodigo() < nuevo.getCodigo()) {
                    ant = actual;
                    actual = actual.getSiguiente();
                }
                if (actual.getSiguiente() == null && actual.getCodigo() < nuevo.getCodigo()) {// se inserta a lo ultimo o al inicio cuando sólo hay un dato
                    actual.setSiguiente(nuevo);
                } else {
                    if (ant == null) {//se inserta antes del primero
                        nuevo.setSiguiente(actual);
                        cabecera = nuevo;
                    } else {//en medio
                        nuevo.setSiguiente(actual);
                        ant.setSiguiente(nuevo);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "el curso " + nombre + " con el código " + codigo + " ya existe ");
            }

        }

    }

    @Override
    public void insertarestudiante(NodoCurso curso, NodoEstudiante est, int codigo, String nombre) {//recibi estudiante, curso para saber si estan,
        //no pueden haber estudiantes con el mismo nombre en un curso
        NodoEstudiante aux = new NodoEstudiante(codigo, nombre);
        if (curso != null) {// si el curso existe en la multilista
            if (curso.getInicioestudiante() == null) {//se inserta el estudiante cuando el inicio del estudiante es nulo , es decir queda de primero 
                curso.setInicioestudiante(aux);
            } else {
                if (est == null) {// me aseguro de que el esudiane no esté, para que no queden nombres repetidos
                    NodoEstudiante ant = null;
                    NodoEstudiante actual = curso.getInicioestudiante();
                    while (actual.getSiguiente() != null && actual.getCodigo() < aux.getCodigo()) {//recorro la lista de estudiantes 
                        ant = actual;
                        actual = actual.getSiguiente();
                    }
                    if (actual.getSiguiente() == null && actual.getCodigo() < aux.getCodigo()) {//se inserta el estudiante  a lo ultimo o al inicio cuando sólo hay un dato
                        actual.setSiguiente(aux);
                    } else {
                        if (ant == null) {//se inserta el estudiante  antes del primero
                            aux.setSiguiente(actual);
                            curso.setInicioestudiante(aux);//cambia el inicio de estudiante 
                        } else {//se inserta el estudiante en medio 
                            aux.setSiguiente(actual);
                            ant.setSiguiente(aux);
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "el estudiante " + nombre + " con el código " + codigo + " ya existe en el curso " + curso.getNombre() + " con el código" + curso.getCodigo());
                }
            }
        }
    }

    @Override
    public void insetarnota(NodoCurso curso, NodoEstudiante est, int cohorte, double nota) {

        NodoNotas aux = new NodoNotas(nota, cohorte);
        if (est != null && curso != null) {//valido
            if (est.getInicionotas() == null) {
                est.setInicionotas(aux);//inserto una nota por primera vez
            } else {
                NodoNotas ant = null;
                NodoNotas actual = est.getInicionotas();
                while (actual.getSiguiente() != null && actual.getCohorte() < cohorte) {//recorro la lista de notas
                    ant = actual;
                    actual = actual.getSiguiente(); 
                    }
                while(actual.getSiguiente() != null && actual.getNota() <nota) {//recorro la lista de notas porque inserto 
                    //en orden de cohorete, después de notas
                    ant = actual;
                    actual = actual.getSiguiente(); 
                    }
                //evaluo las salidas del while

                if (actual.getSiguiente() == null && actual.getCohorte() < aux.getCohorte()) {// se inserta la nota a lo ultimo 
                    actual.setSiguiente(aux);
                } else {
                    if (ant == null) {//se inserta la nota antes del primero 
                        aux.setSiguiente(actual);
                        est.setInicionotas(aux);//el inicio de las notas cambia 
                    } else {//se inserta la nota en medio de dos nodos
                        ant.setSiguiente(aux);
                        aux.setSiguiente(actual);
                    }

                }
            }
        }
    }

    @Override
    public NodoCurso extraercurso(NodoCurso curso) {
        if (cabecera != null) {//me aseguro de que no esté vacio, para extraer

            if (curso != null) {
                if (curso == cabecera) {// si está de primeras 
                    cabecera = cabecera.getSiguiente();
                    return curso;
                } else {// está en medio o al final 
                    NodoCurso ant = cabecera;
                    while (ant.getSiguiente() != curso) {//utilizo una referencia al anterior para extraer curso, recorro hasta encontrar el anterior
                        ant = ant.getSiguiente();
                    }
                    ant.setSiguiente(curso.getSiguiente());
                    return curso;
                }
            } else {
                return null;
            }
        } else {

            return null;
        }

    }

    @Override
    public NodoEstudiante extraerestudiante(NodoCurso curso, NodoEstudiante est) {

        if (est != null && curso != null) {
            NodoEstudiante inicur = curso.getInicioestudiante();
            if (est == inicur) {
                curso.setInicioestudiante(inicur.getSiguiente());// si se extrae el inicio de la cabecera, esta avanza
                return est;
            } else {//está en medio o al final 
                while (inicur.getSiguiente() != est) {//utilizo una referencia al anterior, para poder extraer estudiante, 
                    //recorro hasta encontrar el anterior
                    inicur = inicur.getSiguiente();
                }
                inicur.setSiguiente(est.getSiguiente());
                return est;
            }

        } else {
            return null;
        }

    }

    @Override
    public NodoNotas extraernota(NodoCurso curso, NodoEstudiante est, int cohorte, double nota) {
        if (curso != null && est != null) {
            NodoNotas ininota = est.getInicionotas();
            if (cohorte == ininota.getCohorte() && nota == ininota.getNota()) {//extrae al inicio
                est.setInicionotas(ininota.getSiguiente());
                return ininota;
            } else {
                NodoNotas ant = null;
                NodoNotas actual = est.getInicionotas();
                while (actual.getSiguiente() != null && actual.getCohorte() <cohorte ) {
                    ant = actual;
                    actual = actual.getSiguiente();
                }
                
                while(actual.getSiguiente() != null && actual.getNota() <nota) {//recorro la lista de notas porque extraigo
                    //en orden de cohorete, después de notas
                    ant = actual;
                    actual = actual.getSiguiente(); 
                    }
                //evaluo las salidas del while 

                //extraigo en medio o al final 
                if (actual.getCohorte() == cohorte && actual.getNota()==nota&&ant != null) {
                    ant.setSiguiente(actual.getSiguiente());
                    return actual;
                }
                return null;

            }
        }

        return null;
    }

    @Override
    public NodoCurso buscarcurso(int codigo, String nombre) {
        if (cabecera != null) {
            NodoCurso actual = cabecera;

            while (actual.getSiguiente() != null && actual.getCodigo() < codigo) {//recorro la lista
                actual = actual.getSiguiente();
            }
            //evaluo las salidas del while
            if (actual.getCodigo() == codigo && actual.getNombre().equals(nombre)) {
                return actual;
            } else {
                return null;
            }
        }
        return null;

    }

    @Override
    public NodoEstudiante buscarestudiante(NodoCurso curso, int codigo, String nombre) {//recibo una referencia a un objeto de curso porque primero lo busco 

        if (curso != null) {//si el curso está es diferente de nulo, entonces se busca el estudiante 
            if (curso.getInicioestudiante() != null) {//me aseguro de que el inicio de la lista de estudiantes no sea nula o vacía,luego busco el estudiante 
                NodoEstudiante actual = curso.getInicioestudiante();
                while (actual.getSiguiente() != null && actual.getCodigo() < codigo) {//recorro la lista
                    actual = actual.getSiguiente();
                }
                //evaluo las salidas del while
                if (actual.getCodigo() == codigo && actual.getNombre().equals(nombre)) {
                    return actual;
                } else {
                    return null;
                }

            }
            return null;
        }

        return null;

    }

    @Override
    public void mostrarmultilista() {
        if (cabecera != null) {
            NodoCurso aux1 = cabecera;
            while (aux1 != null) {
                System.out.println("....................CURSO:  " + aux1.getNombre() + "  CÓDIGO:  " + aux1.getCodigo() + "...........................");

                NodoEstudiante aux2 = aux1.getInicioestudiante();
                while (aux2 != null) {

                    System.out.println("NOMBRE: " + aux2.getNombre() + "  CÓDIGO: " + aux2.getCodigo());

                    NodoNotas aux3 = aux2.getInicionotas();
                    while (aux3 != null) {
                        System.out.println("NOTA: " + aux3.getNota() + "   COHORTE: " + aux3.getCohorte());
                        aux3 = aux3.getSiguiente();
                    }
                    aux2 = aux2.getSiguiente();
                    System.out.println("\n ");
                }
                System.out.println("\n ");

                aux1 = aux1.getSiguiente();
            }

        } else {

            JOptionPane.showMessageDialog(null, "la multilista está vacía, por lo tanto no se puede mostrar");
        }
        System.out.println("\n *****************************************************************************************************");
    }

}
