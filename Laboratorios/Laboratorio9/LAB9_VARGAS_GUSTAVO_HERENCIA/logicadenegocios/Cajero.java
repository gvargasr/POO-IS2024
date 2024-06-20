package logicadenegocios;

/**
 * Representa a un cajero dentro de una empresa, quien además de su salario base, recibe un monto
 * adicional por cada año de antigüedad en la empresa.
 */
public class Cajero extends Empleado {
  private int anosAntiguedad;
  private double montoAnualidad; // Monto adicional por año de antigüedad

  /**
   * Constructor para crear un nuevo cajero con toda la información requerida, incluyendo los años
   * de antigüedad y el monto adicional por antigüedad.
   *
   * @param pNombre Nombre del cajero.
   * @param pDireccion Dirección residencial del cajero.
   * @param pTelefono Número de teléfono del cajero.
   * @param pNumeroEmpleado Identificador único del cajero dentro de la empresa.
   * @param pSalarioBase Salario base inicial del cajero.
   * @param pAnosAntiguedad Número de años que el cajero ha trabajado en la empresa.
   * @param pMontoAnualidad Monto adicional que recibe el cajero por cada año de antigüedad.
   */
  public Cajero(String pNombre, String pDireccion, String pTelefono, String pNumeroEmpleado,
      double pSalarioBase, int pAnosAntiguedad, double pMontoAnualidad) {
    super(pNombre, pDireccion, pTelefono, pNumeroEmpleado, pSalarioBase);
    this.anosAntiguedad = pAnosAntiguedad;
    this.montoAnualidad = pMontoAnualidad;
  }

  public int getAnosAntiguedad() {
    return anosAntiguedad;
  }

  public double getMontoAnualidad() {
    return montoAnualidad;
  }

  /**
   * Calcula el salario total para el cajero, considerando su salario base y un monto adicional que
   * depende de su antigüedad en la empresa.
   *
   * @return El salario total calculado para el cajero.
   */
  public double calcularSalarioTotal() {
    return getSalarioBase() + (anosAntiguedad * montoAnualidad);
  }

  /**
   * Proporciona una representación en cadena de texto del nombre del cajero.
   *
   * @return El nombre del cajero.
   */
  @Override
  public String toString() {
    return this.getNombre();
  }
}
