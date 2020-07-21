package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;

public class Clasico implements ModoDePuntaje{

    @Override
    public void asignarPuntaje(ArrayList<Boolean> aciertos, Jugador unJugador){

        int puntajeAAsignar = 1;

        for (int i = 0; i < aciertos.size(); i++){

            if(!aciertos.get(i)){
                puntajeAAsignar = 0;
            }
        }

        unJugador.sumarPuntos(puntajeAAsignar);
    }

}