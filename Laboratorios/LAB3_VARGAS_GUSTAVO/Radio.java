
import java.util.Random;

/**
 * Abstracción de la clase Radio para efectos académicos.
 * 
 * @author Gustavo Vargas 
 * @version 1.0
 */
public class Radio {
  // atributos de instancia o no estáticos.
  private String marca;
  private boolean estaEncendido;
  private double frecuencia;
  private String banda;
  private int volumen;
  private Disco disco;
  
  // atributos de clase o estáticos
  private static int cantRadios = 0;
  private static final double RANGOS_FRECUENCIA[] = new double[] {80.1, 107.5};
  private static final String BANDAS_DISPONIBLES[] = new String[] {"AM", "FM", "FM2"};
  
  
  public Radio(String pMarca){
    // inicializar atributos de instancia
    marca = pMarca;
    estaEncendido = false;
    frecuencia = 80.1;
    banda = "AM";
    volumen = 0;
    
    // Incrementar el contador de radios accediendoa un atributo de la clase
    cantRadios++;
  }
  
  public boolean encender() {
    return (estaEncendido = true);
  }
  
  public boolean apagar() {
      return (estaEncendido = false);
  }
  
  public void cambiarFrecuencia(double pFrecuencia) {
    if(estaEncendido && verificarFrecuencia(pFrecuencia)){
      frecuencia = pFrecuencia;  
    }
  }
  
  public void cambiarFrecuencia() {
    Random randomObject = new Random();
    double frecuencia = 80.1 + (107.5 - 80.1) * randomObject.nextDouble();
    
    if(estaEncendido && verificarFrecuencia(frecuencia)) {
      this.frecuencia = frecuencia;  
    }
  }
  
  public void cambiarBanda(String pBanda) {
    if(estaEncendido && verificarBanda(pBanda)) {
      banda = pBanda;  
    }
  }
  
  public int subirVolumen() {
    if(estaEncendido) {
      volumen+=1;  
    }
    return volumen;
  }
  
  public int bajarVolumen() {
  if(estaEncendido) {
    volumen-=1;  
  }
  return volumen;
  }
  
  public String reproducir() {
    if(estaEncendido && tieneDisco()) {
      return "Reproduciendo pista 1";  
    }
    return "Radio is turn off | No disc.";
  }
  
  public String reproducir(int pPista) {
    if(estaEncendido && tieneDisco() && disco.getCantidadCanciones() >= pPista) {
      return "Reproduciendo pista " + pPista;  
    }
    return "Radio is turn off | No disc. | No valid track";      
  }
  
  // Contexto NO estatico
  // Puedo acceder:
  // Miembros estaticos (atributos y metodos) y Miembros no estaticos (atributos y metodos)
  public String insertarDisco(Disco pDisco) {
    if (estaEncendido) {
      disco = pDisco;
      return disco.toString();
    }
    return "Radio is off.";
  }
  
  private boolean verificarFrecuencia(double pFrecuencia){
    return (pFrecuencia >= RANGOS_FRECUENCIA[0] && pFrecuencia <= RANGOS_FRECUENCIA[1]? true : false);    
  }
  
  // NOTA:
  // Para tipos primitivos el uso del operador de == funciona OK   int = 5; i == 5 --> TRUE
  // Para tipos de datos referenciados el uso de == lo que hace es comparar las direcciones de memoria de los objetos
  // String cadena1 = "Luis"; String cadena2 = "Luis";   cadena1 == cadena2 --> F
  // Porque ambas cadenas estan en posiciones de memoria distintas. Se debe usar el '.equals'
  private boolean verificarBanda(String pBanda) {
    for (String bandaActual: BANDAS_DISPONIBLES) {
      if(bandaActual.equals(pBanda)) {
        return true;  
      }
    }
    return false;
  }
  
  private boolean tieneDisco(){
    return (disco != null? true : false);  
  }
  
  // Contexto estático: acceder a atributos estáticos y métodos estáticos solamente
  public static int getCantidadRadios() {
    return cantRadios;
  }
  
}
