package logicadenegocios;

/**
 * Representa a un empleado dentro de una empresa. Cada empleado tiene asociados detalles personales
 * y laborales como su nombre, dirección, teléfono, número de empleado y salario base.
 */
public class Empleado {
  private String nombre;
  private String direccion;
  private String telefono;
  private String numeroEmpleado;
  private double salarioBase;

  /**
   * Constructor para crear un nuevo empleado con toda la información requerida.
   *
   * @param pNombre Nombre del empleado.
   * @param pDireccion Dirección residencial del empleado.
   * @param pTelefono Número de teléfono del empleado.
   * @param pNumeroEmpleado Identificador único del empleado dentro de la empresa.
   * @param pSalarioBase Salario base inicial del empleado.
   */
  public Empleado(String pNombre, String pDireccion, String pTelefono, String pNumeroEmpleado,
      double pSalarioBase) {
    this.nombre = pNombre;
    this.direccion = pDireccion;
    this.telefono = pTelefono;
    this.numeroEmpleado = pNumeroEmpleado;
    this.setSalarioBase(pSalarioBase);
  }

  // Getter y Setter
  public String getNumeroEmpleado() {
    return numeroEmpleado;
  }

  public void setNumeroEmpleado(String numeroEmpleado) {
    this.numeroEmpleado = numeroEmpleado;
  }

  /**
   * @return the salarioBase
   */
  public double getSalarioBase() {
    return salarioBase;
  }

  /**
   * @param salarioBase the salarioBase to set
   */
  public void setSalarioBase(double salarioBase) {
    this.salarioBase = salarioBase;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the telefono
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Proporciona una representación en cadena de texto de la información del empleado, incluyendo su
   * nombre, dirección, teléfono, número de empleado y salario base.
   *
   * @return Una cadena que representa los datos del empleado.
   */
  @Override
  public String toString() {
    return "\nNombre= " + nombre + ", direccion= " + direccion + ", telefono= " + telefono
        + ", numeroEmpleado= " + numeroEmpleado + ", salarioBase= " + salarioBase;
  }


}
