package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.PuntajeParcial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01PuntajeParcialJugadorMarca1OpcionCorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
        respuesta.marcar(1);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02PuntajeParcialJugadorNoMarcaOpcionesYNoModificaSuPuntaje(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03PuntajeParcialJugadorMarca2OpcionesCorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
        respuesta.marcar(1);
        respuesta.marcar(2);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(2, jugador.getPuntaje());
    }
    @Test
    public void test04PuntajeParcialJugadorMarca2OpcionesCorrectasY1IncorrectaYNoModificaSuPuntaje(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
        respuesta.marcar(1);
        respuesta.marcar(2);
        respuesta.marcar(5);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test05PuntajeParcialJugadorMarca5OpcionesCorrectasYSuma5Puntos(){
        //Arrange
        PuntajeParcial puntaje = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", true);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", true);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.agregarSeleccion(opcion3);
        respuesta.agregarSeleccion(opcion4);
        respuesta.agregarSeleccion(opcion5);
        respuesta.agregarSeleccion(opcion6);
        respuesta.marcar(0);
        respuesta.marcar(1);
        respuesta.marcar(2);
        respuesta.marcar(3);
        respuesta.marcar(4);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(5, jugador.getPuntaje());
    }
}
