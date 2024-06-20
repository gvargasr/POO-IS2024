package logicadenegocios;


/**
 * Clase que representa un detalle específico de una factura, asociando un ítem con una cantidad.
 * Permite calcular el subtotal basado en el precio del ítem y la cantidad especificada.
 */
public class DetalleFactura {
  private Item item;
  private int cantidad;

  /**
   * Constructor que crea un nuevo detalle de factura con un ítem y una cantidad específica.
   *
   * @param item El ítem que se incluirá en la factura.
   * @param cantidad La cantidad del ítem en la factura.
   */
  public DetalleFactura(Item item, int cantidad) {
    this.item = item;
    this.cantidad = cantidad;
  }

  public Item getItem() {
    return item;
  }

  public int getCantidad() {
    return cantidad;
  }

  public double getSubtotal() {
    return cantidad * item.getPrecio();
  }

  /**
   * Genera texto del detalle de factura, mostrando la descripción del ítem y la cantidad.
   *
   * @return Una cadena de texto que representa este detalle de factura.
   */
  @Override
  public String toString() {
    return item.toString() + ", cantidad=" + cantidad + "]";
  }
}
