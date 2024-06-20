package logicadenegocios;

import java.util.Calendar;


/**
 * Clase hija CuentaAhorro
 * 
 * @author Gustavo Vargas
 * @version 31052024
 */
public class CuentaAhorro extends Cuenta {
  private static int scantCuentas = 0;
  private double cuotaMantenimiento;

  /**
   * Constructor de CuentaAhorro
   */
  public CuentaAhorro(Cliente pDuenio, double pMonto) {
    super("Cuenta de Ahorro", ++scantCuentas, pDuenio, pMonto);
    setCuotaMantenimiento(300); // cuota de mantenimiento por omision.
  }

  public int getSCantCuentas() {
    return scantCuentas;
  }

  public double getCuotaMantenimiento() {
    return cuotaMantenimiento;
  }

  public void setCuotaMantenimiento(double pCuota) {
    cuotaMantenimiento = pCuota;
  }

  public String cobrarComisiones() {
    String msg = " ";
    Calendar calendario;
    calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    if (dia == 1) {
      retirar(cuotaMantenimiento);
      numOperaciones = 0; // se reinicia para el mes siguiente el num de operaciones
      msg = " Se cobro por comision : " + cuotaMantenimiento;
    }
    return msg;
  }
}
