package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeSorterTest {

    @Test
    public void test01SiJugador1TieneMasPuntajeQueJugador2DevuelveMenorA0() {
        PuntajeSorter ordenador = new PuntajeSorter();
        Jugador jugador1 = new Jugador();
        jugador1.setPuntaje(2);
        Jugador jugador2 = new Jugador();
        jugador2.setPuntaje(1);
        assertEquals(ordenador.compare(jugador1, jugador2), -1);
    }
    @Test
    public void test02SiJugador1TieneIgualPuntajeQueJugador2Devuelve0() {
        PuntajeSorter ordenador = new PuntajeSorter();
        Jugador jugador1 = new Jugador();
        jugador1.setPuntaje(1);
        Jugador jugador2 = new Jugador();
        jugador2.setPuntaje(1);
        assertEquals(ordenador.compare(jugador1, jugador2), 0);
    }
    @Test
    public void test03SiJugador1TieneMenosPuntajeQueJugador2DevuelveMayorA0() {
        PuntajeSorter ordenador = new PuntajeSorter();
        Jugador jugador1 = new Jugador();
        jugador1.setPuntaje(1);
        Jugador jugador2 = new Jugador();
        jugador2.setPuntaje(2);
        assertEquals(ordenador.compare(jugador1, jugador2), 1);
    }
}
