import java.util.ArrayList;

public class Disco {
  // Atributos de instancia / no estáticos
  private String autor;
  private ArrayList<String> canciones;
  
  // Atributo de clase - estático
  // Se generan en tiempo de compilación
  private static int cantidadDiscos = 0;
  
  // Método constructor
  public Disco(String pAutor) {
    autor = pAutor;
    canciones = new ArrayList<String>();
    cantidadDiscos++;
  }
  
  public void agregarCancion(String pCancion) {
    canciones.add(pCancion);
  }
  
  public int getCantidadCanciones() {
    return canciones.size(); 
  }
  
  // El método to String ofrece una representación del estado de un objeto
  // accediendo al valor de sus partes
  public String toString() {
    String cadena;
    
    cadena = "Autor " + autor;
    cadena+= "\n **** Lista de canciones **** ";
    for (String cancion: canciones){
      cadena+= ("\n " + cancion);
    }
    return cadena;
  }

}
