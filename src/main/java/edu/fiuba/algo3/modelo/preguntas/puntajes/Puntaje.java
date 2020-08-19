package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.Respuesta;

public abstract class Puntaje {


    public void asignarPuntaje(Respuesta respuesta){
        int puntajeASumar = calcularPuntaje(respuesta);
        respuesta.sumarPuntajeAJugador(puntajeASumar);
    }

    public abstract int calcularPuntaje(Respuesta respuesta);

    public abstract String getTipo();
}
