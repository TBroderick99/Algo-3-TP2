package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test01PreguntaVerdaderoFalsoSeCreaCorrectamente(){
        //Arrange
        String textoPregunta = "La UBA fue fundada en el año 1821";
        Pregunta pregunta = new Pregunta( textoPregunta, true);
        String valor;

        //Act
        valor = pregunta.getTexto();

        //Assert
        assertEquals(textoPregunta, valor);
    }

    @Test
    public void test02PreguntaVerdaderoFalsoTieneRespuestaCorrecta(){
        //Arrange
        String textoPregunta = "La UBA fue fundada en el año 1821";
        Pregunta pregunta = new Pregunta( textoPregunta, true);
        boolean respuesta;

        //Act
        respuesta = pregunta.getRespuesta();

        //Assert
        assertEquals(true, respuesta);
    }
}
