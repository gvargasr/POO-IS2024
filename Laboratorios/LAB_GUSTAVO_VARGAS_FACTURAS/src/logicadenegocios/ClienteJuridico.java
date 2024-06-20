package logicadenegocios;

/**
 * Representa un cliente jurídico en el sistema de gestión de la empresa. Extiende de la clase
 * {@link Cliente} e incluye detalles específicos de clientes jurídicos como la cédula jurídica y
 * contactos específicos para compras y pagos.
 */
public class ClienteJuridico extends Cliente {
  private String cedulaJuridica;
  private String contactoCompras;
  private String contactoPagos;

  /**
   * Constructor para crear un nuevo cliente jurídico. Inicializa al cliente con sus datos
   * personales básicos y específicos de clientes jurídicos, como la cédula jurídica y los contactos
   * para compras y pagos.
   *
   * @param nombre El nombre del cliente.
   * @param direccion La dirección del cliente.
   * @param telefono El número de teléfono del cliente.
   * @param email La dirección de correo electrónico del cliente.
   * @param cedulaJuridica La cédula jurídica que identifica al cliente jurídico.
   * @param contactoCompras El contacto responsable de las compras en la empresa cliente.
   * @param contactoPagos El contacto responsable de los pagos en la empresa cliente.
   */
  public ClienteJuridico(String nombre, String direccion, String telefono, String email,
      String cedulaJuridica, String contactoCompras, String contactoPagos) {
    super(nombre, direccion, telefono, email);
    this.cedulaJuridica = cedulaJuridica;
    this.contactoCompras = contactoCompras;
    this.contactoPagos = contactoPagos;
  }

  // Getters y Setters
  public String getCedulaJuridica() {
    return cedulaJuridica;
  }

  public void setCedulaJuridica(String cedulaJuridica) {
    this.cedulaJuridica = cedulaJuridica;
  }

  public String getContactoCompras() {
    return contactoCompras;
  }

  public void setContactoCompras(String contactoCompras) {
    this.contactoCompras = contactoCompras;
  }

  public String getContactoPagos() {
    return contactoPagos;
  }

  public void setContactoPagos(String contactoPagos) {
    this.contactoPagos = contactoPagos;
  }

  /**
   * Proporciona una representación en cadena de texto de la información del cliente jurídico,
   * incluyendo todos los datos heredados del cliente general, así como la cédula jurídica y los
   * contactos para compras y pagos.
   *
   * @return Una cadena de texto con todos los detalles del cliente jurídico.
   */
  @Override
  public String toString() {
    String msg;
    msg = "\n[Cedula Juridica= " + cedulaJuridica + "\n";
    msg += super.toString();
    msg += "Contacto para pagos= " + contactoPagos + "\n";
    msg += "Contacto para compras= " + contactoCompras + "]\n";

    return msg;
  }
}

