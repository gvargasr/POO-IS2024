import java.util.ArrayList;

public class Capitulo {
    private int numero;
    private String nombre;
    private int duracionMinutos;
    private String sinopsis;
    private ArrayList<Actor> actores;
    
    public Capitulo(String pNombre, int pDuracion, String pSinopsis, int pNumero) {
        numero = pNumero;
        nombre = pNombre;
        duracionMinutos = pDuracion;
        sinopsis = pSinopsis;
        actores = new ArrayList<Actor>();
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
    
    public String toString() {
        String mensaje;
        mensaje = "CAPITULO - Nombre: " + nombre  + " \n Sinopsis: "+ sinopsis + " duracion: " + Integer.toString(duracionMinutos) + "\n";
        for (Actor actorActual :actores) {
	        mensaje+= actorActual.toString() + "\n";
	}	
	return mensaje;
    }
}