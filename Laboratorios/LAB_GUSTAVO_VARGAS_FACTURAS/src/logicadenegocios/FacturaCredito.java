package logicadenegocios;

import java.util.Date;


/**
 * Representa una factura a crédito en el sistema de gestión financiera de la empresa. Esta clase
 * hereda de {@link Factura} y añade propiedades y métodos específicos para el manejo de facturas
 * que se pagan a plazos, incluyendo intereses mensuales y el plazo del crédito.
 */
public class FacturaCredito extends Factura {

  private int mesesCredito;
  private double tasaInteresMensual;
  private double total;

  /**
   * Constructor para crear una factura a crédito con información básica.
   * 
   * @param empresa La empresa emisora de la factura.
   * @param mensajePublicitario Mensaje promocional asociado a la factura.
   * @param fecha La fecha de emisión de la factura.
   * @param mesesCredito El número de meses sobre los cuales se extiende el crédito.
   * @param tasaInteresMensual La tasa de interés mensual aplicada al crédito.
   */
  public FacturaCredito(Empresa empresa, String mensajePublicitario, Date fecha, int mesesCredito,
      double tasaInteresMensual) {
    super(empresa, mensajePublicitario, fecha);
    this.establecerCredito(mesesCredito, tasaInteresMensual);
  }

  /**
   * Constructor para crear una factura a crédito que incluye datos del cliente.
   * 
   * @param empresa La empresa emisora de la factura.
   * @param cliente El cliente al que se le emite la factura.
   * @param mensajePublicitario Mensaje promocional asociado a la factura.
   * @param fecha La fecha de emisión de la factura.
   * @param mesesCredito El número de meses sobre los cuales se extiende el crédito.
   * @param tasaInteresMensual La tasa de interés mensual aplicada al crédito.
   */
  public FacturaCredito(Empresa empresa, Cliente cliente, String mensajePublicitario, Date fecha,
      int mesesCredito, double tasaInteresMensual) {
    super(empresa, cliente, mensajePublicitario, fecha);
    this.establecerCredito(mesesCredito, tasaInteresMensual);
  }

  /**
   * Constructor para crear una factura a crédito que incluye datos de empleados involucrados.
   * 
   * @param empresa La empresa emisora de la factura.
   * @param cajero El empleado que realizó la operación de caja.
   * @param vendedor El empleado que realizó la venta.
   * @param cliente El cliente al que se le emite la factura.
   * @param mensajePublicitario Mensaje promocional asociado a la factura.
   * @param fecha La fecha de emisión de la factura.
   * @param mesesCredito El número de meses sobre los cuales se extiende el crédito.
   * @param tasaInteresMensual La tasa de interés mensual aplicada al crédito.
   */
  public FacturaCredito(Empresa empresa, Empleado cajero, Empleado vendedor, Cliente cliente,
      String mensajePublicitario, Date fecha, int mesesCredito, double tasaInteresMensual) {
    super(empresa, cajero, vendedor, cliente, mensajePublicitario, fecha);
    this.establecerCredito(mesesCredito, tasaInteresMensual);
  }

  /**
   * Establece los términos del crédito para la factura.
   * 
   * @param mesesCredito El número de meses para el pago del crédito.
   * @param tasaInteresMensual La tasa de interés mensual aplicada.
   */
  public void establecerCredito(int mesesCredito, double tasaInteresMensual) {
    this.mesesCredito = mesesCredito;
    this.tasaInteresMensual = tasaInteresMensual;
  }

  /**
   * Calcula el pago mensual que el cliente debe realizar para cubrir el total de la factura,
   * incluyendo los intereses.
   * 
   * @return El monto mensual a pagar por el cliente.
   */
  public double calcularPagoMensual() {
    double tasaInteresDecimal = tasaInteresMensual / 100;
    double montoCredito = total * (1 + tasaInteresDecimal * mesesCredito);
    return montoCredito / mesesCredito;
  }

  /**
   * Proporciona una representación en cadena de la factura a crédito. Incluye todos los datos de la
   * factura general más cualquier detalle específico de las facturas a crédito.
   *
   * @return Una cadena que representa la factura a crédito.
   */
  @Override
  public String toString() {
    return "Factura de Crédito: \n" + super.toString();
  }
}
