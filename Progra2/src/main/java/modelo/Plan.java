package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase Plan incluye la logica para crear los planes de estudio.
 * @author gvargasr
 * 
 */
public class Plan {
  private int numeroDePlan;
  private String fechaVigencia;
  private ArrayList<ArrayList<Curso>> MatrizPlan = new ArrayList<>();

  public Plan() {
    for (int i = 0; i < 8; i++) {
      MatrizPlan.add(new ArrayList<>());
    }
    fechaVigencia = " ";
  }

  public void agregarCurso(int pNumeroDePlan, String pFechaVigencia, Curso pCurso, int pBloque) {
    numeroDePlan = pNumeroDePlan;
    fechaVigencia = pFechaVigencia;
    int bloque = pBloque;
    if (bloque >= 0 && bloque < MatrizPlan.size()) {
      MatrizPlan.get(bloque).add(pCurso);
    } else {
     // System.out.println("Columna fuera de rango");
    }
  }

  public void imprimir() {
    int numeroColumna = 1;
    System.out.println(
        "Plan " + numeroDePlan + "\nFecha de entrada en vigencia: " + fechaVigencia + "\n");
    for (ArrayList<Curso> columna : MatrizPlan) {
      System.out.println(
          " ----------------------------------------------------------------------------------------");
      System.out.printf("%-45s %-45s %-45s\n", "| Bloque " + numeroColumna, "| Requisitos",
          "| Correquisitos    |");
      System.out.println(
          " ----------------------------------------------------------------------------------------");
      for (Curso curso : columna) {
        String[] infoLines = curso.imprimirInfo().split("\n");
        String[] courseLines = splitIntoLines(curso.getCodigo() + " " + curso.getNombre(), 45);

        int maxLines = Math.max(infoLines.length, courseLines.length);

        for (int i = 0; i < maxLines; i++) {
          String courseInfo = i < courseLines.length ? courseLines[i] : "";
          String requisitesInfo = i < infoLines.length ? infoLines[i] : "";
          System.out.printf("| %-43s | %-43s | %-43s |\n", courseInfo, requisitesInfo, "");
        }
        System.out.println(
            " ----------------------------------------------------------------------------------------");
      }
      numeroColumna++;
      System.out.println("\n");
    }
  }

  /**
   * Metodo para separar en lineas la informacion de las columnas e imprimir ordenadamente.
   */
  private String[] splitIntoLines(String text, int maxLength) {
    List<String> lines = new ArrayList<>();
    int index = 0;
    while (index < text.length()) {
      lines.add(text.substring(index, Math.min(index + maxLength, text.length())));
      index += maxLength;
    }
    return lines.toArray(new String[0]);
  }


  public String generarString() {
    StringBuilder resultado = new StringBuilder();
    int numeroColumna = 1;
    resultado.append("Plan ").append(numeroDePlan).append("\nFecha de entrada en vigencia: ")
        .append(fechaVigencia).append("\n\n");
    for (ArrayList<Curso> columna : MatrizPlan) {
      resultado.append(
          " ------------------------------------------------------------------------------------------------------------\n");
      resultado.append(String.format("%-45s %-45s %-45s\n", "| Bloque " + numeroColumna,
          "Requisitos", "Correquisitos    "));
      // resultado.append("
      // ------------------------------------------------------------------------------------------------------------\n");
      for (Curso curso : columna) {
        resultado.append(String.format("%-45s %-45s", curso.getCodigo() + " " + curso.getNombre(),
            curso.imprimirInfo()));
        resultado.append("\n");
      }
      numeroColumna++;
      resultado.append("\n\n");
    }
    return resultado.toString();
  }

  public boolean verificarCurso(Curso pCurso) {
    for (ArrayList<Curso> columna : MatrizPlan) {
      for (Curso curso : columna) {
        if (curso.equals(pCurso)) {
          return true;
        }
      }
    }
    return false;
  }
  
    public boolean verificarCursoCodigo(String pCodigo) {
    for (ArrayList<Curso> columna : MatrizPlan) {
      for (Curso curso : columna) {
        if (curso.getCodigo().equals(pCodigo)) {
          return true;
        }
      }
    }
    return false;
  }

  public ArrayList<ArrayList<Curso>> getPlan() {
    return MatrizPlan;
  }

  public int getCodigo() {
    return numeroDePlan;
  }

}
