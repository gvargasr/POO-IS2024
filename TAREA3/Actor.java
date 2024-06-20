
public class Actor {
	private String nombre;
	private int identificacion;
	private static int cantidadActores = 0;
	
	public Actor(String pNombre) {
		cantidadActores++;
		setNombre(pNombre);
		setIdentificacion(cantidadActores);
	}
	
	private void setNombre(String pNombre) {
		nombre = pNombre;
	}
	
	private void setIdentificacion(int pCantidadActores) {
		identificacion = pCantidadActores;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getIdentificacion() {
		return identificacion;
	}
	
	public String toString() {
		return "Actor: " + getNombre() + ", identificación: " + Integer.toString(getIdentificacion());
	}
}