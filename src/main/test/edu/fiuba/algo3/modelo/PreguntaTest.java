package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.IRespuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaSimple;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test01PreguntaVerdaderoFalsoSeCreaCorrectamente(){
        //Arrange
        String textoPregunta = "La UBA fue fundada en el año 1821";
        String[] opciones = {"True","False"};
        IRespuesta respuestaCorrecta = new RespuestaSimple("True");
        Pregunta pregunta = new Pregunta( textoPregunta, opciones, respuestaCorrecta);
        String valor;

        //Act
        valor = pregunta.getTextoPregunta();

        //Assert
        assertEquals(textoPregunta, valor);
    }

    @Test
    public void test02PreguntaVerdaderoFalsoTieneRespuestaCorrecta(){
        //Arrange
        String textoPregunta = "La UBA fue fundada en el año 1821";
        String[] opciones = {"True","False"};
        IRespuesta respuestaCorrecta = new RespuestaSimple("True");
        Pregunta pregunta = new Pregunta( textoPregunta, opciones, respuestaCorrecta);

        //Act
        IRespuesta respuesta = pregunta.getRespuestaCorrecta();

        //Assert
        assertEquals(respuesta, respuestaCorrecta);
    }
}
