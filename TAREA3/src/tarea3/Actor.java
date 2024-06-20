package tarea3;


public class Actor {
  private String nombre;
  private int identificacion;
  private String rol;
  private static int cantidadActores = 0;

  public Actor(String pNombre) {
    cantidadActores++;
    setNombre(pNombre);
    setRol("Extra");
    setIdentificacion(cantidadActores);
  }

  public Actor(String pNombre, String pRol) {
    cantidadActores++;
    setNombre(pNombre);
    setRol(pRol);
    setIdentificacion(cantidadActores);
  }

  private void setNombre(String pNombre) {
    nombre = pNombre;
  }

  private void setIdentificacion(int pCantidadActores) {
    identificacion = pCantidadActores;
  }

  private void setRol(String pRol) {
    rol = pRol;
  }

  public String getNombre() {
    return nombre;
  }

  public int getIdentificacion() {
    return identificacion;
  }

  public String getRol() {
    return rol;
  }

  public String toString() {
    return "Actor: " + getNombre() + ", identificación: " + Integer.toString(getIdentificacion())
        + ", rol: " + getRol();
  }
}
