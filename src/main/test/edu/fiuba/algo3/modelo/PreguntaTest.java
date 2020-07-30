package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.ModoDePuntaje;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVyF;
import edu.fiuba.algo3.modelo.preguntas.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaTest {
    @Test
    public void test01PreguntaVerdaderoFalsoSeCreaCorrectamente(){

        //Arrange
        ModoDePuntaje modoDePuntaje = new PuntajeClasico();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<OpcionVerdaderoFalso>();

        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcion1);
        opciones.add(opcion2);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, modoDePuntaje);
        String valor;

        //Act
        valor = pregunta.getTextoPregunta();

        //Assert
        assertEquals(textoPregunta, valor);
    }

    @Test
    public void test02PreguntaVerdaderoFalsoTieneRespuestaCorrecta(){
        //Arrange
        ModoDePuntaje modoDePuntaje = new PuntajeClasico();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<OpcionVerdaderoFalso>();

        OpcionVerdaderoFalso opcionIncorrecta = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcionCorrecta = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, modoDePuntaje);

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

        ModoDePuntaje modoDePuntaje = new PuntajeClasico();
        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<OpcionVerdaderoFalso>();

        OpcionVerdaderoFalso opcionIncorrecta = new OpcionVerdaderoFalso("falso", false);
        OpcionVerdaderoFalso opcionCorrecta = new OpcionVerdaderoFalso("verdadero", true);

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        PreguntaVyF pregunta = new PreguntaVyF(textoPregunta, opciones, modoDePuntaje);

        ArrayList<OpcionVerdaderoFalso> opcionesCorrectas = pregunta.getOpcionesCorrectas();

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

}
