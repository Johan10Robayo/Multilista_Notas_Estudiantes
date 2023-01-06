/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Compact
 */
public class NodoNotas {
    private NodoNotas siguiente;
    private int cohorte;
    private double nota;
    public NodoNotas(double nota,int cohorte){
        siguiente=null;
        this.nota=nota;
        this.cohorte=cohorte; 
    }

    public NodoNotas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoNotas siguiente) {
        this.siguiente = siguiente;
    }

    public int getCohorte() {
        return cohorte;
    }

    public void setCohorte(int cohorte) {
        this.cohorte = cohorte;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
}
