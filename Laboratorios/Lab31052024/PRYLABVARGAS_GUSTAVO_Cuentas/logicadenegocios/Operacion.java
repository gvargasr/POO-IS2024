package logicadenegocios;

import java.text.*;
import java.util.*;



public class Operacion {
  // instance variables - replace the example below with your own
  private int numero;
  private String tipo;
  private double monto;
  private Date fechaOperacion;

  /**
   * Constructor de clase Operacion
   * 
   * @param int pNumero recibe int pNumero (# de Operación)
   * @param String pTipo recibe String pTipo (Retiro o depósito)
   * @param double pMonto recibe double pMonto Inicializa la cuenta y establece la información
   *        inicial. Configura: 1. Añade # de operación. 2. Configura si es retiro o depósito. 3.
   *        Suma o resta pMonto al saldo de la cuenta.
   */
  public Operacion(int pNumero, String pTipo, double pMonto) {
    // initialise instance variables
    setNumero(pNumero);
    setTipo(pTipo);
    setMonto(pMonto);
    setFechaOperacion();
  }

  public int getNumero() {
    return numero;
  }

  public String getTipo() {
    return tipo;
  }

  public double getMonto() {
    return monto;
  }

  public String getFechaOperacion() {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaOperacion);
  }

  public void setNumero(int pNumero) {
    numero = pNumero;
  }

  public void setTipo(String pTipo) {
    tipo = pTipo;
  }

  public void setMonto(double pMonto) {
    monto = pMonto;
  }

  public void setFechaOperacion() {
    Calendar calendario;
    calendario = Calendar.getInstance();
    fechaOperacion = (Date) calendario.getTime();
  }


  /**
   * Método toString Imprime toda la informacion de la operación. # de operación. Fecha de la
   * operación. Retiro o depósito Monto. No recibe parámetros.
   */
  public String toString() {
    String msg;
    msg = getNumero() + "\t" + getFechaOperacion() + "\t" + getTipo() + "\t" + getMonto() + "\n";
    return msg;
  }
}
