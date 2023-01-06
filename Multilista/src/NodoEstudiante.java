/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Compact
 */
public class NodoEstudiante {
    private NodoEstudiante siguiente;
    private NodoNotas inicionotas;
    private int codigo;
    private  String nombre;
    public NodoEstudiante(int codigo, String nombre){
        siguiente =null;
        inicionotas=null;
        this.codigo=codigo;
        this.nombre=nombre; 
    }

    public NodoEstudiante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstudiante siguiente) {
        this.siguiente = siguiente;
    }

    public NodoNotas getInicionotas() {
        return inicionotas;
    }

    public void setInicionotas(NodoNotas inicionotas) {
        this.inicionotas = inicionotas;
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
