package edu.fiuba.algo3.modelo.Respuesta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaGrupalTest {

    @Test
    public void test01CrearUnaRespuestaGrupalRecibeDosArrayListDeStringsYLosAlmacenaCorrectamente() {
        ArrayList<String> opcionA = new ArrayList<>(Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3"));
        ArrayList<String> opcionB = new ArrayList<>(Arrays.asList("Opcion 4", "Opcion 5", "Opcion 6"));
        RespuestaGrupal respuestaGrupal = new RespuestaGrupal(opcionA, opcionB);
        assertEquals(opcionA, respuestaGrupal.getOpcionA());
        assertEquals(opcionB, respuestaGrupal.getOpcionB());
    }

}
