package controlador;

import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Escuela;
import modelo.Plan;
import vista.CrearPlan;

/**
 *
 * Clase para controlar el metodo crear plan y enlazarlo con la interfaz grafica
 */
public class CrearPlanController {
 /**
  * Metodo constructor
  */
  public CrearPlanController() {
        // Initialize any required components or perform setup here
  }
  
  /**
  * Metodo para crear nueva ventana
  */
  public static CrearPlan ventana = new CrearPlan();

  /**
  * Metodo para mostrar ventana
  */
  public static void mostrar() {
    ventana.updateEscuelas();
    ventana.setVisible(true);
  }

  /**
  * Metodo para ocultar ventana
  */
  public static void ocultar() {
    ventana.setVisible(false);
  }

  /**
  * Metodo para limpiar ventana
  */
  public static void eventoBotonLimpiar() {
    ventana.limpiarEspacios();
  }

  /**
  * Metodo para registrar cursos.
  */
  public static void eventoBotonRegistrarCurso() {
    // Obtener los datos de la interfaz
    String nombreEscuela = (String) ventana.getjComboBox1().getSelectedItem();
    String codigoPlan = ventana.getjTextField1().getText();
    String fechaVigencia = ventana.getFechaTextField().getText();
    String codigoCurso = (String) ventana.getjComboBox2().getSelectedItem();
    int bloque = ventana.getjComboBox3().getSelectedIndex();

    // Validaciones básicas
    if (nombreEscuela == null || codigoPlan.isEmpty() || fechaVigencia.isEmpty()
        || codigoCurso == null) {
      //System.out.println("Por favor, complete todos los campos.");
      return;
    }

    // Buscar la escuela
    Escuela escuela = VistaPrincipalController.modelo.buscarEscuela(nombreEscuela);
    if (escuela == null) {
      //System.out.println("La escuela no fue encontrada");
      return;
    }

    // Buscar el curso en la escuela
    Curso nuevoCurso = escuela.buscarCurso(codigoCurso);
    if (nuevoCurso == null) {
      //System.out.println("El curso no fue encontrado");
      return;
    }

    // Buscar el plan en la escuela
    Plan planActual = null;
    for (Plan plan : escuela.getPlanDeEstudio()) {
      if (plan.getCodigo() == Integer.parseInt(codigoPlan)) {
        planActual = plan;
        // System.out.println(planActual.toString());
        break;
      }
    }

    if (planActual == null) {
      planActual = new Plan();
      //System.out.println("El plan no fue encontrado, creando uno nuevo.\n");
      planActual.agregarCurso(Integer.parseInt(codigoPlan), fechaVigencia, nuevoCurso, bloque);
      escuela.addPlan(planActual); // Asegurarse de agregar el nuevo plan a la escuela
      //System.out.println("Curso agregado exitosamente.\n");
      return;
    }

    // Verificar si el curso ya existe en el plan
    if (planActual.verificarCurso(nuevoCurso)) {
      //System.out.println("El curso ya está en el plan.\n");
    } else {
     // System.out.println("Agregando curso al plan.\n");
      planActual.agregarCurso(Integer.parseInt(codigoPlan), fechaVigencia, nuevoCurso, bloque);
      //System.out.println("Curso agregado exitosamente.\n");
    }
  }


}
