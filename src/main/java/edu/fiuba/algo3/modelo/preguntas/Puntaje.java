package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Booster;

public abstract class Puntaje {


    public void asignarPuntaje(Respuesta respuesta){
        int puntajeASumar = calcularPuntaje(respuesta);
        System.out.print(puntajeASumar);
        respuesta.sumarPuntajeAJugador(puntajeASumar);
    }

    public abstract int calcularPuntaje(Respuesta respuesta);


}
