package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public abstract class Puntaje {
    public void asignarPuntaje(RespuestaVerdaderoFalso respuesta, Jugador unJugador){
        int puntajeASumar = asignarPuntaje(respuesta);
        unJugador.sumarPuntos(puntajeASumar);
    }

    public abstract int asignarPuntaje(RespuestaVerdaderoFalso respuesta);


}
