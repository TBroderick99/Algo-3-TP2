package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public abstract class Puntaje {


    public void asignarPuntaje(Respuesta respuesta){
        int puntajeASumar = calcularPuntaje(respuesta);
        respuesta.getJugador().sumarPuntos(puntajeASumar);
    }

    public abstract int calcularPuntaje(Respuesta respuesta);


}