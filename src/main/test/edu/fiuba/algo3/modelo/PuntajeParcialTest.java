package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.preguntas.PuntajeParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01PuntajeParcialJugadorMarca1OpcionCorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        Respuesta respuesta = new Respuesta(jugador);
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
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

        Respuesta respuesta = new Respuesta(jugador);
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);

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

        Respuesta respuesta = new Respuesta(jugador);
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
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

        Respuesta respuesta = new Respuesta(jugador);
        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
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

        Respuesta respuesta = new Respuesta(jugador);
        Opcion opcion1 = new Opcion("1", new Valor(true));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(true));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
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
