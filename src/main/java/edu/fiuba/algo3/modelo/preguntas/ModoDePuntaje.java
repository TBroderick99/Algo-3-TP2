package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public interface ModoDePuntaje {

    public abstract void asignarPuntaje(RespuestaVerdaderoFalso respuesta, Jugador unJugador);
}
