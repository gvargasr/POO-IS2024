package aplicacion;

import logicadenegocios.ChipPrepago;
import logicadenegocios.Llamada;
import logicadenegocios.Mensaje;
import logicadenegocios.Cliente;


public class AplChipPrepago {
  
  public static void main(String args[]) {
    
    // Declaracion dep puntero e Instanciacion de los objetos de tipo ChipPrepago
    ChipPrepago chipPrepago1 = new ChipPrepago("Claro");
    ChipPrepago chipPrepago2 = new ChipPrepago("Kolbi");
    ChipPrepago chipPrepago3 = new ChipPrepago("Movistar");
    ChipPrepago chipPrepago4 = new ChipPrepago("Kolbi");
    
    // Declaracion del puntero e Instanciacion de los objetos de tipo Cliente
    Cliente cliente1 = new Cliente("Luis Soto", "1-101-233");
    Cliente cliente2 = new Cliente("Ana Orozco", "2-845-736");
    Cliente cliente3 = new Cliente("Tony Stark", "8-132-785");
    
    
    // Envio de mensajes a los objetos
    chipPrepago1.activar(cliente1);
    System.out.println("------\n\n");
    // Impresion de salidas en consola
    System.out.println(chipPrepago1);
    System.out.println(chipPrepago2);
    System.out.println("------\n\n");

    // Recargar
    chipPrepago1.recargar(500);
    System.out.println(chipPrepago1);
    System.out.println("------\n\n");

    // LLamar
    chipPrepago2.activar(cliente2);
    chipPrepago1.llamar(12, chipPrepago2);
    
    System.out.println("------\n\n");    
    System.out.println(chipPrepago1);
    System.out.println(chipPrepago2);
    
    //Consultar saldo
    System.out.println("------\n\n");
    System.out.println(chipPrepago1.consultarSaldo());
    //System.out.println(chipPrepago1);
    
    // Datos disponibles
    System.out.println("------\n\n");    
    System.out.println(chipPrepago1.consultarDatosDisponibles());
 
    System.out.println("------\n\n");
    System.out.println(chipPrepago1.recargarDatos(5));
    
    // Datos disponibles
    System.out.println("------\n\n");    
    System.out.println(chipPrepago1.consultarDatosDisponibles());    
    
    
  }
}
