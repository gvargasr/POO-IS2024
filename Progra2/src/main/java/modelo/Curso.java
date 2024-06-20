package modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * Codigo con la logica para crear cursos.
 * @author gvargasr
 * 
 */
public class Curso {

  private String nombre;
  private String codigo;
  private int creditos;
  private int horasLectivas;
  private ArrayList<Curso> requisitos;
  private ArrayList<Curso> correquisitos;


  public Curso(String nombre, String codigo, int creditos, int horasLectivas) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.creditos = creditos;
    this.horasLectivas = horasLectivas;
    this.requisitos = new ArrayList<>();
    this.correquisitos = new ArrayList<>();
  }

  public void agregarRequisito(Curso pRequisito) {

    requisitos.add(pRequisito);

  }

  public String imprimirInfo() {
    StringBuilder result = new StringBuilder();
    int maxSize = Math.max(requisitos.size(), correquisitos.size());
    for (int i = 0; i < maxSize; i++) {
      String requisitoInfo = (i < requisitos.size()) ? requisitos.get(i).getCodigo() : "";
      String correquisitoInfo = (i < correquisitos.size()) ? correquisitos.get(i).getCodigo() : "";

      result.append(String.format("%-45s %-45s\n", requisitoInfo, correquisitoInfo));
      result.append(String.format("%46s", "  "));
    }
    return result.toString();
  }


  @Override
  public int hashCode() {
    int hash = 3;
    hash = 83 * hash + Objects.hashCode(this.codigo);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Curso other = (Curso) obj;
    return Objects.equals(this.codigo, other.codigo);
  }

  public void agregarCorrequisito(Curso pRequisito) {
    correquisitos.add(pRequisito);
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public int getCreditos() {
    return creditos;
  }

  public void setCreditos(int creditos) {
    this.creditos = creditos;
  }

  public int getHorasLectivas() {
    return horasLectivas;
  }

  public void setHorasLectivas(int horasLectivas) {
    this.horasLectivas = horasLectivas;
  }

  public ArrayList<Curso> getRequisitos() {
    return requisitos;
  }

  public void setRequisitos(ArrayList<Curso> requisitos) {
    this.requisitos = requisitos;
  }

  public ArrayList<Curso> getCorrequisitos() {
    return correquisitos;
  }

  public void setCorrequisitos(ArrayList<Curso> correquisitos) {
    this.correquisitos = correquisitos;
  }


}
