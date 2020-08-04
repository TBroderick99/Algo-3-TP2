package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoRecibeRespuestaCorrectaDeJugadorYAsignaPuntaje(){
        //Arrange
        PuntajeClasico puntaje = new PuntajeClasico();
        Jugador jugador = new Jugador("Juan");

        Respuesta respuesta = new Respuesta(jugador);

        Opcion opcion1 = new Opcion("Verdadero", new Valor(true));
        Opcion opcion2 = new Opcion("Falso", new Valor(false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
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

        Respuesta respuesta = new Respuesta(jugador);

        Opcion opcion1 = new Opcion("Verdadero", new Valor(true));
        Opcion opcion2 = new Opcion("Falso", new Valor (false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.marcar(opcion2, new Valor(true));

        //Act
        puntaje.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
}
