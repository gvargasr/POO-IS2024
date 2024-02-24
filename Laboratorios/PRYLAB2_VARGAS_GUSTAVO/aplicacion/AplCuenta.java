package aplicacion;


/**
 * Aplicacion para crear cuenta de ahorros.
 * 
 * @author Gustavo Vargas 
 * @version 20240217
 */

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStreamReader;

public class AplCuenta{
    static String[] nombres;
    static String[] cedulas;
    static double[] saldos;
    static String[] idCuentas;
    static int numCuentas = 0;
    //Estas son las declaraciones de los objetos de la entrada y salida estandar
    static BufferedReader in;
    static PrintStream out;
    
    
    public static void main( String[] args ) throws java.io.IOException{
      nombres = new String[10];
      cedulas = new String[10];
      saldos = new double[10];
      idCuentas = new String[10];
      // Se crean los objetos tanto para la entrada de datos desde el  
      // teclado (in) como para la salida de datos a la consola (out)
      in = new BufferedReader(new InputStreamReader( System.in ));
      out = System.out;
      boolean noSalir = true;
      int opcion;
    
      do{
        mostrarMenu();
        opcion = leerOpcion();
        noSalir = ejecutarAccion( opcion );
      } while ( noSalir );
    }
    
    static void mostrarMenu() {
      out.println( "1. Registrar Cliente" );
      out.println( "2. Abrir una Cuenta" );
      out.println( "3. Realizar Transacción" );
      out.println( "4. Consultar Información " );
      out.println( "5. Salir" );
    }
    
    static int leerOpcion() throws java.io.IOException {
      int opcion;
      out.println( "Seleccione su opcion: ");
      opcion = Integer.parseInt( in.readLine() );
      out.println();
      return opcion;
    }
    
    static boolean ejecutarAccion(int opcion) throws java.io.IOException{
      boolean noSalir = true;
      int opc = 0;
      switch( opcion ){
            case 1: registrarCliente();
                    break;
            case 2: abrirCuenta();
                    break;
            case 3: realizarTransacciones();
                    break;
            case 4: mostrarMenuConsultas();
                    opc = leerOpcion();
                    ejecutarConsultas( opc );
                    break;
            case 5: noSalir = false;
                    break;
            default: out.println( "Opcion no valida" );
                    break;
      }
      out.println();
      return noSalir;
    }
    
    static void registrarCliente() throws java.io.IOException{
      int indice;
      String cedula;
      if ( numCuentas <= 10 ){
        out.println( "Ingrese el numero de cedula: ");
        cedula = in.readLine();
        out.println();
        indice = buscarCliente( cedula );
        if(indice == -1){
          cedulas[ numCuentas ] = cedula;
          out.println("Ingrese el nombre y el apellido: ");
          nombres[numCuentas] = in.readLine();
          numCuentas += 1;
          out.println("\n El cliente ha sido registrado!!!");
          out.println();
        }
        else{
          out.println("\n El cliente ya existe|");
        }
      }
      else{
        out.println("\n No se pueden registrar mas clientes");    
      }
    }
    
    static void abrirCuenta() throws java.io.IOException{
      String cedula;
      int indice;
      double monto = 0;
      boolean noSalir = true;
      String continuar = "";
      out.println("Ingrese el número de cédula del cliente que será dueño de la cuenta: " );
      cedula = in.readLine();
      out.println();
      do{
        indice = buscarCliente(cedula);
        if(indice != -1){
          if(buscarCuenta("" + cedula.charAt(0) + indice) == -1){
            do{
              out.println( "Ingrese el monto( >= a 1000) con el que desea abrir la cuenta: ");
              monto = Double.parseDouble(in.readLine());
              out.println();
            }while(monto < 1000 );
            saldos[indice] = monto;
            idCuentas[indice] = "" + cedula.charAt(0) + indice;
          }
          else{
            out.println("Cuenta ya fue abierta");  
          }
          noSalir = false;
        }
        else{
          out.println("Cliente no registrado");
          out.println("Desea buscar otro (s/n): ");
          continuar = in.readLine();
          if(continuar.charAt(0) == 's'){
            out.println("Ingrese el numero de cedula: ");
            cedula = in.readLine();
            out.println();
          }
          else{
            noSalir = false;  
          }
        }
        out.println();
      }while( noSalir);
    }
    
    static int buscarCliente(String pcedula){
      boolean encontrado = false;
      int i = 0;
      int indice = -1;
      while(!encontrado && cedulas[i] != null && i < cedulas.length){
        if(cedulas[i].equals( pcedula )){
          indice = i;
          encontrado = true;
        }
        i +=1;
      }
      return indice;
    }
    
    static void listarCuentasIds(){
      int i = 0;
      while( i < idCuentas.length ){
        if(idCuentas[i] != null ){
          out.println(idCuentas[i]);  
        }
          i += 1;
      }
    }
    
    static void mostrarMenuTransacciones(){
      out.println("1. Depositar");
      out.println("2. Retirar");
      out.println("3. Ver Saldo");
      out.println("4. Salir");
      out.println();
    }
    
    static int verificarCuenta() throws java.io.IOException{
      String numCuenta;
      int indice = -1;
      out.println("Ingrese el numero de la cuenta: ");
      numCuenta = in.readLine();
      out.println();
      indice = buscarCuenta( numCuenta );
      return indice;
    }
    
    static int buscarCuenta(String pnumero){
      int indice = -1;
      int i = 0;
      while(i < idCuentas.length && indice == -1){
        if(idCuentas[i] != null){
          if(idCuentas[i].equals(pnumero)){
            indice = i;  
          }
        }
        i += 1;
      }
      return indice;
    }
    
    static void mostrarMenuConsultas(){
      out.println("1. Ver clientes por cédula");
      out.println("2. Ver clientes por nombre");
      out.println("3. Ver Cuentas por número");
      out.println();
    }
    
    static void ejecutarConsultas(int popcion){
      switch(popcion){
        case 1: listarInformacion(cedulas);
		break;			
	case 2: listarInformacion(nombres);
		break;
	case 3: listarCuentasIds();
		break;
	default: out.println("Valor no válido");
		break;
      }
      out.println();
    }
    
    static void listarInformacion(String[] plista){
      int i = 0;
      while( plista[i] != null && i < plista.length ){
        out.println( plista[i] );
        i += 1;
      }
    }
    
    static boolean ejecutarTransacciones( int popcion, int pindice ) throws java.io.IOException{
      boolean seguir = true;
      switch( popcion ) {		
	case 1: depositar( pindice );
		break;			
	case 2: retirar( pindice );
		break;
	case 3: verSaldo( pindice );
        	break;
	case 4: seguir = false;
		break;
	default: out.println( "Valor no válido" );
		break;
      }
      out.println();
      return seguir;
    }
    
    static void realizarTransacciones() throws java.io.IOException{
      int opc = 0;
      boolean seguir = true;
      int indice = verificarCuenta();
      if( indice != -1){
        out.println("Cedula: " + cedulas[indice]);
        out.println("Cliente: " + nombres[indice]);
        out.println();
        do{
          mostrarMenuTransacciones();
          opc = leerOpcion();
          seguir = ejecutarTransacciones(opc, indice);
        }while(seguir);
      }
      else{
        out.println("Cuenta no existe");  
      }
    }
    
    static void depositar(int pindice) throws java.io.IOException{
      double monto = 0;
      out.println("Ingrese el monto del deposito: ");
      monto = Double.parseDouble(in.readLine());
      out.println();
      saldos[pindice] +=monto;
      out.println("Su deposito fue de " + monto + " colones");
    }
    
    static void retirar(int pindice) throws java.io.IOException{
      double monto = 0;
      out.println("Ingrese el monto a retirar: ");
      monto = Double.parseDouble(in.readLine());
      out.println();
      saldos[pindice] -= monto;
      out.println("Su retiro fue de " + monto + " colones");
    }
    
    static void verSaldo(int pindice) throws java.io.IOException{
      out.println("El saldo actual es " + saldos[pindice] + " colones");
    }

}


