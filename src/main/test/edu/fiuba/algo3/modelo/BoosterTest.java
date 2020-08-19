package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.preguntas.boosters.BoosterMultiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoosterTest{

    @Test
    public void test01BoosterMultiplicaUnPuntajeCorrectamente(){
        //Arrange
        int puntajePositivo = 2;
        int puntajeNegativo = -2;
        Booster boosterPor2 = new BoosterMultiplicador(2);
        Booster boosterPor3 = new BoosterMultiplicador(3);

        //Act
        int resultadoPositivoBoosterPor2 = boosterPor2.multiplicarPuntaje(puntajePositivo);
        int resultadoPositivoBoosterPor3 = boosterPor3.multiplicarPuntaje(puntajePositivo);

        int resultadoNegativoBoosterPor2 = boosterPor2.multiplicarPuntaje(puntajeNegativo);
        int resultadoNegativoBoosterPor3 = boosterPor3.multiplicarPuntaje(puntajeNegativo);

        //Assert
        assertEquals(4, resultadoPositivoBoosterPor2);
        assertEquals(6, resultadoPositivoBoosterPor3);
        assertEquals(-4, resultadoNegativoBoosterPor2);
        assertEquals(-6, resultadoNegativoBoosterPor3);
    }

    @Test
    public void test02BoosterSeAgreganCorrectamente(){
        //Arrange
        Booster boosterAAcumular = new BoosterMultiplicador(2);
        Booster boosterPor3 = new BoosterMultiplicador(3);

        //Act
        boosterAAcumular.agregarBoost(boosterPor3);

        //Assert
        assertEquals(6, boosterAAcumular.getFactor());

    }

}