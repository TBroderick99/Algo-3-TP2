package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {

    @Test
    public void test01PartidaAgregaJugador() {
        //Arrange
        Partida partida = new Partida();

        //Act
        partida.agregarJugador("Juan");
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
        Jugador jugador = partida.getJugadorActual();
        String nombreJugador = jugador.getNombre();

        //Assert
        assertEquals("Juan", nombreJugador);

    }


    @Test
    public void test02TrasInicializarPartidaLaRondaEsLaNumero1yTienePreguntaInicial()  {
        //Arrange
        Partida partida = new Partida();

        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        Ronda ronda = partida.getRonda();

        //Act
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
        int numeroDeRonda = ronda.getNumeroDeRonda();


        //Assert
        assertEquals(1, numeroDeRonda);
        assertEquals(partida.getPreguntaActual(), ronda.getPreguntaActual());

    }

    @Test
    public void test03PartidaPasaDeRonda() throws NoHaySiguienteTurnoError, NoHaySiguienteRondaError {
        //Arrange
        Partida partida = new Partida();
        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
        Ronda ronda = partida.getRonda();

        assertEquals(1, ronda.getNumeroDeRonda());

        partida.siguienteTurno();
        partida.siguienteRonda();

        //Act
        int numeroDeRonda = ronda.getNumeroDeRonda();
        Pregunta preguntaActual = ronda.getPreguntaActual();

        //Assert
        assertEquals(2, numeroDeRonda);
        assertEquals( partida.getPreguntaActual(), preguntaActual);
    }
}
