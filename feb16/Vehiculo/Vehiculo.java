
/**
 * Write a description of class Vehiculo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehiculo
{
    // instance variables - replace the example below with your own
    private String color;
    private String placa;
    private int anoFabricacion;
    private boolean estaChocado = false;

    /**
     * Constructor for objects of class Vehiculo
     */
    public Vehiculo()
    {
        // initialise instance variables
        color = "Unknown";
        placa = "Unknown";
        anoFabricacion = 0;
    }
    // Constructor - metodo inicializador
    public Vehiculo(String pColor, String pPlaca){
        color = pColor;
        placa = pPlaca;
        anoFabricacion = 0;
    }
    // Constructor - metodo inicializador
    public Vehiculo(int pAnoFabricacion, String pPlaca){
        color = "Unknown";
        placa = pPlaca;
        anoFabricacion = pAnoFabricacion;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void chocar(){
        estaChocado = true;
    }
    
    public void arreglar(){
        estaChocado = false;
    }
}
