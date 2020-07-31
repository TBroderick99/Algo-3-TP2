package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaTest {
    @Test
    public void test01PreguntaVerdaderoFalsoSeCreaCorrectamente(){

        //Arrange
        Puntaje puntaje = new PuntajeClasico();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>();

        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcion1);
        opciones.add(opcion2);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);
        String valor;

        //Act
        valor = pregunta.getTextoPregunta();

        //Assert
        assertEquals(textoPregunta, valor);
    }

    @Test
    public void test02PreguntaVerdaderoFalsoTieneRespuestaCorrecta(){
        //Arrange
        Puntaje puntaje = new PuntajeClasico();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>();

        OpcionVerdaderoFalso opcionIncorrecta = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcionCorrecta = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);

        ArrayList<OpcionVerdaderoFalso> opcionesCorrectas = pregunta.getOpcionesCorrectas();

        //Act
        boolean opcionEstaEnLasCorrectas = opcionesCorrectas.contains(opcionCorrecta);

        //Assert
        assertTrue(opcionEstaEnLasCorrectas);


    }

    @Test
    public void test03PreguntaVerdaderoFalsoClasicoRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador[] jugadores = {jugador1, jugador2};

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>();

        OpcionVerdaderoFalso opcionIncorrecta = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcionCorrecta = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);

                RespuestaVerdaderoFalso respuestaJugador1 = pregunta.crearRespuesta();
        respuestaJugador1.marcar(0);

        RespuestaVerdaderoFalso respuestaJugador2 = pregunta.crearRespuesta();
        respuestaJugador2.marcar(1);

        RespuestaVerdaderoFalso[] respuestasJugadores = new RespuestaVerdaderoFalso[]{respuestaJugador1, respuestaJugador2};


        //Act
        pregunta.asignarPuntajes(respuestasJugadores, jugadores);


        //Assert
        assertEquals(jugador1.getPuntaje(), 0);
        assertEquals(jugador2.getPuntaje(), 1);
    }

    @Test
    public void test04PreguntaMultipleChoiceConPuntajeParcialSeCreaCorrectamente() {
        //Arrange
        Puntaje puntaje = new PuntajeParcial();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>();

        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcion1);
        opciones.add(opcion2);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);
        String valor;

        //Act
        valor = pregunta.getTextoPregunta();

        //Assert
        assertEquals(textoPregunta, valor);
    }

    @Test
    public void test05PreguntaMultipleChoiceClasicoRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador[] jugadores = {jugador1, jugador2};

        Puntaje puntaje = new PuntajeClasico();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);

        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>(
             Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);

        RespuestaVerdaderoFalso respuestaJugador1 = pregunta.crearRespuesta();
        respuestaJugador1.marcar(0);

        RespuestaVerdaderoFalso respuestaJugador2 = pregunta.crearRespuesta();
        respuestaJugador2.marcar(1);
        respuestaJugador2.marcar(2);
        respuestaJugador2.marcar(4);

        RespuestaVerdaderoFalso[] respuestasJugadores = new RespuestaVerdaderoFalso[]{respuestaJugador1, respuestaJugador2};

        //Act
        pregunta.asignarPuntajes(respuestasJugadores, jugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 0);
        assertEquals(jugador2.getPuntaje(), 1);
    }

    @Test
    public void test05PreguntaMultipleChoiceParcialRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador[] jugadores = {jugador1, jugador2};

        Puntaje puntaje = new PuntajeParcial();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);

        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>(
                Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);

        RespuestaVerdaderoFalso respuestaJugador1 = pregunta.crearRespuesta();
        respuestaJugador1.marcar(1);

        RespuestaVerdaderoFalso respuestaJugador2 = pregunta.crearRespuesta();
        respuestaJugador2.marcar(1);
        respuestaJugador2.marcar(2);
        respuestaJugador2.marcar(4);

        RespuestaVerdaderoFalso[] respuestasJugadores = new RespuestaVerdaderoFalso[]{respuestaJugador1, respuestaJugador2};

        //Act
        pregunta.asignarPuntajes(respuestasJugadores, jugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 3);
    }

    @Test
    public void test06PreguntaVerdaderoFalsoConPenalidadRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador[] jugadores = {jugador1, jugador2};

        Puntaje puntaje = new PuntajePenalidad();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<>();

        OpcionVerdaderoFalso opcionIncorrecta = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcionCorrecta = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, puntaje);

        RespuestaVerdaderoFalso respuestaJugador1 = pregunta.crearRespuesta();
        respuestaJugador1.marcar(0);

        RespuestaVerdaderoFalso respuestaJugador2 = pregunta.crearRespuesta();
        respuestaJugador2.marcar(1);

        RespuestaVerdaderoFalso[] respuestasJugadores = new RespuestaVerdaderoFalso[]{respuestaJugador1, respuestaJugador2};


        //Act
        pregunta.asignarPuntajes(respuestasJugadores, jugadores);


        //Assert
        assertEquals(jugador1.getPuntaje(), -1);
        assertEquals(jugador2.getPuntaje(), 1);
    }

}
