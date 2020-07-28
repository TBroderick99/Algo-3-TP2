package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajePenalidad implements ModoDePuntaje{

    @Override
    public void asignarPuntaje(Boolean[] aciertos, Jugador unJugador){

        int puntajeASumar = 0;

        for (int i = 0; i < aciertos.length; i++){

            if(!aciertos[i]){
                puntajeASumar -= 1;
            }
            else{
                puntajeASumar += 1;
            }
        }

        unJugador.sumarPuntos(puntajeASumar);
    }

}