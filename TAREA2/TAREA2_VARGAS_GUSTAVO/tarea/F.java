package tarea;


/**
 * Write a description of class F here.
 * 
 * @author (Gustavo Vargas) 
 * @version (1.0)
 */
public class F { 
    
  public float f1;
  public double f2;
  private E e1;
  private A a1;
  
  /**
   * Constructor for objects of class F
   */
  public F(A a1) {
    f1 = 0;
    f2 = 0;
    this.e1 = new E();
    this.a1 = a1;
  }

  public double calcular() {
    return f1 + f2;
  }
  
  public static String fM1() {
    return "";  
  }
  
  public int fM2() {
    return (int) f1;  
  }
  
  public int fM2(double p) {
    return (int) p;  
  }
}
