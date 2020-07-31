package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.selecciones.SeleccionVerdaderoFalso;

import java.util.ArrayList;

public class PuntajeParcial extends Puntaje {

    @Override
    public int asignarPuntaje(RespuestaVerdaderoFalso respuesta) {
        int puntajeASumar = 0;

        ArrayList<SeleccionVerdaderoFalso> selecciones = respuesta.getSelecciones();

        for (SeleccionVerdaderoFalso seleccion : selecciones){
            if(!seleccion.esCorrecta() && seleccion.fueMarcada()){
                return puntajeASumar = 0;

            }
            else if(seleccion.esCorrecta() && seleccion.fueMarcada()){
                puntajeASumar += 1;
            }
        }
        return puntajeASumar;
    }
}