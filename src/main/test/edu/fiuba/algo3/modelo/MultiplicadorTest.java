package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.BoosterMultiplicador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplicadorTest{

    @Test
    public void test01MultiplicadorSeCreaConFactorCorrecto(){
        //Arrange
        Booster boosterPor2 = new BoosterMultiplicador(2);
        Booster boosterPor3 = new BoosterMultiplicador(3);

        //Act
        int factorBoosterPor2 = boosterPor2.getFactor();
        int factorBoosterPor3 = boosterPor3.getFactor();

        //Assert
        assertEquals(2, factorBoosterPor2);
        assertEquals(3, factorBoosterPor3);
    }

    @Test
    public void test02MultiplicadorSeAplicaCorrectamente(){
        //Arrange
        Jugador jugador = new Jugador("juan");
        Puntaje puntaje = new PuntajeClasico();

        String textoPregunta = "¿Cuáles de los siguientes números son primos?";
        Opcion opcion1 = new Opcion("7", new Valor(true));

        ArrayList<Opcion> opciones = new ArrayList<>(
                Arrays.asList(opcion1)
        );

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        Booster boosterPor2 = new BoosterMultiplicador(2);

        boosterPor2.aplicarBoost(respuestaJugador);

        //Act
        Booster boosterRespuesta = respuestaJugador.getBooster();

        //Assert
        assertEquals(boosterPor2, boosterRespuesta);
    }


}

