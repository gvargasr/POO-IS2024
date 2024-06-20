package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 * Representa una factura para transacciones entre una empresa y sus clientes. Esta clase maneja la
 * creación y gestión de facturas incluyendo cálculos de impuestos, adición de líneas de detalle y
 * otras funcionalidades relevantes relacionadas con las facturas.
 */
public class Factura {
  private static int cantFacturas = 0;
  private int numeroFactura;
  private Empresa empresa;
  private Empleado cajero;
  private Empleado vendedor;
  private Cliente cliente;
  private ArrayList<DetalleFactura> detalles = new ArrayList<>();
  private double subtotal;
  private double impuesto;
  private double total;
  private String mensajePublicitario;
  private Date fecha;

  /**
   * Constructor para crear una factura con información esencial de la empresa y del cliente.
   *
   * @param empresa La empresa que emite la factura.
   * @param cliente El cliente al que se factura.
   * @param mensajePublicitario Mensaje promocional que se mostrará en la factura.
   * @param fecha La fecha de emisión de la factura.
   */
  public Factura(Empresa empresa, Cliente cliente, String mensajePublicitario, Date fecha) {
    cantFacturas++;
    this.numeroFactura = cantFacturas;
    this.empresa = empresa;
    this.cajero = null;
    this.vendedor = null;
    this.cliente = cliente;
    this.mensajePublicitario = mensajePublicitario;
    this.fecha = fecha;
  }

  /**
   * Constructor de una factura con información completa, incluidos los empleados involucrados en la
   * transacción.
   *
   * @param empresa La empresa que emite la factura.
   * @param cajero El cajero que procesa la transacción.
   * @param vendedor El vendedor que facilitó la venta.
   * @param cliente El cliente al que se factura.
   * @param mensajePublicitario Mensaje promocional que se mostrará en la factura.
   * @param fecha La fecha de emisión de la factura.
   */
  public Factura(Empresa empresa, Empleado cajero, Empleado vendedor, Cliente cliente,
      String mensajePublicitario, Date fecha) {
    cantFacturas++;
    this.numeroFactura = cantFacturas;
    this.empresa = empresa;
    this.cajero = cajero;
    this.vendedor = vendedor;
    this.cliente = cliente;
    this.mensajePublicitario = mensajePublicitario;
    this.fecha = fecha;
  }

  /**
   * Constructor minimalista de una factura usando solo detalles de la empresa y sin un cliente
   * especificado.
   *
   * @param empresa La empresa que emite la factura.
   * @param mensajePublicitario Mensaje promocional que se mostrará en la factura.
   * @param fecha La fecha de emisión de la factura.
   */
  public Factura(Empresa empresa, String mensajePublicitario, Date fecha) {
    cantFacturas++;
    this.numeroFactura = cantFacturas;
    this.empresa = empresa;
    this.cajero = null;
    this.vendedor = null;
    this.cliente = null;
    this.mensajePublicitario = mensajePublicitario;
    this.fecha = fecha;
  }

  /**
   * Añade un ítem de línea a la factura.
   *
   * @param detalle El ítem de línea de detalle que se añadirá.
   */
  public void incluirLineaDetalle(DetalleFactura detalle) {
    detalles.add(detalle);
    calcularSubtotal();
  }

  /**
   * Calcula el subtotal de la factura basado en los ítems de línea añadidos.
   */
  private void calcularSubtotal() {
    subtotal = 0;
    for (DetalleFactura detalle : detalles) {
      subtotal += detalle.getSubtotal();
    }
    calcularImpuestos();
  }

  /**
   * Calcula los impuestos para el subtotal actual.
   */
  public void calcularImpuestos() {
    impuesto = subtotal * 0.13; // Suponiendo un 13% de impuesto
    calcularTotal();
  }

  /**
   * Calcula el total de la factura incluyendo impuestos.
   *
   * @return El monto total de la factura.
   */
  public double calcularTotal() {
    total = subtotal + impuesto;
    return total;
  }

  // Getters y Setters
  public int getNumeroFactura() {
    return numeroFactura;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public Empleado getCajero() {
    return cajero;
  }

  public Empleado getVendedor() {
    return vendedor;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public double getTotal() {
    return total;
  }

  public Date getFecha() {
    return fecha;
  }

  public String getMensajePublicitario() {
    return mensajePublicitario;
  }

  public ArrayList<DetalleFactura> getDetalles() {
    return detalles;
  }

  /**
   * Imprime la informacion de los detalles de la factura .
   */
  public String imprimirDetalles() {
    String msg;
    msg = "\n";

    for (DetalleFactura detalle : detalles) {
      msg += detalle.toString() + "\n";
    }

    return msg;
  }


  /**
   * Genera una representación en forma de String de la factura, mostrando todos los detalles
   * importantes.
   *
   * @return Una cadena que representa los datos de la factura.
   */
  @Override
  public String toString() {
    String msg;
    msg = "\n************************Primera Linea******************************\n";

    msg += "Número Factura= " + numeroFactura + "\n";
    msg += "Empresa= \n" + empresa + "\n";
    msg += "Cajero= " + cajero + "\n";
    msg += "Vendedor= " + vendedor + "\n";
    msg += "Cliente= " + cliente + "\n";
    msg += "Detalles de Factura= " + imprimirDetalles() + "\n";
    msg += "Subtotal= " + subtotal + "\n";
    msg += "Impuesto= " + impuesto + "\n";
    msg += "Total= " + total + "\n";
    msg += "Mensaje Publicitario= " + mensajePublicitario + "\n";
    msg += "Fecha=" + fecha + "]\n";
    msg += "\n*************************Ultima Linea****************************\n";

    return msg;
  }

  /**
   * @param pCajero the cajero to set
   */
  public void asignarCajero(Empleado pCajero) {
    this.cajero = pCajero;
  }

  /**
   * @param pVendedor the vendedor to set
   */
  public void asignarVendedor(Empleado pVendedor) {
    this.vendedor = pVendedor;
  }

  /**
   * @param cliente the cliente to set
   */
  public void asignarCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
