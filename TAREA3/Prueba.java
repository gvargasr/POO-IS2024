public class Prueba {
    public static void main(String args[]) {
        
        Actor actor1 = new Actor("Patrick Steward");
        Actor actor2 = new Actor("Will Smith");
        Actor actor3 = new Actor("Brent Spinner");
        
        Serie theNextGeneration = new Serie("Star Trek: The Next Generation");
        Serie independenceDay = new Serie("Independence Day ");
        
        theNextGeneration.agregarTemporada("Primera temporada");
        theNextGeneration.agregarCapitulo("Encuentro en Fair point", 123, "Plot inicial", 1);
        theNextGeneration.agregarActor(actor1, 1, 1);
        theNextGeneration.agregarActor(actor3, 1, 1);
        
        System.out.println(theNextGeneration);            
    }
}