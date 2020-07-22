package edu.fiuba.algo3.modelo.Respuesta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaMultipleTest {
    @Test
    public void test01CrearUnaRespuestaMultipleRecibeOpcionesComoStringsYLasAlmacenaCorrectamente() {
        String[] opciones = new String[]{"Opcion 1", "Opcion 2"};
        RespuestaMultiple respuestaMultiple = new RespuestaMultiple(opciones);
        assertEquals(opciones, respuestaMultiple.getOpcion());
    }
    @Test
    public void test02CrearUnaRespuestaMultipleYPreguntarSiUnaRespuestaEsCorrectaCuandoEsIncorrectaDevuelveUnArrayDeBooleanConFalse() {
        String[] opcionesCorrectas = new String[]{"Opcion Correcta 1", "Opcion Correcta 2"};
        String[] opcionesPrueba = new String[]{"Opcion Incorrecta 1", "Opcion Incorrecta 2"};
        Respuesta respuestaMultipleCorrecta = Respuesta.crearRespuestaMultiple(opcionesCorrectas);
        Respuesta respuestaMultiplePrueba = Respuesta.crearRespuestaMultiple(opcionesPrueba);
        Boolean[] valorEsperado = new Boolean[]{false, false};
        assertArrayEquals(valorEsperado, respuestaMultipleCorrecta.esCorrecta(respuestaMultiplePrueba));
    }
    @Test
    public void test03CrearUnaRespuestaMultipleYPreguntarSiUnaRespuestaEsCorrectaCuandoLoEsDevuelveUnArrayDeBooleanConTrue() {
        String[] opcionesCorrectas = new String[]{"Opcion Correcta 1", "Opcion Correcta 2"};
        String[] opcionesPrueba = new String[]{"Opcion Correcta 1", "Opcion Correcta 2"};
        Respuesta respuestaMultipleCorrecta = Respuesta.crearRespuestaMultiple(opcionesCorrectas);
        Respuesta respuestaMultiplePrueba = Respuesta.crearRespuestaMultiple(opcionesPrueba);
        Boolean[] valorEsperado = new Boolean[]{true, true};
        assertArrayEquals(valorEsperado, respuestaMultipleCorrecta.esCorrecta(respuestaMultiplePrueba));
    }

    @Test
    public void test04CrearUnaRespuestaMultipleYPreguntarSiUnaRespuestaEsCorrectaCuandoParcialmenteLoEsDevuelveUnArrayDeBooleanConTrueYFalseSegunCorresponde() {
        String[] opcionesCorrectas = new String[]{"Opcion Correcta 1", "Opcion Correcta 2", "Opcion Correcta 3"};
        String[] opcionesPrueba = new String[]{"Opcion Correcta 1", "Opcion Incorrecta 2", "Opcion Correcta 3"};
        Respuesta respuestaMultipleCorrecta = Respuesta.crearRespuestaMultiple(opcionesCorrectas);
        Respuesta respuestaMultiplePrueba = Respuesta.crearRespuestaMultiple(opcionesPrueba);
        Boolean[] valorEsperado = new Boolean[]{true, false, true};
        assertArrayEquals(valorEsperado, respuestaMultipleCorrecta.esCorrecta(respuestaMultiplePrueba));
    }
}
