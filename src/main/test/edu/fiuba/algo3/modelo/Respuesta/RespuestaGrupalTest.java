package edu.fiuba.algo3.modelo.Respuesta;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaGrupalTest {

    @Test
    public void test01CrearUnaRespuestaGrupalRecibeOpcionesComoStringsYLasAlmacenaCorrectamente() {
        String[] grupoA = new String[]{"Opcion 1", "Opcion 2"};
        String[] grupoB = new String[]{"Opcion 3", "Opcion 4"};
        Respuesta respuestaGrupal = Respuesta.crearRespuestaGrupal(Stream.of(grupoA, grupoB).flatMap(Stream::of).toArray(String[]::new));
        assertArrayEquals(grupoA, Arrays.copyOfRange(respuestaGrupal.getOpcion(), 0, respuestaGrupal.getOpcion().length/2));
        assertArrayEquals(grupoB, Arrays.copyOfRange(respuestaGrupal.getOpcion(), respuestaGrupal.getOpcion().length/2, respuestaGrupal.getOpcion().length));
    }
    @Test
    public void test02CrearUnaRespuestaGrupalYPreguntarSiUnaRespuestaEsCorrectaCuandoEsIncorrectaDevuelveUnArrayDeBooleanConFalse() {
        String[] grupoACorrecto = new String[]{"Opcion Correcta 1", "Opcion Correcta 2"};
        String[] grupoBCorrecto = new String[]{"Opcion Correcta 3", "Opcion Correcta 4"};
        String[] grupoAPrueba = new String[]{"Opcion Incorrecta 1", "Opcion Incorrecta 2"};
        String[] grupoBPrueba = new String[]{"Opcion Incorrecta 3", "Opcion Incorrecta 4"};
        Respuesta respuestaGrupalCorrecta = Respuesta.crearRespuestaGrupal(Stream.of(grupoACorrecto, grupoBCorrecto).flatMap(Stream::of).toArray(String[]::new));
        Respuesta respuestaGrupalPrueba = Respuesta.crearRespuestaGrupal(Stream.of(grupoAPrueba, grupoBPrueba).flatMap(Stream::of).toArray(String[]::new));
        Boolean[] valorEsperado = new Boolean[]{false, false};
        assertArrayEquals(valorEsperado, respuestaGrupalCorrecta.esCorrecta(respuestaGrupalPrueba));
    }
    @Test
    public void test03CrearUnaRespuestaGrupalYPreguntarSiUnaRespuestaEsCorrectaCuandoLoEsDevuelveUnArrayDeBooleanConTrue() {
        String[] grupoACorrecto = new String[]{"Opcion Correcta 1", "Opcion Correcta 2"};
        String[] grupoBCorrecto = new String[]{"Opcion Correcta 3", "Opcion Correcta 4"};
        String[] grupoAPrueba = new String[]{"Opcion Correcta 1", "Opcion Correcta 2"};
        String[] grupoBPrueba = new String[]{"Opcion Correcta 3", "Opcion Correcta 4"};
        Respuesta respuestaGrupalCorrecta = Respuesta.crearRespuestaGrupal(Stream.of(grupoACorrecto, grupoBCorrecto).flatMap(Stream::of).toArray(String[]::new));
        Respuesta respuestaGrupalPrueba = Respuesta.crearRespuestaGrupal(Stream.of(grupoAPrueba, grupoBPrueba).flatMap(Stream::of).toArray(String[]::new));
        Boolean[] valorEsperado = new Boolean[]{true, true};
        assertArrayEquals(valorEsperado, respuestaGrupalCorrecta.esCorrecta(respuestaGrupalPrueba));
    }
}
