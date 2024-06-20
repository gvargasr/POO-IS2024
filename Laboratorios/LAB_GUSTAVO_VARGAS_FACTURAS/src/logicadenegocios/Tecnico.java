package logicadenegocios;

/**
 * Representa a un técnico, que es un tipo especializado de empleado dentro de una empresa. Los
 * técnicos pueden recibir pago por horas extra además de su salario base.
 */
public class Tecnico extends Empleado {
  private double salarioHoraExtra;


  /**
   * Constructor para crear un nuevo técnico con toda la información requerida incluyendo el pago
   * por horas extra.
   *
   * @param pNombre Nombre del técnico.
   * @param pDireccion Dirección residencial del técnico.
   * @param pTelefono Número de teléfono del técnico.
   * @param pNumeroEmpleado Identificador único del técnico dentro de la empresa.
   * @param pSalarioBase Salario base inicial del técnico.
   * @param pSalarioHoraExtra Pago adicional por cada hora extra trabajada por el técnico.
   */
  public Tecnico(String pNombre, String pDireccion, String pTelefono, String pNumeroEmpleado,
      double pSalarioBase, double pSalarioHoraExtra) {
    super(pNombre, pDireccion, pTelefono, pNumeroEmpleado, pSalarioBase);
    this.salarioHoraExtra = pSalarioHoraExtra;
  }

  public double getSalarioHoraExtra() {
    return salarioHoraExtra;
  }

  /**
   * Calcula el salario total para el técnico, incluyendo el pago por horas extra. Este método
   * debería ser implementado para considerar correctamente las horas trabajadas en el período de
   * pago actual.
   *
   * @return El salario total calculado para el técnico, incluyendo salario base y horas extra.
   */
  public double calcularSalarioTotal() {
    return getSalarioHoraExtra() + getSalarioBase();
  }

  /**
   * Proporciona una representación en cadena de texto de la información del técnico, incluyendo los
   * atributos de un empleado general más el detalle del pago por horas extra.
   *
   * @return Una cadena que representa los datos del técnico.
   */
  @Override
  public String toString() {
    return "Tecnico: " + super.toString() + ", " + "salarioHoraExtra= " + salarioHoraExtra;
  }
}

