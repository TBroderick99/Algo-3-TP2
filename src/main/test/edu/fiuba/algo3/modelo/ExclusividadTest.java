package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.BoosterExclusividad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExclusividadTest{

    @Test
    public void test01ExclusividadSeCreaConFactorCorrecto(){
        //Arrange
        Booster boosterPor2 = new BoosterExclusividad(2);
        Booster boosterPor3 = new BoosterExclusividad(3);

        //Act
        int factorBoosterPor2 = boosterPor2.getFactor();
        int factorBoosterPor3 = boosterPor3.getFactor();

        //Assert
        assertEquals(2, factorBoosterPor2);
        assertEquals(3, factorBoosterPor3);
    }

    @Test
    public void test02ExclusividadSeAplicaCorrectamente(){
        //Arrange
        Jugador jugador = new Jugador("juan");
        Puntaje puntaje = new PuntajeClasico();

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";
        Opcion opcion1 = new Opcion("7", new Valor(true));

        ArrayList<Opcion> opciones = new ArrayList<>(
                Arrays.asList(opcion1)
        );

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        Booster boosterPor2 = new BoosterExclusividad(2);

        boosterPor2.aplicarBoost(respuestaJugador);

        //Act
        Booster boosterPregunta = pregunta.getBooster();

        //Assert
        assertEquals(boosterPor2, boosterPregunta);
    }

    @Test
    public void test03PreguntaBoosterExclusivoEnMultipleChoiceParcialUnoAplicaBoosterYSoloUnoConstestaBien() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajeParcial();
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));

        ArrayList<Opcion> opciones = new ArrayList<>(
                Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje);

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion2, new Valor(true));//solo responde una, no se duplica puntaje por booster

        Booster boosterPor2 = new BoosterExclusividad(2);
        boosterPor2.aplicarBoost(respuestaJugador1);

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));//responde perfectamente recibe doble puntaje por booster
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 6);
    }

    @Test
    public void test04PreguntaBoosterExclusivoEnMultipleChoiceParcialAmbosAplicanBoosterYSoloUnoConstestaBien() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajeParcial();
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));

        ArrayList<Opcion> opciones = new ArrayList<>(
                Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje);

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion2, new Valor(true));//solo responde una, no se cuadruple puntaje por booster

        Booster boosterPor2 = new BoosterExclusividad(2);
        boosterPor2.aplicarBoost(respuestaJugador1);

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));//responde perfectamente recibe cuadruple puntaje por booster
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        boosterPor2.aplicarBoost(respuestaJugador2);

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 12);
    }

    @Test
    public void test05PreguntaBoosterExclusivoEnMultipleChoiceParcialUnoAplicaBoosterYAmbosConstestaBien() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajeParcial();
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));

        ArrayList<Opcion> opciones = new ArrayList<>(
                Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje);

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion2, new Valor(true));//responde perfectamente (igual que jugador 2) recibe 0 puntaje por booster
        respuestaJugador1.marcar(opcion3, new Valor(true));
        respuestaJugador1.marcar(opcion5, new Valor(true));

        Booster boosterPor2 = new BoosterExclusividad(2);
        boosterPor2.aplicarBoost(respuestaJugador1);

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));//responde perfectamente recibe 0 puntaje por booster
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 0);
        assertEquals(jugador2.getPuntaje(), 0);
    }

    @Test
    public void test06PreguntaBoosterExclusivoEnMultipleChoiceParcialAmbosAplicanBoosterYAmbosConstestaBien() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajeParcial();
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));

        ArrayList<Opcion> opciones = new ArrayList<>(
                Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje);

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion2, new Valor(true));//responde perfectamente (igual que jugador 2) recibe 0 puntaje por booster
        respuestaJugador1.marcar(opcion3, new Valor(true));
        respuestaJugador1.marcar(opcion5, new Valor(true));

        Booster boosterPor2 = new BoosterExclusividad(2);
        boosterPor2.aplicarBoost(respuestaJugador1);

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));//responde perfectamente recibe 0 puntaje por booster
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        boosterPor2.aplicarBoost(respuestaJugador2);

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 0);
        assertEquals(jugador2.getPuntaje(), 0);
    }


}