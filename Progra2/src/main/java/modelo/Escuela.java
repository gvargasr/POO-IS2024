package modelo;

import java.util.ArrayList;

/**
 * Clase Escuela contiene informacion de la escuela y es utilizada para registrar cursos.
 * 
 * @author Gustavo Vargas
 */
public class Escuela {

  public String getNombre() {
    return nombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public ArrayList<Plan> getPlanDeEstudio() {
    return planDeEstudio;
  }

  public void addPlan(Plan pPlan) {
    planDeEstudio.add(pPlan);
  }

  public ArrayList<Curso> getCursos() {
    return cursos;
  }

  private String nombre;
  private String codigo;
  private ArrayList<Plan> planDeEstudio;
  private ArrayList<Curso> cursos;


  public Escuela(String nombre, String codigo) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.planDeEstudio = new ArrayList<>();
    this.cursos = new ArrayList<>();
  }

  public void registrarCurso(String pNombre, String pCodigo, int pCreditos, int pHorasLectivas) {
    Curso nuevoCurso = new Curso(pNombre, pCodigo, pCreditos, pHorasLectivas);
    cursos.add(nuevoCurso);
  }

  public Curso buscarCursoNombre(String pNombre) {
    for (Curso curso : cursos) {
      if (curso.getNombre().equalsIgnoreCase(pNombre)) {
        return curso;
      }
    }
    return null;
  }

  public Curso buscarCurso(String pCodigo) {
    for (Curso curso : cursos) {
      if (curso.getCodigo().equalsIgnoreCase(pCodigo)) {
        return curso;
      }
    }
    return null;
  }

  public Plan buscarPlan(int pNumeroDePlan) {
    for (Plan planActual : planDeEstudio) {
      if (planActual.getCodigo() == pNumeroDePlan) {
        return planActual;
      }
    }
    return null;
  }


}
