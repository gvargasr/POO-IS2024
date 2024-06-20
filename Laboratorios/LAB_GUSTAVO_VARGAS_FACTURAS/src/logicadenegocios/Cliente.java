package logicadenegocios;

/**
 * Representa un cliente en el sistema de gestión de la empresa. Cada cliente está definido por su
 * nombre, dirección, teléfono y correo electrónico.
 */
public class Cliente {
  private String nombre;
  private String direccion;
  private String telefono;
  private String email;

  /**
   * Constructor para crear un nuevo cliente. Inicializa el cliente con todos sus datos personales
   * básicos.
   *
   * @param pNombre El nombre del cliente.
   * @param pDireccion La dirección del cliente.
   * @param pTelefono El número de teléfono del cliente.
   * @param pEmail La dirección de correo electrónico del cliente.
   */
  public Cliente(String pNombre, String pDireccion, String pTelefono, String pEmail) {
    this.nombre = pNombre;
    this.direccion = pDireccion;
    this.telefono = pTelefono;
    this.email = pEmail;

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
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Proporciona una representación en cadena de texto de la información del cliente, incluyendo
   * nombre, dirección, teléfono y correo electrónico.
   *
   * @return Una cadena de texto con todos los detalles del cliente.
   */
  @Override
  public String toString() {
    String msg;
    msg = "Nombre= " + getNombre() + "\n";
    msg += "Direccion= " + direccion + "\n";
    msg += "Telefono= " + telefono + "\n";
    msg += "Email= " + email + "\n";
    return msg;
  }

}
