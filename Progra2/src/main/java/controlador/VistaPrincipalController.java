package controlador;

import modelo.Gestor;
import vista.*;

/**
 *
 * Controlador de la Interfaz grafica principal.
 * @author gvargasr
 */
public class VistaPrincipalController {
  public static VistaPrincipal ventana = new VistaPrincipal();
  public static Gestor modelo = new Gestor();

  public static void mostrar() {
    ventana.setVisible(true);
  }

  public static void ocultar() {
    ventana.dispose();
  }

  public static void botonSalir() {

  }

  public static void botonRegistrarEscuela() {
    ocultar();
    RegistrarEscuelaController.mostrar();
  }

  public static void botonRegistrarCurso() {
    ocultar();
    RegistrarCursoController.mostrar();
  }

  public static void botonRegistrarRequisito() {
    ocultar();
    RegistrarRequisitoController.mostrar();
  }

  public static void botonCrearPlan() {
    ocultar();
    CrearPlanController.mostrar();
  }

  public static void botonGenerarPDF() {
    ocultar();
    GenerarPDFController.mostrar();

  }


}
