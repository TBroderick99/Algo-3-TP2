package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.selecciones.SeleccionVerdaderoFalso;

import java.util.ArrayList;

public class PuntajeClasico implements ModoDePuntaje{

    @Override
    public void asignarPuntaje(RespuestaVerdaderoFalso respuesta, Jugador unJugador){

        int puntajeASumar = 1;

        ArrayList<SeleccionVerdaderoFalso> selecciones = respuesta.getSelecciones();

        for (int i = 0; i < selecciones.size(); i++){
            SeleccionVerdaderoFalso seleccion = selecciones.get(i);

            if( (!seleccion.esCorrecta() && seleccion.fueMarcada()) || seleccion.esCorrecta() && !seleccion.fueMarcada() ){
                puntajeASumar = 0;
                break;
            }
        }

        unJugador.sumarPuntos(puntajeASumar);
    }

}