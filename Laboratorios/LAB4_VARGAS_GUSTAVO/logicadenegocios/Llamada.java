package logicadenegocios;

import java.util.Calendar;
import java.util.Date;

public class Llamada {
  private int numero;
  private int duracion;
  private char tipo;
  private Date fecha;
  
  public Llamada(int pNumero, int pDuracion, char pTipo) {
    this.numero = pNumero;
    this.duracion = pDuracion;
    this.tipo = pTipo;
    this.fecha = Calendar.getInstance().getTime();
  }
  
  public String toString() {
    String msg = "";
    msg+= ("Tipo de llamada: " + this.tipo);
    msg+= ("Numero: " + this.numero);
    msg+= ("Duración: " + this.duracion);
    msg+= ("Fecha y hora: " + this.fecha.toString());
    
    return msg;
  }
  
  public int getNumero() {
    return numero;
  }
  
  public Date getFecha() {
    return fecha;  
  }
  
  public int getTipo() {
    return tipo;  
  }

}
