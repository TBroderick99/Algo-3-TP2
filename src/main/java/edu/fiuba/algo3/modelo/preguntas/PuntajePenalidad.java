package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.selecciones.SeleccionVerdaderoFalso;

import java.util.ArrayList;

public class PuntajePenalidad extends Puntaje {

    @Override
    public int asignarPuntaje(RespuestaVerdaderoFalso respuesta) {
        long incorrectasMarcadas = respuesta
                .getSelecciones()
                .stream()
                .filter(seleccion -> !seleccion.esCorrecta())
                .filter(seleccion -> seleccion.fueMarcada())
                .count();
        long correctasMarcadas = respuesta
                .getSelecciones()
                .stream()
                .filter(seleccion -> seleccion.esCorrecta())
                .filter(seleccion -> seleccion.fueMarcada())
                .count();
        return (int) (correctasMarcadas - incorrectasMarcadas);
    }
}