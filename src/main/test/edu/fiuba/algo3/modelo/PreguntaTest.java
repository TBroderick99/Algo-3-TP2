package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaSimple;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test01PreguntaVerdaderoFalsoSeCreaCorrectamente(){
        //Arrange
        String textoPregunta = "La UBA fue fundada en el año 1821";
        String[] opciones = {"True","False"};
        String[] opcionCorrecta = {"true"};
        RespuestaSimple respuestaCorrecta = new RespuestaSimple(opcionCorrecta);
        Pregunta pregunta = new Pregunta( textoPregunta, opciones, respuestaCorrecta);
        String valor;

        //Act
        valor = pregunta.getTextoPregunta();

        //Assert
        assertEquals(textoPregunta, valor);
    }

    @Test
    public void test02PreguntaVerdaderoFalsoClasicoTieneRespuestaCorrecta(){
        //Arrange
        String textoPregunta = "La UBA fue fundada en el año 1821";
        String[] opciones = {"True","False"};
        String[] opcionCorrecta = {"true"};
        RespuestaSimple respuestaCorrecta = new RespuestaSimple(opcionCorrecta);
        Pregunta pregunta = new Pregunta( textoPregunta, opciones, respuestaCorrecta);

        //Act
        RespuestaSimple respuesta = pregunta.getRespuestaCorrecta();

        //Assert
        assertEquals(respuesta, respuestaCorrecta);
    }

    @Test
    public void test03PreguntaVerdaderoFalsoClasicoRecibeRespuestasYAsignaPunajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador[] jugadores = {jugador1, jugador2};

        String textoPregunta = "La UBA fue fundada en el año 1821";
        String[] opciones = {"True", "False"};

        String[] opcionJugador1 = {"True"};
        RespuestaSimple respuestaJugador1 = new RespuestaSimple(opcionJugador1);

        String[] opcionJugador2 = {"False"};
        RespuestaSimple respuestaJugador2 = new RespuestaSimple(opcionJugador2);

        RespuestaSimple[] respuestasJugadores = {respuestaJugador1, respuestaJugador2};

        String[] opcionCorrecta = {"True"};
        RespuestaSimple respuestaCorrecta = new RespuestaSimple(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(textoPregunta, opciones, respuestaCorrecta);

        //Act
        unaPregunta.asignarPuntajes(respuestasJugadores, jugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 0);

    }
}
