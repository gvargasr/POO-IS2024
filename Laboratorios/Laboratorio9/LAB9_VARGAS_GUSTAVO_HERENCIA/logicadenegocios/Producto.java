package logicadenegocios;


/**
 * Clase que representa un producto, extendiendo la clase {@code Item}. Un {@code Producto} incluye
 * detalles específicos como número de serie, marca y periodo de garantía en meses.
 */
public class Producto extends Item {
  private String numeroSerie;
  private String marca;
  private int garantiaMeses;

  /**
   * Constructor que crea un nuevo {@code Producto} con detalles completos.
   *
   * @param descripcion Descripción breve del producto, heredado de {@code Item}.
   * @param precio Precio unitario del producto, heredado de {@code Item}.
   * @param numeroSerie Número de serie único que identifica al producto.
   * @param marca Marca comercial del producto.
   * @param garantiaMeses Número de meses que dura la garantía del producto.
   */
  public Producto(String descripcion, double precio, String numeroSerie, String marca,
      int garantiaMeses) {
    super(descripcion, precio);
    this.numeroSerie = numeroSerie;
    this.marca = marca;
    this.garantiaMeses = garantiaMeses;
  }

  public String getNumeroSerie() {
    return numeroSerie;
  }

  public String getMarca() {
    return marca;
  }

  public int getGarantiaMeses() {
    return garantiaMeses;
  }

  /**
   * @param numeroSerie the numeroSerie to set
   */
  public void setNumeroSerie(String numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  /**
   * @param marca the marca to set
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * @param garantiaMeses the garantiaMeses to set
   */
  public void setGarantiaMeses(int garantiaMeses) {
    this.garantiaMeses = garantiaMeses;
  }

  /**
   * Genera una representación en forma de String del producto, mostrando todos los detalles
   * importantes.
   *
   * @return Una cadena que representa los datos del producto.
   */
  @Override
  public String toString() {
    String msg;
    msg = "Producto [numeroSerie= " + numeroSerie;
    msg += ", Marca= " + marca;
    msg += ", Garantia en meses= " + garantiaMeses;

    return msg;
  }

}

