package logicadenegocios;

/**
 * Representa una empresa con detalles básicos como razón social, cédula jurídica, dirección y
 * teléfono. Esta clase se utiliza para gestionar la información corporativa que puede ser utilizada
 * en contextos como facturación, contacto y representación legal.
 */
public class Empresa {
  private String razonSocial;
  private String cedulaJuridica;
  private String direccion;
  private String telefono;

  /**
   * Constructor que inicializa una nueva instancia de Empresa con todos los detalles requeridos.
   *
   * @param razonSocial La razón social de la empresa.
   * @param cedulaJuridica La cédula jurídica de la empresa, usada como identificador legal.
   * @param direccion La dirección física de la empresa.
   * @param telefono El número de teléfono de contacto de la empresa.
   */
  public Empresa(String razonSocial, String cedulaJuridica, String direccion, String telefono) {
    this.razonSocial = razonSocial;
    this.cedulaJuridica = cedulaJuridica;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public String getCedulaJuridica() {
    return cedulaJuridica;
  }

  public void setCedulaJuridica(String cedulaJuridica) {
    this.cedulaJuridica = cedulaJuridica;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Genera una representación en forma de String de la empresa, mostrando todos los detalles
   * importantes.
   *
   * @return Una cadena que representa los datos de la empresa.
   */
  @Override
  public String toString() {
    return "[RazonSocial=" + razonSocial + ", cedulaJuridica=" + cedulaJuridica + ", direccion="
        + direccion + ", telefono=" + telefono + "]";
  }



}
