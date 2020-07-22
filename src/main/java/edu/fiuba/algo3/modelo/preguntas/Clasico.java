package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;

public class Clasico implements ModoDePuntaje{

    @Override
    public void asignarPuntaje(Boolean[] aciertos, Jugador unJugador){

        int puntajeAAsignar = 1;

        for (int i = 0; i < aciertos.length; i++){

            if(!aciertos[i]){
                puntajeAAsignar = 0;
            }
        }

        unJugador.sumarPuntos(puntajeAAsignar);
    }

}