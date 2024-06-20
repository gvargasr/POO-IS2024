package logicadenegocios;

/**
 * Representa un cliente físico en el sistema de gestión de la empresa. Extiende de la clase
 * {@link Cliente} e incluye detalles específicos como cédula y ocupación del cliente físico.
 */
public class ClienteFisico extends Cliente {
  private String cedula;
  private String ocupacion;

  /**
   * Constructor para crear un nuevo cliente físico. Inicializa al cliente con sus datos personales
   * básicos y específicos de clientes físicos, como la cédula y la ocupación.
   *
   * @param nombre El nombre del cliente.
   * @param direccion La dirección del cliente.
   * @param telefono El número de teléfono del cliente.
   * @param email La dirección de correo electrónico del cliente.
   * @param cedula La cédula de identidad del cliente.
   * @param ocupacion La ocupación del cliente.
   */
  public ClienteFisico(String nombre, String direccion, String telefono, String email,
      String cedula, String ocupacion) {
    super(nombre, direccion, telefono, email);
    this.cedula = cedula;
    this.ocupacion = ocupacion;
  }

  // Getters y Setters
  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public String getOcupacion() {
    return ocupacion;
  }

  public void setOcupacion(String ocupacion) {
    this.ocupacion = ocupacion;
  }

  /**
   * Proporciona una representación en cadena de texto de la información del cliente físico,
   * incluyendo todos los datos heredados del cliente general, así como la cédula y la ocupación.
   *
   * @return Una cadena de texto con todos los detalles del cliente físico.
   */
  @Override
  public String toString() {
    String msg;
    msg = "\n[Cedula= " + cedula + "\n";
    msg += super.toString();
    msg += "Ocupacion= " + ocupacion + "]\n";

    return msg;
  }

}
