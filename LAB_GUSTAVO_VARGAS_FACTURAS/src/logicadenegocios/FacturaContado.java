package logicadenegocios;

import java.util.Date;

/**
 * Representa una factura al contado en el sistema de gestión financiera de la empresa. Esta clase
 * hereda de {@link Factura}, especializándose en las operaciones y representaciones específicas de
 * facturas pagadas de forma inmediata.
 */
public class FacturaContado extends Factura {
  // Constructor de FacturaContado

  /**
   * Constructor para crear una factura al contado con información básica. Solo incluye la empresa y
   * el mensaje publicitario.
   *
   * @param empresa La empresa emisora de la factura.
   * @param mensajePublicitario Mensaje promocional asociado a la factura.
   * @param fecha La fecha de emisión de la factura.
   */
  public FacturaContado(Empresa empresa, String mensajePublicitario, Date fecha) {
    super(empresa, mensajePublicitario, fecha);
  }

  /**
   * Constructor para crear una factura al contado que incluye datos del cliente.
   *
   * @param empresa La empresa emisora de la factura.
   * @param cliente El cliente al que se le emite la factura.
   * @param mensajePublicitario Mensaje promocional asociado a la factura.
   * @param fecha La fecha de emisión de la factura.
   */
  public FacturaContado(Empresa empresa, Cliente cliente, String mensajePublicitario, Date fecha) {
    super(empresa, cliente, mensajePublicitario, fecha);
  }

  /**
   * Constructor para crear una factura al contado que incluye datos de empleados involucrados.
   *
   * @param empresa La empresa emisora de la factura.
   * @param cajero El empleado que realizó la operación de caja.
   * @param vendedor El empleado que realizó la venta.
   * @param cliente El cliente al que se le emite la factura.
   * @param mensajePublicitario Mensaje promocional asociado a la factura.
   * @param fecha La fecha de emisión de la factura.
   */
  public FacturaContado(Empresa empresa, Empleado cajero, Empleado vendedor, Cliente cliente,
      String mensajePublicitario, Date fecha) {
    super(empresa, cajero, vendedor, cliente, mensajePublicitario, fecha);
  }

  /**
   * Proporciona una representación en cadena de la factura al contado. Incluye todos los datos de
   * la factura general más cualquier detalle específico de las facturas al contado.
   *
   * @return Una cadena que representa la factura al contado.
   */
  @Override
  public String toString() {
    return "Factura de Contado: \n" + super.toString();
  }
}
