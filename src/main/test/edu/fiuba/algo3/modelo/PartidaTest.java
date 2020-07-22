package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    @Test
    public void test01PartidaSeCreaConJugadorActual(){
        //Arrange
        Partida partida = Partida.getInstance();
        partida.agregarJugadores("Juan", "Marcelo");

        //Act
        String nombreJugadorActual = partida.getNombreJugadorActual();

        //Assert
        assertEquals("Juan", nombreJugadorActual);
    }
}
