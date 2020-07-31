package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.PuntajeClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoRecibeRespuestaCorrectaDeJugadorYAsignaPuntaje(){
        //Arrange
        PuntajeClasico puntaje = new PuntajeClasico();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("Verdadero", true);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("Falso", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.marcar(0);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02PuntajeClasicoRecibeRespuestaIncorrectaDeJugadorYNoAsignaPuntaje(){
        //Arrange
        PuntajeClasico puntaje = new PuntajeClasico();
        Jugador jugador = new Jugador("Juan");

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("Verdadero", true);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("Falso", false);
        respuesta.agregarSeleccion(opcion1);
        respuesta.agregarSeleccion(opcion2);
        respuesta.marcar(1);

        //Act
        puntaje.asignarPuntaje(respuesta, jugador);

        //Assert
        assertEquals(0, jugador.getPuntaje());
    }
}
