public class Cajero extends Persona {
    private int horasExtra; 
    private double salarioHora;
    
    public Cajero(String pNombre, double pSalarioBase){
        super(pNombre, pSalarioBase);
    }
    
    public double calcularSalario() {
      return salarioBase + (horasExtra * salarioHora);    
    }
}