package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void test01JugadorSeCreaConNombreCorrecto(){
        //Arrange
        Jugador jugador = new Jugador("Juan");

        //Act
        String nombreJugador = jugador.getNombre();

        //Assert
        assertEquals("Juan", nombreJugador);
    }

    @Test
    public void test02JugadorEmpiezaSinPuntos(){
        //Arrange
        Jugador jugador = new Jugador("Juan");

        //Act
        int puntosJugador = jugador.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador);
    }

    @Test
    public void test03JugadorSumaPuntosCorrectamente(){
        //Arrange
        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(10);

        //Act
        int puntosJugador = jugador.getPuntaje();

        //Assert
        assertEquals(10, puntosJugador);
    }
}