/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Compact
 */
public class NodoCurso {
    private NodoCurso siguiente;
    private NodoEstudiante inicioestudiante;
    private int codigo;
    private String nombre;
    public NodoCurso(int codigo,String nombre ){
        siguiente =null;
        inicioestudiante=null;
        this.codigo=codigo;
        this.nombre=nombre;
    }

    public NodoCurso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCurso siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEstudiante getInicioestudiante() {
        return inicioestudiante;
    }

    public void setInicioestudiante(NodoEstudiante inicioestudiante) {
        this.inicioestudiante = inicioestudiante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
