package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaOrdenadaTest {

    @Test
    public void test01OrderedChoiceJugadorAciertaTodosLosOrdenes(){
    //Arrange
    Jugador jugador1 = new Jugador("Jose");

    Puntaje puntaje = new PuntajeClasico();
    String textoPregunta = "Seleccione el orden correcto de los pasos para hacer una pizza";


    Opcion opcion1 = new Opcion("hornear", new Valor(4));
    Opcion opcion2 = new Opcion("hacer la masa", new Valor(1));
    Opcion opcion3 = new Opcion("agregar salsa", new Valor(2));
    Opcion opcion4 = new Opcion("agregar queso", new Valor(3));

    ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));

    Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

    Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

    respuestaJugador1.marcar(opcion1,new Valor(4));
    respuestaJugador1.marcar(opcion2,new Valor(1));
    respuestaJugador1.marcar(opcion3,new Valor(2));
    respuestaJugador1.marcar(opcion4,new Valor(3));


    ArrayList<Respuesta> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaJugador1);

    //Act
        pregunta.asignarPuntajes(respuestasJugadores);

    //Assert
    assertEquals(1, jugador1.getPuntaje());

    }

    @Test
    public void test02OrderedChoiceJugadorNoAciertaNingunOrden(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "Seleccione el orden correcto de los pasos para hacer una pizza";


        Opcion opcion1 = new Opcion("hornear", new Valor(4));
        Opcion opcion2 = new Opcion("hacer la masa", new Valor(1));
        Opcion opcion3 = new Opcion("agregar salsa", new Valor(2));
        Opcion opcion4 = new Opcion("agregar queso", new Valor(3));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcion1,new Valor(1));
        respuestaJugador1.marcar(opcion2,new Valor(4));
        respuestaJugador1.marcar(opcion3,new Valor(3));
        respuestaJugador1.marcar(opcion4,new Valor(2));


        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(0, jugador1.getPuntaje());

    }

    @Test
    public void test03OrderedChoiceJugadorAciertaAlgunosOrdenes(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "Seleccione el orden correcto de los pasos para hacer una pizza";


        Opcion opcion1 = new Opcion("hornear", new Valor(4));
        Opcion opcion2 = new Opcion("hacer la masa", new Valor(1));
        Opcion opcion3 = new Opcion("agregar salsa", new Valor(2));
        Opcion opcion4 = new Opcion("agregar queso", new Valor(3));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcion1,new Valor(4));
        respuestaJugador1.marcar(opcion2,new Valor(1));
        respuestaJugador1.marcar(opcion3,new Valor(3));
        respuestaJugador1.marcar(opcion4,new Valor(2));


        ArrayList<Respuesta> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(0, jugador1.getPuntaje());

    }


}
