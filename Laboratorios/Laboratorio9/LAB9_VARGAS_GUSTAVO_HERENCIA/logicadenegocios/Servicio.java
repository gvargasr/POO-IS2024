package logicadenegocios;

/**
 * Clase que representa un servicio, extendiendo la clase {@code Item}.
 * Un {@code Servicio} incluye detalles específicos como el técnico que lo atiende,
 * el período de garantía en meses y los costos asociados con consumibles necesarios 
 * para el servicio.
 */
public class Servicio extends Item {
  private Empleado tecnico;
  private int garantiaMeses;
  private double precioConsumibles; // Nuevo campo para los consumibles

  /**
   * Constructor para crear un servicio sin especificar técnico.
   *
   * @param descripcion Descripción breve del servicio, heredada de {@code Item}.
   * @param precio Precio base del servicio, heredado de {@code Item}.
   * @param garantiaMeses Número de meses que dura la garantía del servicio.
   * @param precioConsumibles Precio de los consumibles utilizados en el servicio.
   */
  public Servicio(String descripcion, double precio, int garantiaMeses, double precioConsumibles) {
    super(descripcion, precio);
    this.tecnico = null;
    this.garantiaMeses = garantiaMeses;
    this.precioConsumibles = precioConsumibles; // Inicializar el nuevo campo
  }

  /**
   * Constructor para crear un servicio especificando el técnico.
   *
   * @param descripcion Descripción del servicio, heredada de {@code Item}.
   * @param precio Precio base del servicio, heredado de {@code Item}.
   * @param pTecnico Técnico que atiende el servicio.
   * @param garantiaMeses Número de meses que dura la garantía del servicio.
   * @param precioConsumibles Precio de los consumibles utilizados en el servicio.
   */
  public Servicio(String descripcion, double precio, Tecnico pTecnico, int garantiaMeses,
      double precioConsumibles) {
    super(descripcion, precio);
    this.tecnico = pTecnico;
    this.garantiaMeses = garantiaMeses;
    this.precioConsumibles = precioConsumibles; // Inicializar el nuevo campo
  }

  public Empleado getTecnico() {
    return tecnico;
  }

  public int getGarantiaMeses() {
    return garantiaMeses;
  }

  public double getPrecioConsumibles() {
    return precioConsumibles;
  }

  /**
   * Asigna el tecnico al servicio.
   * @param pTecnico Objeto Tecnico.
   */
  public void asignarTecnico(Empleado pTecnico) {
    this.tecnico = pTecnico;
  }

  public void setGarantiaMeses(int garantiaMeses) {
    this.garantiaMeses = garantiaMeses;
  }

  public void setPrecioConsumibles(double precioConsumibles) {
    this.precioConsumibles = precioConsumibles;
  }

  @Override
  public double getPrecio() {
    // Calcular el precio final incluyendo el precio base y los consumibles
    return super.getPrecio() + precioConsumibles;
  }

  @Override
  /**
   * Genera una representación en forma de String del Servicio, mostrando todos los detalles
   * importantes.
   *
   * @return Una cadena que representa los datos del Servicio.
   */

  public String toString() {
    String msg;
    msg = "Servicio [Descripcion= " + super.toString();
    msg += ", Garantía (meses): " + garantiaMeses;
    msg += ", Precio Servicio:  " + super.getPrecio();
    msg += ", Precio Consumibles: " + precioConsumibles;

    return msg;
  }
}
