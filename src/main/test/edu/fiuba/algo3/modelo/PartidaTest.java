package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {



    // Para que esté bien testeado, habría que hacer un mock de CreadorDePreguntas

    @BeforeEach
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Partida.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void test01PartidaAgregaJugador(){
        //Arrange
        Partida partida = Partida.getInstance();

        //Act
        partida.agregarJugador("Juan");
        partida.inicializarPartida();
        Jugador jugador = partida.getJugadorActual();
        String nombreJugador = jugador.getNombre();

        //Assert
        assertEquals("Juan", nombreJugador);

    }


    @Test
    public void test02TrasInicializarPartidaLaRondaEsLaNumero1yTienePreguntaInicial(){
        //Arrange
        Partida partida = Partida.getInstance();

        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        Ronda ronda = partida.getRonda();

        //Act
        partida.inicializarPartida();
        int numeroDeRonda = ronda.getNumeroDeRonda();


        //Assert
        assertEquals(1, numeroDeRonda);
        assertEquals(partida.getPreguntaActual(), ronda.getPreguntaActual());

    }

    @Test
    public void test03PartidaPasaDeRonda(){
        //Arrange
        Partida partida = Partida.getInstance();
        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        partida.inicializarPartida();
        Ronda ronda = partida.getRonda();

        assertEquals(1, ronda.getNumeroDeRonda());


        ronda.siguienteTurno();
        ronda.siguienteTurno();
        partida.siguienteRonda();

        //Act
        int numeroDeRonda = ronda.getNumeroDeRonda();
        Pregunta preguntaActual = ronda.getPreguntaActual();

        //Assert
        assertEquals(2, numeroDeRonda);
        assertEquals( partida.getPreguntaActual(), preguntaActual);
    }
}
