import java.util.*;
import java.lang.*;
import java.util.ArrayList;

public class Serie {
    private String nombre;
    private Date fechaInicio;
    private int cantidadTemporadas = 0;
    private ArrayList<Temporada> temporadas;
        
    public Serie(String pNombre) {
        setNombre(pNombre);
        Date today = new Date();
        setFechaInicio(today);
        temporadas = new ArrayList<Temporada>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    private void setNombre(String pNombre) {
        nombre = pNombre;
    }

    private void setFechaInicio(Date pFechaInicio) {
        fechaInicio = pFechaInicio;
    }
    
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    public void agregarTemporada(String pDetalle) {
        cantidadTemporadas++;
        Temporada nuevaTemporada = new Temporada(cantidadTemporadas, pDetalle);
        temporadas.add(nuevaTemporada);     
    }
    
    public void agregarCapitulo(String pNombre, int pDuracion, String pSinopsis, int idTemporada) {
        for (Temporada temporadaActual :temporadas) {
           if (temporadaActual.getNumero() == idTemporada) {
               temporadaActual.agregarCapitulo(pNombre, pDuracion, pSinopsis);     
           }
        }
    }
    
    public void agregarActor(Actor pActor, int pIdCapitulo, int pIdTemporada) {
        for (Temporada temporadaActual :temporadas) {
           if (temporadaActual.getNumero() == pIdTemporada) {
               ArrayList<Capitulo> capitulos = temporadaActual.getCapitulos();
               for (Capitulo capituloActual:capitulos) {
                   if (capituloActual.getNumero() == pIdCapitulo) {
                       capituloActual.agreagarActor(pActor);
                    }
               } 
           }
        }
    }
    
    public String toString() {
        String mensaje = "Nombre de la serie: " + getNombre() + ", inicia en: " +
                         getFechaInicio().toString() + "\n";
        
        for (Temporada temporadaActual :temporadas) {
            mensaje+= temporadaActual.toString() + "\n";
        }
        return mensaje;
    }
}