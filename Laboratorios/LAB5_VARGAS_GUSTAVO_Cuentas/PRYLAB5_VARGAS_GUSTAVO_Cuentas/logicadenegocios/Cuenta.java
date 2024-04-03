package logicadenegocios;

import java.text.*;
import java.util.*;


public class Cuenta { 
  private static int cantCuenta = 0;
  private int numCuenta = 0;
  private Cliente duenio = null;
  private double saldo = 0;
  private ArrayList<Operacion> operaciones;
  private int numOperaciones = 0;
  private Date fechaCreacion;
  
  /**
   * Constructor de clase Cuenta
   * Inicializa la cuenta y establece la informacion inicial.
   * Configura:
   * 1. Nuevo Cliente.
   * 2. Realiza el primer depósito.
   * 
   * 
   * @param Cliente pDuenio recibe Cliente pDuenio 
   * @param double pMonto recibe Double pMonto 
   * 
  */
  public Cuenta(Cliente pDuenio, double pMonto) {
    setDuenio(pDuenio);
    operaciones = new ArrayList<Operacion>();
    setFechaCreacion();
    setNumCuenta();
    depositar(pMonto);
  }
  
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
  
  public void setNumCuenta() {
    cantCuenta++;
    numCuenta = cantCuenta;  
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
  
  /**
   * Método validarRetiro
   * Verifica si el monto a retirar está disponible en el saldo de la cuenta.
   * 
   * @param 
   * double pMonto
   * @return boolean
  */
  private boolean validarRetiro(double pMonto) {
    return pMonto <= saldo;  
  }
  
  
  
  
  /**
   * Método retirar
   * Realiza un retiro de la cuenta.
   * Verifica si el retiro es válido y luego resta el monto al saldo de la cuenta.
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
   * Método depositar
   * Realiza un depósito en la cuenta.
   * Suma el monto al saldo de la cuenta.
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
   * Método toString
   * Imprime toda la informacion de la cuenta.
   * # de cuenta.
   * Fecha de creación.
   * Nombre y cédula del dueño.
   * Saldo.
   * Historial de operaciones.
   * No recibe parámetros. 
   * 
  */
  public String toString() {
    String msg;
    
    msg = "Cuenta Número: " + getNumCuenta() + "\n";
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
   * Método equals
   * Recibe objeto de tipo Cuenta y compara consigo mismo para determinar si son iguales.
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
  
}
