package util;


/**
 * Clase Ordenacion
 * 
 * @author Gustavo Vargas
 * @version 31052024
 */
public class Ordenacion {
  public static void ordenar(Comparable[] arreglop) {
    for (int i = 1; i < arreglop.length; i++) {
      Comparable nuevo = arreglop[i];
      int j = i - 1;
      while (j >= 0 && !arreglop[j].menorQue(nuevo)) {
        arreglop[j + 1] = arreglop[i];
        j--;
      }
      arreglop[j + i] = nuevo;
    }
  }

}
