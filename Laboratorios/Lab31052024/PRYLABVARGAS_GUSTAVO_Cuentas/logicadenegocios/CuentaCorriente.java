package logicadenegocios;

import java.util.Calendar;

/**
 * Clase hija CuentaCorriente
 * 
 * @author Gustavo Vargas
 * @version 31052024
 */
public class CuentaCorriente extends Cuenta {
  private static int scantCuentas = 0;
  private int operacionesExentas;
  private double cuotaOperaciones;

  /**
   * Constructor de clase CuentaCorriente
   */
  public CuentaCorriente(Cliente pDuenio, double pMonto) {
    super("Cuenta Corriente", ++scantCuentas, pDuenio, pMonto);
    setOperacionesExentas(30); // operaciones exentas por omisión
    setCuotaOperaciones(30); // Cuota por operaciones por omisión
  }

  public CuentaCorriente(Cliente pDuenio, double pMonto, int pOperExentas, double pCuotaOper) {
    super("Cuenta Corriente", ++scantCuentas, pDuenio, pMonto);
    setOperacionesExentas(pOperExentas);
    setCuotaOperaciones(pCuotaOper);
  }

  public int getSCantCuentas() {
    return scantCuentas;
  }

  public int getOperacionesExentas() {
    return operacionesExentas;
  }

  public double getCuotaOperaciones() {
    return cuotaOperaciones;
  }

  public void setOperacionesExentas(int pOperaciones) {
    operacionesExentas = pOperaciones;
  }

  public void setCuotaOperaciones(double pCuota) {
    cuotaOperaciones = pCuota;
  }

  public String cobrarComisiones() {
    String msg = " ";
    int operacNoExentas;
    double monto;
    Calendar calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    if (dia == 1) {
      operacNoExentas = numOperaciones - getOperacionesExentas();
      if (operacNoExentas > 0) {
        monto = getCuotaOperaciones() * operacNoExentas;
        retirar(monto);
        msg = " Se cobró por comisión : " + monto;
      }
      numOperaciones = 0; // Se reinicia para el mes siguiente
    }
    return msg;
  }
}
