package tarea3;

public class Productor {
  private String nombre;
  private int identificacion;
  private static int cantidadProductores = 0;

  public Productor(String pNombre) {
    cantidadProductores++;
    setNombre(pNombre);
    setIdentificacion(cantidadProductores);
  }

  private void setNombre(String pNombre) {
    nombre = pNombre;
  }

  private void setIdentificacion(int pCantidadActores) {
    identificacion = pCantidadActores;
  }

  public String getNombre() {
    return nombre;
  }

  public int getIdentificacion() {
    return identificacion;
  }

  public String toString() {
    return "Productor: " + getNombre() + ", identificación: "
        + Integer.toString(getIdentificacion() + 1000);
  }
}
