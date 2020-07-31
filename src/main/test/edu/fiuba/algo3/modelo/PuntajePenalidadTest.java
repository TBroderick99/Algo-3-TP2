package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.PuntajePenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajePenalidadTest {
    @Test
    public void test01PuntajePenalidadJugadorMarca1OpcionCorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
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
    public void test02PuntajePenalidadJugadorMarca1OpcionIncorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
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
        respuesta.marcar(5);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(-1, jugador.getPuntaje());
    }

    @Test
    public void test03PuntajePenalidadJugadorMarca1OpcionCorrectaY1IncorrectaYNoModificaSuPuntaje(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
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
        respuesta.marcar(0);
        respuesta.marcar(1);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test04PuntajePenalidadJugadorMarca4OpcionesCorrectasY2IncorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
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
        respuesta.marcar(5);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(2, jugador.getPuntaje());
    }

    @Test
    public void test05PuntajePenalidadJugadorMarca6OpcionesCorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", true);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", true);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", true);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", true);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", true);
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
        respuesta.marcar(5);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(6, jugador.getPuntaje());
    }

    @Test
    public void test06PuntajePenalidadJugadorMarca6OpcionesIncorrectasYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", false);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", false);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", false);
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
        respuesta.marcar(5);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(-6, jugador.getPuntaje());
    }

    @Test
    public void test07PuntajePenalidadJugadorMarca4OpcionesIncorrectasY1CorrectaYAsignaPuntajeCorrecto(){
        //Arrange
        PuntajePenalidad puntaje = new PuntajePenalidad();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("1", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("2", true);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("3", false);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("4", false);
        OpcionVerdaderoFalso opcion5 = new OpcionVerdaderoFalso("5", false);
        OpcionVerdaderoFalso opcion6 = new OpcionVerdaderoFalso("6", true);
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
        assertEquals(-3, jugador.getPuntaje());
    }
}
