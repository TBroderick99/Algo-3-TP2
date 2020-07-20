package edu.fiuba.algo3.modelo.Respuesta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaMultipleTest {
    @Test
    public void test01CrearUnaRespuestaMultipleRecibeUnArrayListDeStringsYLoAlmacenaCorrectamente() {
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3"));
        RespuestaMultiple respuestaMultiple = new RespuestaMultiple(opciones);
        assertEquals(opciones, respuestaMultiple.getOpciones());
    }
    @Test
    public void test02CrearUnaRespuestaMultipleYPreguntarSiUnaListaDeOpcionesEsCorrectaCuandoSonTodasIncorrectasDevuelveUnArrayListConTodosSusElementosFalse() {
        ArrayList<String> opcionesCorrectas = new ArrayList<>(Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"));
        ArrayList<String> opcionesIncorrectas = new ArrayList<>(Arrays.asList("Falso", "Falso", "Falso", "Falso"));
        ArrayList<Boolean> respuestaEsperada = new ArrayList<>(Arrays.asList(false, false, false, false));
        RespuestaMultiple respuestaMultiple = new RespuestaMultiple(opcionesCorrectas);
        assertEquals(respuestaEsperada, respuestaMultiple.esCorrecta(opcionesIncorrectas));
    }
    @Test
    public void test03CrearUnaRespuestaMultipleYPreguntarSiUnaListaDeOpcionesEsCorrectaCuandoSonTodasCorrectasDevuelveUnArrayListConTodosSusElementosTrue() {
        ArrayList<String> opcionesCorrectas = new ArrayList<>(Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"));
        ArrayList<Boolean> respuestaEsperada = new ArrayList<>(Arrays.asList(true, true, true, true));
        RespuestaMultiple respuestaMultiple = new RespuestaMultiple(opcionesCorrectas);
        assertEquals(respuestaEsperada, respuestaMultiple.esCorrecta(opcionesCorrectas));
    }
    @Test
    public void test04CrearUnaRespuestaMultipleYPreguntarSiUnaListaDeOpcionesEsCorrectaCuandoHayCorrectasEIncorrectasDevuelveUnArrayListConTrueYFalseEnLosIndicesCorrespondientes() {
        ArrayList<String> opcionesCorrectas = new ArrayList<>(Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"));
        ArrayList<String> opcionesElegidas = new ArrayList<>(Arrays.asList("Opcion 1", "Opcion 5", "Opcion 3", "Opcion 7"));
        ArrayList<Boolean> respuestaEsperada = new ArrayList<>(Arrays.asList(true, false, true, false));
        RespuestaMultiple respuestaMultiple = new RespuestaMultiple(opcionesCorrectas);
        assertEquals(respuestaEsperada, respuestaMultiple.esCorrecta(opcionesElegidas));
    }
}
