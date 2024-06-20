package tarea3;

public class Set {
  private String nombreSet;
  private static int cantidadSet;
  private int numeroSet = 0;
  private String direccion;

  public Set(String pNombreSet) {
    nombreSet = pNombreSet;
    cantidadSet++;
    numeroSet = cantidadSet;
    direccion = "HQ";
  }

  public Set(String pNombreSet, String pDireccion) {
    nombreSet = pNombreSet;
    cantidadSet++;
    numeroSet = cantidadSet;
    direccion = pDireccion;
  }

  public void setNombre(String pNombreSet) {
    nombreSet = pNombreSet;
  }

  public void setDireccion(String pDireccion) {
    direccion = pDireccion;
  }

  public String getNombre() {
    return nombreSet;
  }

  public String Direccion() {
    return direccion;
  }

  public String toString() {
    return "Set: " + getNombre() + ", Numero: " + numeroSet + ", Direccion: " + direccion;
  }
  // Métodos getters y setters
  // ...
}
