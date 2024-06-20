package logicadenegocios;

/**
 * Representa a un vendedor dentro de una empresa, quien recibe un salario base y comisiones basadas
 * en un porcentaje sobre las ventas que realiza.
 */
public class Vendedor extends Empleado {
  private double porcentajeComision;


  /**
   * Constructor para crear un nuevo vendedor con la información necesaria, incluyendo el porcentaje
   * de comisión sobre las ventas.
   *
   * @param pNombre Nombre del vendedor.
   * @param pDireccion Dirección residencial del vendedor.
   * @param pTelefono Número de teléfono del vendedor.
   * @param pNumeroEmpleado Identificador único del vendedor dentro de la empresa.
   * @param pSalarioBase Salario base inicial del vendedor.
   * @param pPorcentajeComision Porcentaje de comisión que el vendedor recibe sobre las ventas.
   */
  public Vendedor(String pNombre, String pDireccion, String pTelefono, String pNumeroEmpleado,
      double pSalarioBase, double pPorcentajeComision) {
    super(pNombre, pDireccion, pTelefono, pNumeroEmpleado, pSalarioBase);
    this.porcentajeComision = pPorcentajeComision;
  }

  public double getPorcentajeComision() {
    return porcentajeComision;
  }

  /**
   * Calcula el salario total para el vendedor, considerando tanto su salario base como las
   * comisiones obtenidas de sus ventas.
   *
   * @return El salario total calculado para el vendedor, incluyendo comisiones.
   */
  public double calcularSalarioTotal() {
    return getSalarioBase() + (getSalarioBase() * porcentajeComision) / 100;
  }

  /**
   * Proporciona una representación en cadena de texto del nombre del vendedor.
   *
   * @return El nombre del vendedor.
   */
  @Override
  public String toString() {
    return this.getNombre();
  }
}
