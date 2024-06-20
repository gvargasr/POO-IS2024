package controlador;

import modelo.Escuela;
import modelo.Plan;
import vista.GenerarPDF;

/**
 *
 * Clase para controlar el metodo GenerarPDF y enlazarlo con la interfaz grafica
 * @author gvargasr
 */
public class GenerarPDFController {
  public static GenerarPDF ventana = new GenerarPDF();

  public static void eventoBotonLimpiar() {
    ventana.limpiarEspacios();
  }

  public static void eventoBotonGenerarPDF() {

    String nombreEscuela = (String) ventana.getjComboBox1().getSelectedItem();
    String codigoPlan = (String) ventana.getjComboBox2().getSelectedItem();
    Escuela escuelaActual = VistaPrincipalController.modelo.buscarEscuela(nombreEscuela);
    Plan planActual = escuelaActual.buscarPlan(Integer.parseInt(codigoPlan));

    //System.out.println(planActual.generarString());
    VistaPrincipalController.modelo.generarPDF(escuelaActual, planActual);
  }

  public static void mostrar() {
    ventana.updateEscuelas();
    ventana.setVisible(true);
  }

}
