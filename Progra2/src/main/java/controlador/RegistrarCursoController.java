package controlador;

import modelo.Escuela;
import vista.RegistrarCurso;

/**
 *
 * Clase para controlar el metodo Registrar curso y enlazarlo con la interfaz grafica
 * @author gvargasr
 */
public class RegistrarCursoController {
  public static RegistrarCurso ventana = new RegistrarCurso();

  public static void mostrar() {
    ventana.updateEscuelas();
    ventana.setVisible(true);
  }

  public static void ocultar() {
    ventana.setVisible(false);
  }

  public static void eventoBotonRegistrarCurso() {
    String pEscuela = ventana.getjComboBox1().getSelectedItem().toString();
    String pNombre = ventana.getjTextField1().getText();
    String pCodigo = ventana.getjLabel5().getText() + ventana.getjTextField2().getText();
    int pCreditos = Integer.parseInt(ventana.getjComboBox2().getSelectedItem().toString());
    int pHorasLectivas = Integer.parseInt(ventana.getjComboBox3().getSelectedItem().toString());
    //System.out
    //    .println(pEscuela + "-" + pNombre + "-" + pCodigo + "-" + pCreditos + "-" + pHorasLectivas);
    Escuela escuela;
    escuela = VistaPrincipalController.modelo.buscarEscuela(pEscuela);
    escuela.registrarCurso(pNombre, pCodigo, pCreditos, pHorasLectivas);
  }

  public static void eventoBotonLimpiar() {
    ventana.limpiarEspacios();
  }



}
