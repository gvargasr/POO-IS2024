package logicadenegocios;

/**
 * Representa a una persona con información básica como nombre, dirección y teléfono. Esta clase
 * proporciona una base para almacenar y manejar información de contacto esencial de una persona.
 */
public class Persona {
  private String nombre;
  private String direccion;
  private String telefono;

  /**
   * Constructor que inicializa una nueva persona con su nombre, dirección y número de teléfono.
   * 
   * @param pNombre El nombre de la persona.
   * @param pDireccion La dirección residencial de la persona.
   * @param pTelefono El número de teléfono de contacto de la persona.
   */
  public Persona(String pNombre, String pDireccion, String pTelefono) {
    this.nombre = pNombre;
    this.direccion = pDireccion;
    this.telefono = pTelefono;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the telefono
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Proporciona una representación en cadena de la persona, incluyendo su nombre, dirección y
   * número de teléfono.
   *
   * @return Una cadena que representa a la persona con todos sus datos de contacto.
   */
  @Override
  public String toString() {
    return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
        + "]";
  }
}
