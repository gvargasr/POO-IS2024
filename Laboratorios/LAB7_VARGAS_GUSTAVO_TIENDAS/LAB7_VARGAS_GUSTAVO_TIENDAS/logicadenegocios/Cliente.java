package logicadenegocios;

public class Cliente {
  // instance variables - replace the example below with your own
  private String cedula;
  private String nombre;
  private String telefono;
  private String email;
  private String[] direccion;
  private int cantApartados;

  /**
   * Constructor de clase Cliente
   * Inicializa el cliente y establece la informacion inicial.
   * Configura:
   * 1. Cedula del cliente.
   * 2. Nombre del cliente.
   * 3. Apellido del cliente.
   * 
   * 
   * @param String pCedula recibe String Cedula 
   * @param String pNombre recibe String Nombre 
   * @param String pApellido recibe String Apellido
   * 
  */ 
  public Cliente(String pCedula, String pNombre, String pTelefono, String pEmail, String pProvincia, String pCanton, String pDistrito, String pSenas) {
    setCedula(pCedula);
    setNombre(pNombre);
    setTelefono(pTelefono);
    setEmail(pEmail);
    direccion = new String[4];
    setDireccion(pProvincia, pCanton, pDistrito, pSenas);
  }


  public String getCedula() {
    return cedula;
  }
  
  public String getNombre() {
    return nombre;  
  }
  
  public String getTelefono() {
    return telefono;  
  }

  public String getEmail() {
    return email;  
  }
  
  public String getDireccion() {
    return direccion[0] + "\n" + direccion[1] + "\n" + direccion[2] + "\n" + direccion[3] + "\n";  
  }
  
  public void setCedula(String pCedula) {
    cedula = pCedula;  
  }
  
  public void setNombre(String pNombre) {
    nombre = pNombre;  
  }
  
  public void setTelefono(String pTelefono) {
    telefono = pTelefono;  
  }
  
  public void setEmail(String pEmail) {
    email = pEmail;  
  }
  
  public void setDireccion(String pProvincia, String pCanton, String pDistrito, String pSenas) {
    direccion[0] = pProvincia;
    direccion[1] = pCanton;
    direccion[2] = pDistrito;
    direccion[3] = pSenas;
  }
  
  /**
   * Método toString
   * Imprime cédula y nombre completo del cliente
   * No recibe parámetros. 
   * 
  */
  public String toString() {
    String msg = "";
    msg = "Cédula: " + getCedula() + "\n";
    msg += "Nombre: " + getNombre() +  "\n";
    msg += "Telefono: " + getTelefono() +  "\n";
    msg += "email: " + getEmail() +  "\n";
    msg += "Direccion: " + getDireccion() +  "\n";
    return msg;
  }
  
  /**
   * Método equals
   * Recibe objeto de tipo Cliente y compara consigo mismo para determinar si son iguales.
   * @param Object pCliente. 
   * 
  */
  public boolean equals(Object pCliente) {
    if (this == pCliente) {
      return true;
    }
    if (pCliente == null) {
      return false;
    }
    if (getClass() != pCliente.getClass()) {
      return false;
    }
        
    Cliente cliente = (Cliente) pCliente;
    return getCedula().equals(cliente.getCedula());
  }
}
