package edu.fiuba.algo3.modelo.Respuesta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaSimpleTest {

    @Test
    public void test01CrearUnaRespuestaSimpleRecibeUnaOpcionComoStringYLaAlmacenaCorrectamente() {
        String opcion = "Opcion 1";
        RespuestaSimple respuestaSimple = new RespuestaSimple(opcion);
        assertEquals(opcion, respuestaSimple.getOpcion());
    }
    @Test
    public void test02CrearUnaRespuestaSimpleYPreguntarSiUnaOpcionEsCorrectaCuandoEsIncorrectaDevuelveUnArrayListConFalse() {
        String opcionCorrecta = "Opcion Correcta";
        String opcionIncorrecta = "Opcion Incorrecta";
        ArrayList<Boolean> opcionEsperada = new ArrayList<>(Arrays.asList(false));
        RespuestaSimple respuestaSimple = new RespuestaSimple(opcionCorrecta);
        assertEquals(opcionEsperada, respuestaSimple.esCorrecta(opcionIncorrecta));
    }
    @Test
    public void test03CrearUnaRespuestaSimpleYPreguntarSiUnaOpcionEsCorrectaCuandoEsCorrectaDevuelveUnArrayListConTrue() {
        String opcionCorrecta = "Opcion Correcta";
        ArrayList<Boolean> opcionEsperada = new ArrayList<>(Arrays.asList(true));
        RespuestaSimple respuestaSimple = new RespuestaSimple(opcionCorrecta);
        assertEquals(opcionEsperada, respuestaSimple.esCorrecta(opcionCorrecta));
    }
}
