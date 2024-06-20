import java.util.ArrayList;
import java.util.Date;

public class Temporada {
	private String detalle;
	private int numero;
	private Date fechaInicio;
	private Date fechaFin;
	private int cantidadCapitulos = 0;
	private ArrayList<Capitulo> capitulos;
	
	public Temporada(int pNumero, String pDetalle) {
		setNumero(pNumero);
		setDetalle(pDetalle);
		Date today = new Date();
		setFechaInicio(today);
		capitulos = new ArrayList<Capitulo>();
	}
	
	private void setNumero(int pNumero) {
		numero = pNumero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	private void setFechaInicio(Date pFechaInicio) {
		fechaInicio = pFechaInicio;
	}
	
	public void setFechaFin(Date pFechaFin) {
		fechaFin = pFechaFin;
	}
	
	private void setDetalle(String pDetalle) {
		detalle = pDetalle;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void agregarCapitulo(String pNombre, int pDuracion, String pSinopsis) {
		cantidadCapitulos++;
		Capitulo nuevoCapitulo = new Capitulo(pNombre, pDuracion, pSinopsis, cantidadCapitulos);
		capitulos.add(nuevoCapitulo);
	}
	
	public ArrayList<Capitulo> getCapitulos() {
	    return capitulos;  
	}
	
	public String toString() {
		String mensaje = "Temporada número: " + Integer.toString(getNumero()) + " \n";
		
		for (Capitulo capituloActual :capitulos) {
			mensaje+= capituloActual.toString() + "\n";
		}	
		return mensaje;
	}
}