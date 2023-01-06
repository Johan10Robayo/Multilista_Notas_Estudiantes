/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Compact
 */
public class pruebas {
    public static void main(String[] args) {
        Multilista m1=new Multilista();
        NodoCurso curso=m1.buscarcurso(4040,"ecuaciones");
        m1.insertarcurso(curso,4040,"ecuaciones");
        
        NodoCurso nd= m1.buscarcurso(344,"fisica");
        m1.insertarcurso(nd,344,"fisica");
        
        NodoCurso ns= m1.buscarcurso(344,"fisica");
        NodoEstudiante est=m1.buscarestudiante(ns,4040,"johan");
        m1.insertarestudiante(ns, est, 4040,"johan");
        NodoEstudiante est1=m1.buscarestudiante(ns,4040,"johan");
        
        m1.insetarnota(ns, est1, 1, 5);
        m1.insetarnota(ns, est1, 1, 4);
        m1.insetarnota(ns, est1, 2, 5);
        m1.insetarnota(ns, est1, 1, 4.4);
        m1.insetarnota(ns, est1, 2, 3);
        m1.insetarnota(ns, est1, 2, 4);
        m1.insetarnota(ns, est1, 2, 5);
        m1.insetarnota(ns, est1, 2, 4.5);
         m1.insetarnota(ns, est1, 3, 4.5);
         m1.insetarnota(ns, est1, 3, 4);
         m1.mostrarmultilista();
        m1.extraernota(ns, est1, 1, 4);
         m1.extraernota(ns, est1, 1, 5);
           m1.extraernota(ns, est1, 2, 4);
           m1.extraernota(ns, est1, 2, 4.5);
      m1.mostrarmultilista();
      
         
    }
}
