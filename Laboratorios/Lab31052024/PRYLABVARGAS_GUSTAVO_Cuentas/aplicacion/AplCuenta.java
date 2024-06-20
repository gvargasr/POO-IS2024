package aplicacion;

import java.util.ArrayList;
import java.util.Random;
import util.Ordenacion;

import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.CuentaAhorro;
import logicadenegocios.CuentaCorriente;

public class AplCuenta {

  public static void main(String[] args) {
    Cliente[] clientes;
    Cuenta[] cuentas;

    clientes = new Cliente[2];
    cuentas = new Cuenta[2];

    Cliente cliente1 = new Cliente("123", "Maria", "Hernandez");
    Cliente cliente2 = new Cliente("345", "Mateo", "Rojas");

    clientes[0] = cliente1;
    clientes[1] = cliente2;

    Cuenta cuenta1 = new CuentaAhorro(cliente1, 3000);
    Cuenta cuenta2 = new CuentaCorriente(cliente2, 1500);

    cuenta1.depositar(1500);
    cuenta1.depositar(2000);
    cuenta1.retirar(300);
    cuenta2.retirar(200);

    cuentas[0] = cuenta1;
    cuentas[1] = cuenta2;

    System.out.println(cuenta1.cobrarComisiones());
    System.out.println(cuenta2.cobrarComisiones());
    System.out.println();
    System.out.println(cuenta1.toString());
    System.out.println(cuenta2.toString());

    // Impresión de todos los clientes ordenados alfabéticamente
    Ordenacion.ordenar(clientes);

    System.out.println("Clientes ordenados");

    for (int i = 0; i < clientes.length; i++) {
      System.out.println(clientes[i].toString());
    }
    // Impresión de todas las cuentas ordenadas en función del saldo
    Ordenacion.ordenar(cuentas);

    System.out.println("Cuentas ordenadas");
    for (int i = 0; i < cuentas.length; i++) {
      System.out.println(cuentas[i].toString());
    }


  }

  public static Cuenta dameCuenta(Cliente pCliente, double pMonto) {
    Random random = new Random();
    int numero = random.nextInt(2);
    Cuenta cuenta = null;

    switch (numero) {
      case 0:
        cuenta = new CuentaAhorro(pCliente, pMonto);
        break;
      case 1:
        cuenta = new CuentaCorriente(pCliente, pMonto);
        break;
    }
    return cuenta;
  }
}
