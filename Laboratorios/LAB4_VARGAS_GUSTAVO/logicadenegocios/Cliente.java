package logicadenegocios;

public class Cliente {
  private String nombre;
  private String cedula = "No definida";
  
  public Cliente(String pNombre) {
    nombre = pNombre;  
  }
  
  public Cliente(String pNombre, String pCedula) {
    nombre = pNombre;
    cedula = pCedula;
  }
  
  public String getNombre() {
    return nombre;  
  }
  
  public String getCedula() {
    return cedula;  
  }
}