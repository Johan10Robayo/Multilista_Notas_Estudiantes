/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Compact
 */
public interface Imultilista {
    void insertarcurso(NodoCurso curso,int codigo,String nombre);
    void insertarestudiante(NodoCurso curso,NodoEstudiante est,int codigo,String nombre);
    void insetarnota(NodoCurso curso,NodoEstudiante est,int cohorte, double nota);
    NodoCurso extraercurso(NodoCurso curso);
    NodoEstudiante extraerestudiante(NodoCurso curso,NodoEstudiante est);
    NodoNotas extraernota(NodoCurso curso,NodoEstudiante est,int cohorte,double nota );
    NodoCurso buscarcurso(int codigo,String nombre);
    NodoEstudiante buscarestudiante(NodoCurso curso,int codigo,String nombre);
    void mostrarmultilista();
}
