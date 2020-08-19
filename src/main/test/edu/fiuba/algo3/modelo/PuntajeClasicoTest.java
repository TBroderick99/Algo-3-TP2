package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoRecibeRespuestaCorrectaDeJugadorYAsignaPuntaje(){
        //Arrange

        PuntajeClasico puntaje = new PuntajeClasico();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("Verdadero", new Valor(true));
        Opcion opcion2 = new Opcion("Falso", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        respuesta.marcar(opcion1, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02PuntajeClasicoRecibeRespuestaIncorrectaDeJugadorYNoAsignaPuntaje(){
        //Arrange
        PuntajeClasico puntaje = new PuntajeClasico();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("Verdadero", new Valor(true));
        Opcion opcion2 = new Opcion("Falso", new Valor (false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion2, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
}
