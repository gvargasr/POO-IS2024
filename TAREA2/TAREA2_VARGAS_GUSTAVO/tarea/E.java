package tarea;


/**
 * Write a description of class F here.
 * 
 * @author (Gustavo Vargas) 
 * @version (1.0)
 */
public class E { 
    
  private D d1;
  
  /**
   * Constructor for objects of class F
   */
  public E() {  
  }
  
  public E(D d1) {
    this.d1 = d1;
  }

  public double eM1() {
    return 1.1;  
  }
  
  String eM2() {
    return "";  
  }
  
  public int eM3() {
    return d1.dM2();  
  }
  
  protected boolean eM4() {
    return true;
  }
}
