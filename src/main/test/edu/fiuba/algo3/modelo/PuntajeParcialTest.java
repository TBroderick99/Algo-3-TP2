package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.preguntas.PuntajeParcial;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01PuntajeParcialJugadorMarca1OpcionCorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion2, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02PuntajeParcialJugadorNoMarcaOpcionesYNoModificaSuPuntaje(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);


        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03PuntajeParcialJugadorMarca2OpcionesCorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(2, jugador.getPuntaje());
    }
    @Test
    public void test04PuntajeParcialJugadorMarca2OpcionesCorrectasY1IncorrectaYNoModificaSuPuntaje(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion6, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test05PuntajeParcialJugadorMarca5OpcionesCorrectasYSuma5Puntos(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        Opcion opcion1 = new Opcion("1", new Valor(true));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(true));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6));

        Pregunta pregunta = new Pregunta("Texto", opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.marcar(opcion1, new Valor(true));
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion4, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(5, jugador.getPuntaje());
    }
}
