
public class AppRadio {
  
  public static void main (String[] args){
    Disco disco1 = new Disco("Bonjovi");
    Disco disco2 = new Disco("Madonna");
    
    disco1.agregarCancion("It's my life");
    disco1.agregarCancion("Musa");
    disco1.agregarCancion("Yellow");
    
    System.out.println("** DISCO 1 **");
    System.out.println(disco1);
    
    System.out.println("** DISCO 2 **");
    System.out.println(disco2);
    
    
    Radio radio1 = new Radio("RCA");
    radio1.encender();
    System.out.println(radio1.insertarDisco(disco1));
    radio1.reproducir(2);
  }
}
