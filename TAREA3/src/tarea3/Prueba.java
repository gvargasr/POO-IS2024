package tarea3;

public class Prueba {
  public static void main(String args[]) {

    Actor actor1 = new Actor("Patrick Steward", "Principal");
    Actor actor2 = new Actor("Will Smith");
    Actor actor3 = new Actor("Brent Spinner");

    Productor productor1 = new Productor("Gustavo Vargas");
    Productor productor2 = new Productor("James Gunn");

    Set set1 = new Set("Playa", "Puntarenas");
    Set set2 = new Set("NYC", "Estados Unidos");

    Serie theNextGeneration = new Serie("Star Trek: The Next Generation", 1);
    Serie independenceDay = new Serie("Independence Day ", 1);


    independenceDay.agregarTemporada("Season 1");
    independenceDay.agregarCapitulo("Guerra en USA", 55, "Bomba nuclear cae en NY", 1, set2);
    independenceDay.agregarActor(actor2, 1, 1);
    independenceDay.agregarProductor(productor2);

    System.out.println(independenceDay);

    theNextGeneration.agregarTemporada("Primera temporada");
    theNextGeneration.agregarCapitulo("Encuentro en Fair point", 123, "Plot inicial", 1, set1);
    theNextGeneration.agregarActor(actor1, 1, 1);
    theNextGeneration.agregarActor(actor3, 1, 1);
    theNextGeneration.agregarProductor(productor1);


    System.out.println(theNextGeneration);
  }
}
