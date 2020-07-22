package edu.fiuba.algo3.modelo.Respuesta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaSimpleTest {

    @Test
    public void test01CrearUnaRespuestaSimpleRecibeUnaOpcionComoStringYLaAlmacenaCorrectamente() {
        String[] opcion = new String[] {"Opcion 1"};
        Respuesta respuestaSimple = Respuesta.crearRespuestaSimple(opcion);
        assertEquals(opcion, respuestaSimple.getOpcion());
    }
    @Test
    public void test02CrearUnaRespuestaSimpleYPreguntarSiUnaRespuestaEsCorrectaCuandoEsIncorrectaDevuelveUnArrayDeBooleanConFalse() {
        Respuesta respuestaSimpleCorrecta = Respuesta.crearRespuestaSimple(new String[] {"Opcion Correcta"});
        Respuesta respuestaSimplePrueba = Respuesta.crearRespuestaSimple(new String[] {"Opcion Incorrecta"});
        Boolean[] valorEsperado = new Boolean[]{false};
        assertArrayEquals(valorEsperado, respuestaSimpleCorrecta.esCorrecta(respuestaSimplePrueba));
    }
    @Test
    public void test03CrearUnaRespuestaSimpleYPreguntarSiUnaRespuestaEsCorrectaCuandoLoEsDevuelveUnArrayDeBooleanConTrue() {
        Respuesta respuestaSimpleCorrecta = Respuesta.crearRespuestaSimple(new String[] {"Opcion Correcta"});
        Respuesta respuestaSimplePrueba = Respuesta.crearRespuestaSimple(new String[] {"Opcion Correcta"});
        Boolean[] valorEsperado = new Boolean[]{true};
        assertArrayEquals(valorEsperado, respuestaSimpleCorrecta.esCorrecta(respuestaSimplePrueba));
    }
}
