package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PuntajePenalidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajePenalidadTest {
    @Test
    public void test01PuntajePenalidadJugadorMarca1OpcionCorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion2, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(1, jugador.getPuntaje());
    }
    @Test
    public void test02PuntajePenalidadJugadorMarca1OpcionIncorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion6, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(-1, jugador.getPuntaje());
    }

    @Test
    public void test03PuntajePenalidadJugadorMarca1OpcionCorrectaY1IncorrectaYNoModificaSuPuntaje(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion1, new Valor(true));
        respuesta.marcar(opcion2, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test04PuntajePenalidadJugadorMarca4OpcionesCorrectasY2IncorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(true));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion1, new Valor(true));
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion4, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));
        respuesta.marcar(opcion6, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(2, jugador.getPuntaje());
    }

    @Test
    public void test05PuntajePenalidadJugadorMarca6OpcionesCorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(true));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(true));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(true));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion1, new Valor(true));
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion4, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));
        respuesta.marcar(opcion6, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(6, jugador.getPuntaje());
    }

    @Test
    public void test06PuntajePenalidadJugadorMarca6OpcionesIncorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(false));
        Opcion opcion3 = new Opcion("3", new Valor(false));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(false));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion1, new Valor(true));
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion4, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));
        respuesta.marcar(opcion6, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(-6, jugador.getPuntaje());
    }

    @Test
    public void test07PuntajePenalidadJugadorMarca4OpcionesIncorrectasY1CorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(false));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(false));
        Opcion opcion6 = new Opcion("6", new Valor(true));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje);
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion1, new Valor(true));
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion4, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));


        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(-3, jugador.getPuntaje());
    }
}
