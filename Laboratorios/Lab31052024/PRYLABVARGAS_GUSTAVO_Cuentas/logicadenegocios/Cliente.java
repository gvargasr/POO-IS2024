package logicadenegocios;

import util.Comparable;

public class Cliente implements Comparable {
  // instance variables - replace the example below with your own
  private String cedula;
  private String nombre;
  private String apellido;

  /**
   * Constructor de clase Cliente Inicializa el cliente y establece la informacion inicial.
   * Configura: 1. Cedula del cliente. 2. Nombre del cliente. 3. Apellido del cliente.
   * 
   * 
   * @param String pCedula recibe String Cedula
   * @param String pNombre recibe String Nombre
   * @param String pApellido recibe String Apellido
   * 
   */
  public Cliente(String pCedula, String pNombre, String pApellido) {
    setCedula(pCedula);
    setNombre(pNombre);
    setApellido(pApellido);
  }


  public String getCedula() {
    return cedula;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setCedula(String pCedula) {
    cedula = pCedula;
  }

  public void setNombre(String pNombre) {
    nombre = pNombre;
  }

  public void setApellido(String pApellido) {
    apellido = pApellido;
  }

  /**
   * Método toString Imprime cédula y nombre completo del cliente No recibe parámetros.
   * 
   */
  public String toString() {
    String msg = "";
    msg = "Cédula: " + getCedula() + "\n";
    msg += "Nombre: " + getNombre() + " " + getApellido() + "\n";
    return msg;
  }

  /**
   * Método equals Recibe objeto de tipo Cliente y compara consigo mismo para determinar si son
   * iguales.
   * 
   * @param Object pCliente.
   * 
   */
  public boolean equals(Object pCliente) {
    if (this == pCliente) {
      return true;
    }
    if (pCliente == null) {
      return false;
    }
    if (getClass() != pCliente.getClass()) {
      return false;
    }

    Cliente cliente = (Cliente) pCliente;
    return getCedula().equals(cliente.getCedula());
  }


  /**
   * Método menorQue Recibe objeto Comparable y retorna verdadero o falso.
   * 
   * @param Comparable otroObj.
   * 
   */
  public boolean menorQue(Comparable otroObj) {
    return (getApellido().compareTo(((Cliente) otroObj).getApellido()) < 0 ? true : false);
  }
}
