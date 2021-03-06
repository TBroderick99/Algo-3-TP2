package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoTieneMasBoostersDisponiblesError;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.puntajes.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaMultipleChoiceTest {


    @Test
    public void test01PreguntaMultipleChoiceConPuntajeParcialSeCreaCorrectamente() {
        //Arrange
        Puntaje puntaje = new PuntajeParcial();
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
    public void test02PreguntaMultipleChoiceClasicoRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajeClasico();
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

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion1, new Valor(true));

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 0);
        assertEquals(jugador2.getPuntaje(), 1);
    }

    @Test
    public void test03PreguntaMultipleChoiceParcialRecibeRespuestasYAsignaPuntajeALosJugadores() {
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

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion2, new Valor(true));

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 3);
    }

    @Test
    public void test04PreguntaMultipleChoicePenalidadRecibeRespuestasYAsignaPuntajeALosJugadores() {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajePenalidad();
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

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador1.marcar(opcion1, new Valor(true));
        respuestaJugador1.marcar(opcion2, new Valor(true));
        respuestaJugador1.marcar(opcion4, new Valor(true));
        respuestaJugador1.marcar(opcion6, new Valor(true));

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador2.marcar(opcion2, new Valor(true));
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion4, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), -2);
        assertEquals(jugador2.getPuntaje(), 2);
    }

    @Test
    public void test05PreguntaMultipleChoicePenalidadConMultiplicadoresRecibeRespuestasYAsignaPuntajeALosJugadores() throws JugadorNoTieneMasBoostersDisponiblesError {
        //Arrange
        Jugador jugador1 = new Jugador("Jose");
        Jugador jugador2 = new Jugador("Lucas");

        Puntaje puntaje = new PuntajePenalidad();
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

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        Booster booster1 = jugador1.getBoosterMultiplicador(2);
        jugador1.consumirBooster(respuestaJugador1, booster1);


        respuestaJugador1.marcar(opcion1, new Valor(true));
        respuestaJugador1.marcar(opcion2, new Valor(true));
        respuestaJugador1.marcar(opcion4, new Valor(true));
        respuestaJugador1.marcar(opcion6, new Valor(true));

        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        Booster booster2 = jugador2.getBoosterMultiplicador(3);
        jugador2.consumirBooster(respuestaJugador2, booster2);

        respuestaJugador2.marcar(opcion2, new Valor(true));
        respuestaJugador2.marcar(opcion3, new Valor(true));
        respuestaJugador2.marcar(opcion4, new Valor(true));
        respuestaJugador2.marcar(opcion5, new Valor(true));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);
        respuestasJugadores.add(respuestaJugador2);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(jugador1.getPuntaje(), -4);  //puntos -2, con multiplicadorx2 -4
        assertEquals(jugador2.getPuntaje(), 6);   //puntos 2, con multiplicadorx3 6
    }



}
