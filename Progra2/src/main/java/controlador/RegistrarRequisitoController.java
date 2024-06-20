package controlador;

import modelo.Curso;
import modelo.Escuela;
import vista.RegistrarRequisito;

/**
 * Clase para controlar el metodo Registrar Requisito y enlazarlo con la interfaz grafica
 * @author gvargasr
 */
public class RegistrarRequisitoController {
  public static RegistrarRequisito ventana = new RegistrarRequisito();

  public static void mostrar() {
    ventana.updateEscuelas();
    ventana.setVisible(true);
  }

  public static void ocultar() {
    ventana.setVisible(false);
  }

  public static void eventoBotonRegistrarRequisito() {
    String nombreEscuela = (String) ventana.getjComboBox1().getSelectedItem();
    String codCurso = (String) ventana.getjComboBox4().getSelectedItem();
    String codRequisito = (String) ventana.getjComboBox2().getSelectedItem();

    Escuela escuelaActual = VistaPrincipalController.modelo.buscarEscuela(nombreEscuela);
    Curso cursoActual = escuelaActual.buscarCurso(codCurso);
    Curso requisito = escuelaActual.buscarCurso(codRequisito);
    cursoActual.agregarRequisito(requisito);

    // VistaPrincipalController.modelo.
    // System.out.println("Requisito: " + requisito.getNombre() + "\n");
  }

  public static void eventoBotonRegistrarCorrequisito() {
    String nombreEscuela = (String) ventana.getjComboBox1().getSelectedItem();
    String codCurso = (String) ventana.getjComboBox4().getSelectedItem();
    String codCorrequisito = (String) ventana.getjComboBox3().getSelectedItem();

    Escuela escuelaActual = VistaPrincipalController.modelo.buscarEscuela(nombreEscuela);
    Curso cursoActual = escuelaActual.buscarCurso(codCurso);
    Curso correquisito = escuelaActual.buscarCurso(codCorrequisito);
    cursoActual.agregarCorrequisito(correquisito);

    // VistaPrincipalController.modelo.
    // System.out.println("Correquisito: " + correquisito.getNombre() + "\n");
  }
}
