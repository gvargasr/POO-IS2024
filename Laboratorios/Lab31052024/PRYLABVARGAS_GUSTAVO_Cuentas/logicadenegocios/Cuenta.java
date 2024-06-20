package logicadenegocios;

import util.Comparable;
import java.text.*;
import java.util.*;


public abstract class Cuenta implements Comparable {
  protected int numCuenta = 0;
  protected Cliente duenio = null;
  protected double saldo = 0;
  protected Date fechaCreacion;
  protected ArrayList<Operacion> operaciones;
  protected int numOperaciones = 0;
  protected String tipoCuenta;

  /**
   * Constructor de clase Cuenta Inicializa la cuenta y establece la informacion inicial. Configura:
   * 1. Nuevo Cliente. 2. Realiza el primer depósito.
   * 
   * 
   * @param Cliente pDuenio recibe Cliente pDuenio
   * @param double pMonto recibe Double pMonto
   * 
   */
  public Cuenta(String pTipo, int pNumero, Cliente pDuenio, double pMonto) {
    setTipoCuenta(pTipo);
    setNumCuenta(pNumero);
    operaciones = new ArrayList<Operacion>();
    depositar(pMonto);
    setDuenio(pDuenio);
    setFechaCreacion();
  }

  /**
   * Clase Abstracta cobrarComisiones
   */
  public abstract String cobrarComisiones();

  public int getNumCuenta() {
    return numCuenta;
  }

  public Cliente getDuenio() {
    return duenio;
  }

  public double getSaldo() {
    return saldo;
  }

  public String getFechaCreacion() {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaCreacion);
  }

  public String getTipoCuenta() {
    return tipoCuenta;
  }

  public void setNumCuenta(int pNumero) {
    numCuenta = pNumero;
  }

  public void setDuenio(Cliente pDuenio) {
    duenio = pDuenio;
  }

  public void setSaldo(double pSaldo) {
    saldo = pSaldo;
  }

  public void setFechaCreacion() {
    Calendar calendario;
    calendario = Calendar.getInstance();
    fechaCreacion = (Date) calendario.getTime();
  }

  public void setTipoCuenta(String pTipoCuenta) {
    this.tipoCuenta = pTipoCuenta;
  }

  /**
   * Método validarRetiro Verifica si el monto a retirar está disponible en el saldo de la cuenta.
   * 
   * @param double pMonto
   * @return boolean
   */
  private boolean validarRetiro(double pMonto) {
    return pMonto <= saldo;
  }



  /**
   * Método retirar Realiza un retiro de la cuenta. Verifica si el retiro es válido y luego resta el
   * monto al saldo de la cuenta.
   * 
   * 
   * @param double pMonto
   * 
   */
  public String retirar(double pMonto) {
    if (validarRetiro(pMonto)) {
      saldo -= pMonto;
      Operacion nuevaOperacion = new Operacion(++numOperaciones, "retiro  ", pMonto);
      operaciones.add(nuevaOperacion);
      return "El saldo actual: " + saldo;
    } else {
      return "No tiene suficiente dinero";
    }
  }

  /**
   * Método depositar Realiza un depósito en la cuenta. Suma el monto al saldo de la cuenta.
   * 
   * @param double pMonto
   * 
   */
  public String depositar(double pMonto) {
    saldo += pMonto;
    Operacion nuevaOperacion = new Operacion(++numOperaciones, "deposito", pMonto);
    operaciones.add(nuevaOperacion);
    return "Saldo actual: " + saldo;
  }


  /**
   * Método toString Imprime toda la informacion de la cuenta. # de cuenta. Fecha de creación.
   * Nombre y cédula del dueño. Saldo. Historial de operaciones. No recibe parámetros.
   * 
   */
  public String toString() {
    String msg;

    msg = "Cuenta Número: " + getNumCuenta() + "\n";
    msg += "Tipo: " + getTipoCuenta() + "\n";
    msg += "Fecha creada: " + getFechaCreacion() + "\n";
    msg += duenio.toString() + "\n";
    msg += "Saldo: " + getSaldo() + "\n";
    msg += "Registro de Operaciones" + "\n";
    msg += "Número " + "\tFecha " + "\t\tOperación " + "\tMonto " + "\n";
    for (int i = 0; i < operaciones.size(); i++) {
      Operacion unaOp = (Operacion) operaciones.get(i);
      msg += unaOp.toString();
    }
    return msg;
  }


  /**
   * Método equals Recibe objeto de tipo Cuenta y compara consigo mismo para determinar si son
   * iguales.
   * 
   * @param Object pCuenta.
   * 
   */
  public boolean equals(Object pCuenta) {
    if (this == pCuenta) {
      return true;
    }
    if (pCuenta == null) {
      return false;
    }
    if (getClass() != pCuenta.getClass()) {
      return false;
    }

    Cuenta cuenta = (Cuenta) pCuenta;

    return getNumCuenta() == cuenta.getNumCuenta();
  }

  /**
   * Método menorQue Recibe objeto Comparable y retorna verdadero o falso.
   * 
   * @param Comparable otroObj.
   * 
   */
  public boolean menorQue(Comparable pOtroObjeto) {
    return getSaldo() < ((Cuenta) pOtroObjeto).getSaldo();
  }

}
