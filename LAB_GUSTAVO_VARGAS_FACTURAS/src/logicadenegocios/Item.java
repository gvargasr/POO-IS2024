package logicadenegocios;

/**
 * Clase base para representar ítems que pueden ser vendidos o facturados. Esta clase proporciona la
 * estructura básica para describir un ítem con su descripción y precio.
 */
public class Item {
  private String descripcion;
  private double precio;

  /**
   * Constructor que inicializa un nuevo ítem con una descripción y un precio.
   *
   * @param descripcion La descripción del ítem, que detalla lo que representa el ítem.
   * @param precio El precio unitario del ítem.
   */
  public Item(String descripcion, double precio) {
    this.descripcion = descripcion;
    this.precio = precio;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public double getPrecio() {
    return precio;
  }

  /**
   * Devuelve texto del ítem, mostrando su descripción y precio.
   *
   * @return Una cadena de texto que representa al ítem con su descripción y precio.
   */
  @Override
  public String toString() {
    return descripcion + ", precio=" + precio;
  }

}
