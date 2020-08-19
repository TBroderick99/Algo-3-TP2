package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaVyFTest {

    @Test
    public void test01PreguntaVerdaderoFalsoSeCreaCorrectamente(){

        //Arrange
        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("falso", new Valor(false));
        Opcion opcion2 = new Opcion("verdadero", new Valor(true));

        opciones.add(opcion1);
        opciones.add(opcion2);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");
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
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");



        //Act
        boolean opcionCorrectaDebeSerMarcada = opcionCorrecta.debeSerMarcada();
        boolean opcionIncorrectaDebeSerMarcada = opcionCorrecta.debeSerMarcada();

        //Assert
        assertTrue(opcionCorrectaDebeSerMarcada);
        assertTrue(opcionIncorrectaDebeSerMarcada);


    }

    @Test
    public void test03PreguntaVerdaderoFalsoClasicoRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);

        String textoPregunta = "La UBA fue fundada en el año 1821";


        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcionIncorrecta, new Valor(true));


        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcionCorrecta,new Valor(true));


        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);


        //Act
        pregunta.asignarPuntajes(respuestasJugadores);


        //Assert
        assertEquals(jugador1.getPuntaje(), 0);
        assertEquals(jugador2.getPuntaje(), 1);
    }

    @Test
    public void test04PreguntaVerdaderoFalsoPenalidadConMultiplicadoresRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajePenalidad();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta = "La UBA fue fundada en el año 1821";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcionIncorrecta, new Valor(true));

        Booster booster = jugador1.getBoosterMultiplicador(2);
        jugador1.consumirBooster(respuestaJugador1, booster);


        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        Booster booster2 = jugador2.getBoosterMultiplicador(3);
        jugador2.consumirBooster(respuestaJugador2, booster2);

        respuestaJugador2.marcar(opcionCorrecta, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);


        //Assert
        assertEquals(-2, jugador1.getPuntaje() );  //puntaje -1 con multiplicadorx2 -2
        assertEquals(3, jugador2.getPuntaje());   //puntaje 1 con multiplicadorx3 3
    }


}
