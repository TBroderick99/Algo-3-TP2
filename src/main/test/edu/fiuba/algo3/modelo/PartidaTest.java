package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
   /* @Test
    public void test01PartidaSeCreaConJugadorActualJuan(){
        //Arrange
        Partida partida = Partida.getInstance();
        partida.agregarJugadores("Juan", "Marcelo");

        //Act
        String nombreJugadorActual = partida.getNombreJugadorActual();

        //Assert
        assertEquals("Juan", nombreJugadorActual);
    }

    @Test
    public void test02PartidaSiguienteJugadorEsMarcelo(){
        //Arrange
        Partida partida = Partida.getInstance();
        partida.agregarJugadores("Juan", "Marcelo");

        //Act
        partida.siguienteJugador();
        String nombreJugadorActual = partida.getNombreJugadorActual();

        //Assert
        assertEquals("Marcelo", nombreJugadorActual);
    }

    @Test
    public void test03JugadoresRespondenPreguntaYSeAsignaPuntaje(){
        //Arrange
        Partida partida = Partida.getInstance();
        partida.agregarJugadores("Juan", "Marcelo");

        Jugador jugador1;
        Jugador jugador2;
        Pregunta pregunta = partida.getPreguntaActual();

        RespuestaVerdaderoFalso[] respuesta;
        OpcionVerdaderoFalso[] opciones;

        //Act
        jugador1 = partida.getJugadorActual();
        opciones = pregunta.getOpciones(); //Las opciones tendrian que ser un conjunto de respuestas.
        respuesta = new String[]{opciones[0]};
        partida.guardarRespuesta(new RespuestaSimple(respuesta));

        partida.siguienteJugador();
        jugador2 = partida.getJugadorActual();
        opciones = pregunta.getOpciones();
        respuesta = new String[]{opciones[0]};
        partida.guardarRespuesta(new RespuestaSimple(respuesta));

        partida.siguinteRonda();


        //Assert

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }*/
}
