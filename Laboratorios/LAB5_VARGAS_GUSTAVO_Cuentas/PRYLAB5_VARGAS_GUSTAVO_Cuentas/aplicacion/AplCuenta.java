package aplicacion;

import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;


public class AplCuenta {
  
  public static void main(String[] args) {
    
    Cliente cliente1 = new Cliente("123", "Byan", "Rojas");
    Cliente cliente2 = new Cliente("356", "Alberto", "Hernández");
    
    Cuenta cuenta1 = new Cuenta(cliente1, 3500);
    cuenta1.depositar(1700);
    cuenta1.depositar(2200);
    cuenta1.retirar(500);
    Cuenta cuenta2 = new Cuenta(cliente2, 1700);
    cuenta2.retirar(400);
    /*  System.out.println("Cliente 1 y cliente 2 estan en la misma direccion? : ");
    System.out.println(cliente1 == cliente2);
    System.out.println("Cliente 1 y cliente 2 Son iguales? : ");
    System.out.println(cliente1.equals(cliente2));
    System.out.println("Cuenta 1 y Cuenta 2 estan en la misma direccion? : ");
    System.out.println(cuenta1 == cuenta2);
    System.out.println("Cliente 1 y cliente 2 estan en la misma direccion? : ");
    System.out.println(cuenta1.equals(cuenta2));*/
    System.out.println(cuenta1.toString());
    System.out.println(cuenta2.toString());
  }

}
