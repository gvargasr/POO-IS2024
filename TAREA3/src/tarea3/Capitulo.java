package tarea3;

import java.util.*;
import java.lang.*;
import java.util.Date;

public class Capitulo {
  private int numero;
  private String nombre;
  private Date fechaEstreno;
  private int duracionMinutos;
  private String sinopsis;
  private ArrayList<Actor> actores;
  private Set set;

  public Capitulo(String pNombre, int pDuracion, String pSinopsis, int pNumero, Set pSet) {
    numero = pNumero;
    nombre = pNombre;
    Date today = new Date();
    setFechaEstreno(today);
    duracionMinutos = pDuracion;
    sinopsis = pSinopsis;
    actores = new ArrayList<Actor>();
    set = pSet;
  }
  
  private void setFechaEstreno(Date pFechaEstreno) {
    fechaEstreno = pFechaEstreno;
  }

  public int getNumero() {
    return numero;
  }

  public ArrayList<Actor> getActores() {
    return actores;
  }

  public void agreagarActor(Actor pActor) {
    actores.add(pActor);
  }
  
  public void agregarSet(Set pSet) {
    set = pSet;
  }
  

  public String toString() {
    String mensaje;
    mensaje = "CAPITULO - Nombre: " + nombre + " \n Sinopsis: " + sinopsis + " duracion: "
        + Integer.toString(duracionMinutos) + " minutos.\n" ;
    for (Actor actorActual : actores) {
      mensaje += actorActual.toString() + "\n" ;
    }
    return mensaje;
  }
}
