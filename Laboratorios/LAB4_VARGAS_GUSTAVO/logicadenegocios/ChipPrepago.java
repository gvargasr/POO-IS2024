/***
 * Esta clase es una abstraccion de un ChipPrepago y su finalidad es
 * simular su estructura y comportamiento con fines academicos
 * 
 * @author Gustavo Vargas 
 * @version 1.0
 */



package logicadenegocios;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;
import logicadenegocios.Mensaje;
import logicadenegocios.Llamada;
import logicadenegocios.Cliente;


public class ChipPrepago {
  // Atributos estaticos o de clase
  private static int cantidadChips = 0;
  private static final int CODIGO_PAIS = 506;
  public static TreeSet<Integer> contenedorNumeros = new TreeSet<Integer>();
  
  // Atributos no estaticos o de instancia
  private double saldo;
  private int numeroTelefonico;
  private String operadorCelular;
  
  // Relaciones estructurales con otras clases
  private ArrayList<Llamada> llamadas;
  private ArrayList<Mensaje> mensajes;
  private ArrayList<String> historialNavegacion;
  private Cliente duenoChip;
  
  private double gigaBytesDisponibles;
  private int cantidadSalvemeRealizados = 0;
  private boolean chipActivado = false;
  private Date fechaActivacion;
  
  // Metodo constructor
  public ChipPrepago(String pOperador) {
    saldo = 0;
    operadorCelular = pOperador;
    llamadas = new ArrayList<Llamada>();
    mensajes = new ArrayList<Mensaje>();
    historialNavegacion = new ArrayList<String>();
    cantidadChips++;
  }
  
  /***
   *  Req 1
   */
  public void activar(Cliente pDueno, double pGigaBytesContratados) {
    if (! estaActivo()) {
      this.chipActivado = true;
      recargar(1000);
      this.duenoChip = pDueno;
      this.gigaBytesDisponibles = pGigaBytesContratados;
      // Una relacion de dependencia
      this.fechaActivacion = Calendar.getInstance().getTime();
      
      do {
        int numeroPropuesto = generarNumeroTelefonoRandom();
        if (contenedorNumeros.contains(numeroPropuesto) == false) {
          contenedorNumeros.add(numeroPropuesto);
          numeroTelefonico = numeroPropuesto;
          break;
        }
      }
      while(true);
    }
  }
  
  public void activar(Cliente pDueno) {
    activar(pDueno, 0.0);  
  }
  
  /***
   * Este permite consultar el saldo disponible del chip
   * @return saldo del chip para realizar llamadas y mensajes
   */

  // retorna la infomacion del numero telefonico.
  public int getNumero() {
    return this.numeroTelefonico;  
  }
  
  /* Req 2 */
  public double consultarSaldo() {
    return this.saldo;  
  }
  
  /* Req 3 */
  public double consultarDatosDisponibles() {
    return this.gigaBytesDisponibles;  
  }
  
  /* Req 4 */
  public double recargarDatos(double pGigas) {
    if (estaActivo() && pGigas > 0) {
      gigaBytesDisponibles = gigaBytesDisponibles + pGigas;
    }
    return gigaBytesDisponibles;
  }
  
  /* Req 5 */ 
  public double recargar(double pMonto) {
    if (estaActivo() && pMonto > 0) {
      saldo = saldo + pMonto;  
    }
    return saldo;
  }
  
  /* Req 6 */ 
  public boolean salveme() {
    if (estaActivo() && this.cantidadSalvemeRealizados < 3 && saldo == 0) {
      recargar(100);
      cantidadSalvemeRealizados+= 1;
      return true;
    }
    return false;
  }
  
  /* Req 7 */
  public double llamar(int pMinutos, ChipPrepago pChipDestino) {
    Llamada llamadaSaliente = new Llamada(pChipDestino.getNumero(), pMinutos, 'S');
    Llamada llamadaEntrante = new Llamada(this.getNumero(), pMinutos, 'E');
    
    if (estaActivo() && pChipDestino.estaActivo()) {
      if (pChipDestino.getNumero() != 911 && esSaldoDisponible(pMinutos * 30)) {
        aplicarCobro(pMinutos * 30);  
      }
      agregarLlamada(llamadaSaliente);
      pChipDestino.agregarLlamada(llamadaEntrante);
    }
    
    return saldo;
  }
  
  /* Req 8 */
  public ArrayList<Llamada> consultarHistorialLlamadasRealizadas() {
    ArrayList<Llamada> historialLlamadasRealizadas = new ArrayList<Llamada>();
    
    // Iterar sobre una coleccion de llamdas mediante un ciclo for.
    for (Llamada llamada: llamadas) {
      if (llamada.getTipo() == 'S') {
        historialLlamadasRealizadas.add(llamada);  
      }
    }
    return historialLlamadasRealizadas;
  }
  
  /* Req 9 */
  public ArrayList<Llamada> consultarHistorialLlamadasRealizadas(int pNumero) {
    ArrayList<Llamada> historialLlamadasRealizadas = new ArrayList<Llamada>();
    
    // Iterar sobre una coleccion de llamadas mediante un ciclo for.
    for (Llamada llamada: llamadas) {
      if (llamada.getTipo() == 'S' && llamada.getNumero() == pNumero) {
        historialLlamadasRealizadas.add(llamada);  
      }
    }
    return historialLlamadasRealizadas;
  }
  
  /* Req 10 */
  public ArrayList<Llamada> consultarHistorialLlamadasRecibidas() {
    ArrayList<Llamada> historialLlamadasEntrantes = new ArrayList<Llamada>();
    
    // Iterar sobre una coleccion de llamadas mediante un for
    for (Llamada llamada: llamadas) {
      if (llamada.getTipo() == 'E') {
        historialLlamadasEntrantes.add(llamada);  
      }
    }
    return historialLlamadasEntrantes;
  }
  
  /* Req 11 */
  public ArrayList<Llamada> consultarHistorialLlamadasRecibidas(int pNumero) {
    ArrayList<Llamada> historialLlamadasEntrantes = new ArrayList<Llamada>();
    
    // Iterar sobre una coleccion de llamadas mediante un for
    for (Llamada llamada: llamadas) {
      if (llamada.getTipo() == 'E' && llamada.getNumero() == pNumero) {
        historialLlamadasEntrantes.add(llamada);  
      }
    }
    return historialLlamadasEntrantes;
  }
  
  /* Req 12 */ 
  public ArrayList<Mensaje> consultarHistorialMensajes(char pTipo) {
    ArrayList<Mensaje> historialMensajes = new ArrayList<Mensaje>();
    
    // Iterar sobre una coleccion de mensajes mediante un for
    for (Mensaje mensaje: mensajes) {
      if (mensaje.getTipo() == pTipo) {
        historialMensajes.add(mensaje);  
      }
    }
    return historialMensajes;
  }
  
  /* Req 13 */
  public boolean transferir(double pMonto, ChipPrepago pChipDestino) {
    if (estaActivo() && pChipDestino.estaActivo()) {
      if(esSaldoDisponible(pMonto+5)) {
        aplicarCobro(pMonto+5);
        pChipDestino.recargar(pMonto);
        return true;
      }
    }
    return false;
  }
  
  /* Req 14 */ 
  public double eviarMensaje(String pMensaje, ChipPrepago pChipDestino) {
    Mensaje mensajeSaliente = new Mensaje(pChipDestino.getNumero(), 'S', pMensaje);
    Mensaje mensajeEntrante = new Mensaje(this.getNumero(), 'E', pMensaje);
    
    if (estaActivo() && pChipDestino.estaActivo() && pMensaje.length() <= 128) {
      if (esSaldoDisponible(20)){
        aplicarCobro(20);
        agregarMensaje(mensajeSaliente);
        pChipDestino.agregarMensaje(mensajeEntrante);
      }
    }
    return saldo;
  }
  
  /* Req 15 */
  public void navegar(String pUrl) {
    // El usuario ha visto una URL
    if (estaActivo()) {
      double consumoGigas = calcularConsumoNavegacion();
      historialNavegacion.add(pUrl+" - consumo: " + consumoGigas);
      gigaBytesDisponibles = gigaBytesDisponibles - consumoGigas;
    }
  }
  
  // Metodo estatico
  /* Req 16 */
  public static int consultarCantidadChips() {
    return cantidadChips;  
  }
  
  /* Req 17 */
  public String toString() {
    String estado;
    
    estado = "Estado del Chip: " + this.chipActivado + "\n";
    estado+= "Fecha de activacion: " + this.fechaActivacion + "\n";
    estado+= "Operador: " + this.operadorCelular + "\n";
    estado+= "Numero asignado: " + this.numeroTelefonico + "\n";
    estado+= "Saldo disponible: " + this.saldo + "\n";
    estado+= "Gigabytes disponibles: " + this.gigaBytesDisponibles + "\n";
    estado+= "Total del trafico de llamadas: " + this.llamadas.size() + "\n";
    estado+= "Total del trafico de mensajes: " + this.mensajes.size() + "\n";
    return estado;
  }
  
  // Otros metodos privados
  private int generarParticulaInicialNumero() {
    int pNumeroInicio = 0;
    switch (operadorCelular) {
      case "Kolbi":
        pNumeroInicio = 8;
        break;
      case "Movistar":
        pNumeroInicio = 7;
        break;
      case "Claro":
        pNumeroInicio = 6;
        break;
      default:
        return 0;   
    }
    
    return pNumeroInicio;
  }
  
  private int generarNumeroTelefonoRandom() {
    Random random = new Random();
    int particula = generarParticulaInicialNumero();
    if (particula != 0) {
      int numero = (int)(Math.random()*(9999999-1000000+1)+1000000);
      return (int) (particula * Math.pow(10,7)) + numero;
    }
    
    return 0;
  }
  
  //Metodos privados - Accesibles solamente dentro de la clase
  private void agregarLlamada(Llamada pLlamada) {
    llamadas.add(pLlamada);  
  }
  
  private void agregarMensaje(Mensaje pMensaje) {
    mensajes.add(pMensaje);  
  }
  
  private double calcularConsumoNavegacion() {
    Random random = new Random();  
    return (random.nextInt(128) + 1) / 1048576;
  }
  
  private boolean estaActivo() {
    return (chipActivado == true);  
  }
  
  private boolean esSaldoDisponible(double pMonto) {
    return (this.saldo >= pMonto);  
  }
  
  private void aplicarCobro(double pMonto) {
      this.saldo = this.saldo - pMonto;
  }
  
}

/***
 * Ningun metodo de la clase mprime en consola, debido a que no estamos
 * utilizando el comando System.out.prinln en ninguno.
 */
