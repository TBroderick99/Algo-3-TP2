package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico implements ModoDePuntaje{

    @Override
    public void asignarPuntaje(Boolean[] aciertos, Jugador unJugador){

        int puntajeASumar = 1;

        for (int i = 0; i < aciertos.length; i++){

            if(!aciertos[i]){
                puntajeASumar = 0;
            }
        }

        unJugador.sumarPuntos(puntajeASumar);
    }

}