package modelo;

import java.util.ArrayList;

/**
 *
 * Clase Gestor, que se encarga de inicializar la logica del programa.
 * Crea las listas donde se almacenan las Escuelas.
 * @author Gustavo Vargas
 * 
 */
public class Gestor {

  private ArrayList<Escuela> escuelas;

  public ArrayList<Escuela> getEscuelas() {
    return escuelas;
  }

  public Gestor() {
    this.escuelas = new ArrayList<>();
  }

  public void registrarEscuela(String pNombre, String pCodigo) {
    Escuela nuevaEscuela = new Escuela(pNombre, pCodigo);
    escuelas.add(nuevaEscuela);
  }

  public Escuela buscarEscuela(String pNombre) {
    for (Escuela escuela : escuelas) {
      if (escuela.getNombre().equalsIgnoreCase(pNombre)) {
        return escuela; // Retorna la escuela si encuentra una coincidencia
      }
    }
    return null; // Retorna null si no encuentra ninguna escuela con el nombre dado
  }

  public void generarPDF(Escuela pEscuela, Plan pPlan) {
    String nombreEscuela = pEscuela.getNombre();
    String codigoPlan = Integer.toString(pPlan.getCodigo());
    String planCompleto = pPlan.generarString();

    PDF nuevoPDF = new PDF(nombreEscuela, codigoPlan, planCompleto);
    nuevoPDF.crearPDF();
  }


}
