package tarea;


/**
 * Write a description of class F here.
 * 
 * @author (Gustavo Vargas) 
 * @version (1.0)
 */
public class A { 
    
  boolean a1;
  public String a2;
  protected F f1;
  
  /**
   * Constructor for objects of class F
   */
  public A(F f1) {
    a1 = true;
    a2 = "";
    this.f1 = f1;
  }

  public double calcular() {
    return 1.1;
  }
  
  protected void aM3() {  
  }
  
  float aM4() {
    return 1.1f;  
  }
  
}
