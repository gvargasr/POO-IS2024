package logicadenegocios;

import java.util.Date;
import java.util.Calendar;

public class Mensaje {
  private int numero;
  private String mensaje;
  private char tipo;
  private Date fecha;
  
  public Mensaje(int pNumero, char pTipo, String pMensaje) {
    this.numero = pNumero;
    this.mensaje = pMensaje;
    this.tipo = pTipo;
    this.fecha = Calendar.getInstance().getTime();
  }
  
  public String toString() {
    String msg = "";
    msg+= ("Tipo de mensaje: " + this.tipo);
    msg+= ("Numero: " + this.numero);
    msg+= ("Mensaje: " + this.mensaje);
    msg+= ("Fecha y hora: " + this.fecha.toString());
    
    return msg;
  }
  
  public String getMensaje() {
    return mensaje;  
  }
  
  public char getTipo() {
     return tipo; 
  }
  
  public int getNumero() {
    return numero;  
  }
      
}