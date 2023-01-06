/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

@author Johan linares
 */
import javax.swing.JOptionPane;

public class pruebamultilista {

    public static void main(String[] args) {
        Multilista m1 = new Multilista();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "MENÚ DE OPCIONES \n \n"
                    + "1. Insertar curso\n"
                    + "2. Insertar estudiante  \n"
                    + "3. Insertar Nota \n"
                    + "4. Mostrar mutilista \n"
                    + "5. Extraer curso \n "
                    + "6. Extraer Estudiante \n "
                    + "7. Extraer Nota \n "
                    + "8. Salir \n"
            ));
            switch (opcion) {

                case 1://insertar curso
                    String nomcurso = JOptionPane.showInputDialog(null, "Digite el nombre del curso");
                    int codcurso = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del curso"));
                    NodoCurso curso1 = m1.buscarcurso(codcurso, nomcurso);
                    m1.insertarcurso(curso1, codcurso, nomcurso);
                    break;

                case 2://insertar estudiante 
                    String nomcurso2 = JOptionPane.showInputDialog(null, "Digite el nombre del curso donde va a insertar el estudiante ");
                    int codcurso2 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del curso donde va a insetar el estudiante "));

                    String nomestudiante = JOptionPane.showInputDialog(null, "Digite el nombre del estudiante que va a ingresar al curso " + nomcurso2);
                    int codestudiante = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del estudiante que va ingresar al curso " + nomcurso2));

                    NodoCurso curso2 = m1.buscarcurso(codcurso2, nomcurso2);//primero busco el curso para insertar el estudiante en el mismo 
                    NodoEstudiante est = m1.buscarestudiante(curso2, codestudiante, nomestudiante);//busco el estudiante en el curso para saber si está, me tengo que asegurar que no esté

                    if (m1.getCabecera() != null) {
                        if (curso2 != null) {
                            m1.insertarestudiante(curso2, est, codestudiante, nomestudiante);
                        } else {
                            JOptionPane.showMessageDialog(null, "el curso " + nomcurso2 + " con el código " + codcurso2 + " no existe en la multilista "
                                    + "\n, por ende no se puede insertar el estudiante " + nomestudiante + " con el código " + codestudiante);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "digite  al menos un curso para insertar estudiantes  , porque no hay ni un curso");
                        break;
                    }
                    break;

                case 3://insertar notas
                    String nomcurso3 = JOptionPane.showInputDialog(null, "Digite el nombre del curso donde va a insertar  la nota del estudiante ");
                    int codcurso3 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del curso donde va a insertar la nota del estudiante "));

                    String nomestudiante2 = JOptionPane.showInputDialog(null, "Digite el nombre del estudiante al que le  va a insertar la nota, en el  curso " + nomcurso3);
                    int codestudiante2 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del estudiante que va ingresar la nota, en el curso " + nomcurso3));

                    int cohorte = Integer.parseInt(JOptionPane.showInputDialog(null, " digite el cohorte donde va ingresar la nota "));
                    double nota = Double.parseDouble(JOptionPane.showInputDialog(null, "digite la nota del cohorte número " + cohorte));

                    NodoCurso curso3 = m1.buscarcurso(codcurso3, nomcurso3);
                    NodoEstudiante est3 = m1.buscarestudiante(curso3, codestudiante2, nomestudiante2);

                    if (m1.getCabecera() != null) {
                        if (curso3 != null) {
                            if (est3 != null) {
                                m1.insetarnota(curso3, est3, cohorte, nota);
                            } else {
                                JOptionPane.showMessageDialog(null, "el estudiante " + nomestudiante2 + " con el código " + codestudiante2
                                        + "\n no existe en el curso " + nomcurso3 + " con el código " + codcurso3 + ",por ende no se puede insertar le nota ");
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "el Curso " + nomcurso3 + " con el código " + codcurso3 + " donde se supone que está "
                                    + "\n el estudiante " + nomestudiante2 + " con el código " + codestudiante2 + " no existe en la multilista,"
                                    + "\n por ende no se puede insertar la nota");
                            break;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "digite  al menos un curso para insertar estudiantes y luego las notas respectivamente, porque no hay ni un curso");
                        break;
                    }
                    break;
                case 4://mostrar multilista
                    if (m1.getCabecera() != null) {
                        m1.mostrarmultilista();
                    } else {
                        JOptionPane.showMessageDialog(null, "digite  al menos un curso para mostrar la multilista, porque no hay ni un curso");
                        break;
                    }
                    break;
                case 5://extraer curso
                    int codcurso4 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el codigo del curso que desea extraer"));
                    String nomcurso4 = JOptionPane.showInputDialog(null, "digite el nombre del curso que desea extraer ");
                    NodoCurso curso4 = m1.buscarcurso(codcurso4, nomcurso4);

                    if (curso4 != null) {//me aseguro de que el curso exista para extraerlo
                        NodoCurso aux = m1.extraercurso(curso4);
                        JOptionPane.showMessageDialog(null, "extraiste el curso " + aux.getNombre() + " con el código" + aux.getCodigo());
                        break;
                    } else {

                        if (m1.getCabecera() == null) {
                            JOptionPane.showMessageDialog(null, " digite el menos un curso para extraerlo, porque no hay ni uno");
                            break;

                        } else {

                            JOptionPane.showMessageDialog(null, " el curso " + nomcurso4 + " con el código " + codcurso4 + ""
                                    + "\n no se encuenta en la multilista, por ende no se puede extraer ");
                            break;

                        }

                    }

                case 6://extraer estudiante 
                    int codcurso5 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el codigo del curso donde está el estudiante  que desea extraer"));
                    String nomcurso5 = JOptionPane.showInputDialog(null, "digite el nombre del curso donde está el estudiante que desea extraer ");
                    int codest = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el codigo del  estudiante  que desea extraer del curso " + nomcurso5));
                    String nomest = JOptionPane.showInputDialog(null, "digite el nombre del  estudiante que desea extraer del curso " + codcurso5);
                    NodoCurso curso5 = m1.buscarcurso(codcurso5, nomcurso5);
                    NodoEstudiante est5 = m1.buscarestudiante(curso5, codest, nomest);

                    if (curso5 != null) {
                        if (est5 != null) {
                            m1.extraerestudiante(curso5, est5);
                            JOptionPane.showMessageDialog(null, "extraiste el estudiante " + est5.getNombre() + " con el código " + est5.getCodigo()
                                    + "\n del curso " + curso5.getNombre() + " con el código " + curso5.getCodigo());
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "el estudiante " + nomest + " con el código " + codest
                                    + "\n no existe en el curso " + curso5.getNombre() + " con el código " + curso5.getCodigo() + ",por ende no se puede extraer");
                            break;
                        }

                    } else {
                        if (m1.getCabecera() == null) {
                            JOptionPane.showMessageDialog(null, " digite el menos un curso, para insertar estudiantes y posteriormente extraerlo, porque no hay ni uno");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "el curso " + nomcurso5 + " con el código " + codcurso5
                                    + "\n donde se supone que está el estudiante " + nomest + " con el código " + codest + ",no existe"
                                    + "\n, por ende no se puede extraer el estudiante ");
                            break;
                        }
                    }

                case 7://extraer nota
                    String nomcurso6 = JOptionPane.showInputDialog(null, " digite el nombre del curso donde se encuentra el estudiante para extraer la nota ");
                    int codcurso6 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del curso donde se encuantra el estudiante para extraer la nota "));

                    String nomest6 = JOptionPane.showInputDialog(null, "digite el nombre del estudiante que se encuentra en el curso"
                            + "\n " + nomcurso6 + " con el código " + codcurso6 + " para extreer la nota ");
                    int codest6 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el código del estudiante que se encuentra en el curso"
                            + "\n " + nomcurso6 + " con el código " + codcurso6 + " para extreer la nota "));

                    int cohorte1 = Integer.parseInt(JOptionPane.showInputDialog(null, "digite el cohorte donde está la nota del estudiante " + nomest6
                            + "\n con el código " + codest6 + " que el pertenece al curso " + nomcurso6 + " con el código" + codcurso6));
                    double nota1 = Double.parseDouble(JOptionPane.showInputDialog(null, "digite la nota del cohorte" + cohorte1 + " del estudiante " + nomest6
                            + "\n con el código " + codest6 + " que el pertenece al curso " + nomcurso6 + " con el código" + codcurso6));
                    NodoCurso curso6 = m1.buscarcurso(codcurso6, nomcurso6);
                    NodoEstudiante est6 = m1.buscarestudiante(curso6, codest6, nomest6);

                    if (m1.getCabecera() != null) {
                        if (curso6 != null) {
                            if (est6 != null) {
                                if (est6.getInicionotas() != null&&m1.extraernota(curso6, est6, cohorte1, nota1)!=null) {
                                    
                                    JOptionPane.showMessageDialog(null, "extraiste la nota " + nota1 + " del estudiante " + est6.getNombre());
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "la nota " + nota1 + " no existe en el estudiante " + est6.getNombre()+", no se puede extraer");
                                    break;
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, " el estudiante " + nomest6 + " con el código " + codest6
                                        + " no existe el curso " + curso6.getNombre() + " con el código " + curso6.getCodigo() + ", por ende no se puede extraer la nota");
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "el curso " + nomcurso6 + " con el código " + codcurso6 + " donde se supone "
                                    + "\n que está el estudiante " + nomest6 + " con el código " + codest6 + " no existe en la multilista"
                                    + "\n,por ende no se puede extraer la nota  ");
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Digite al menos un curso para insertar un estudiante,"
                                + "posteriormente la respectiva nota y luego extraerla, porque no hay ni un curso ");
                        break;
                    }

                case 8://salir 
                    break;
                default:// opción incorrecta
                    JOptionPane.showMessageDialog(null, "digite una opción del menú principal ");
                    break;
            }

        } while (opcion != 8);

    }
}
