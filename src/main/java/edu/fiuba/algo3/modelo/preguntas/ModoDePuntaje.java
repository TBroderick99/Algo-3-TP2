package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;

public interface ModoDePuntaje {

    public abstract void asignarPuntaje(Boolean[] aciertos, Jugador unJugador);
}
