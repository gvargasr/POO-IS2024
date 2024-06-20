package tarea3;

import java.util.*;
import java.util.ArrayList;

public class Serie {
  private String nombre;
  private Date fechaLanzamiento;
  private double presupuestoInicial;
  private int cantidadTemporadas = 0;
  private ArrayList<Productor> productores;
  private ArrayList<Temporada> temporadas;
  private Estado estado;

  public Serie(String pNombre, double pPresupuesto) {
    setNombre(pNombre);
    setPresupuesto(pPresupuesto);
    Date today = new Date();
    setfechaLanzamiento(today);
    productores = new ArrayList<>();
    temporadas = new ArrayList<>();
    estado = Estado.EN_PRODUCCION;
  }

  public String getNombre() {
    return nombre;
  }

  public Date getfechaLanzamiento() {
    return fechaLanzamiento;
  }

  private void setNombre(String pNombre) {
    nombre = pNombre;
  }

  private void setPresupuesto(double pPresupuesto) {
    presupuestoInicial = pPresupuesto;
  }

  private void setfechaLanzamiento(Date pfechaLanzamiento) {
    fechaLanzamiento = pfechaLanzamiento;
  }

  public ArrayList<Temporada> getTemporadas() {
    return temporadas;
  }

  public void agregarTemporada(String pDetalle) {
    cantidadTemporadas++;
    Temporada nuevaTemporada = new Temporada(cantidadTemporadas, pDetalle);
    temporadas.add(nuevaTemporada);
  }

  public void agregarCapitulo(String pNombre, int pDuracion, String pSinopsis, int idTemporada,
      Set pSet) {
    for (Temporada temporadaActual : temporadas) {
      if (temporadaActual.getNumero() == idTemporada) {
        temporadaActual.agregarCapitulo(pNombre, pDuracion, pSinopsis, pSet);
      }
    }
  }

  public void agregarActor(Actor pActor, int pIdCapitulo, int pIdTemporada) {
    for (Temporada temporadaActual : temporadas) {
      if (temporadaActual.getNumero() == pIdTemporada) {

        ArrayList<Capitulo> capitulos = temporadaActual.getCapitulos();
        for (Capitulo capituloActual : capitulos) {
          if (capituloActual.getNumero() == pIdCapitulo) {
            capituloActual.agreagarActor(pActor);
          }
        }
      }
    }
  }

  public void agregarProductor(Productor pProductor) {
    productores.add(pProductor);
  }

  public String toString() {
    String mensaje = "Nombre de la serie: " + getNombre() + ", inicia en: "
        + getfechaLanzamiento().toString() + "\n";
    for (Productor productorActual : productores) {
      mensaje += productorActual.toString() + "\n";
    }
    for (Temporada temporadaActual : temporadas) {
      mensaje += temporadaActual.toString() + "\n";
    }
    return mensaje;
  }
}
