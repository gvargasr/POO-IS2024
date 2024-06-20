public abstract class Persona {
    private String nombre;
    protected double salarioBase;
    
    public Persona(String pNombre, double pSalarioBase){
        nombre = pNombre;
        salarioBase = pSalarioBase;
    }
    //metodo abstracto
    public abstract double calcularSalario();
    
    //metodo concreto
    public String getNombre(){
        return nombre;
    }
}
