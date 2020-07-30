package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.selecciones.SeleccionVerdaderoFalso;

import java.util.ArrayList;


public class PuntajeParcial implements ModoDePuntaje{

    @Override
    public void asignarPuntaje(RespuestaVerdaderoFalso respuesta, Jugador unJugador) {

        int puntajeASumar = 0;

        ArrayList<SeleccionVerdaderoFalso> selecciones = respuesta.getSelecciones();

        for (int i = 0; i < selecciones.size(); i++){
            SeleccionVerdaderoFalso seleccion = selecciones.get(i);

            if( (!seleccion.esCorrecta() && seleccion.fueMarcada()) ){
                puntajeASumar = 0;
                break;
            }
            else if(seleccion.esCorrecta() && seleccion.fueMarcada()){
                puntajeASumar += 1;
            }
        }

        unJugador.sumarPuntos(puntajeASumar);
    }
}