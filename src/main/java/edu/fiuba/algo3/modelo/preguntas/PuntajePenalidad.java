package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.selecciones.SeleccionVerdaderoFalso;

import java.util.ArrayList;

public class PuntajePenalidad extends Puntaje {

    @Override
    public int asignarPuntaje(RespuestaVerdaderoFalso respuesta) {
//        int puntajeASumar = 0;
//
//        ArrayList<SeleccionVerdaderoFalso> selecciones = respuesta.getSelecciones();
//
//        for (SeleccionVerdaderoFalso seleccion : selecciones){
//            if(seleccion.esCorrecta() && seleccion.fueMarcada())
//                puntajeASumar +=1 ;
//            else if(!seleccion.esCorrecta() && seleccion.fueMarcada())
//                puntajeASumar -= 1;
//        }
//        return puntajeASumar;
        long incorrectasMarcadas = respuesta
                .getSelecciones()
                .stream()
                .filter(seleccion -> !seleccion.esCorrecta())
                .filter(seleccion -> seleccion.fueMarcada())
                .count();
        long correctasMarcadas = respuesta
                .getSelecciones()
                .stream()
                .filter(seleccion -> seleccion.esCorrecta())
                .filter(seleccion -> seleccion.fueMarcada())
                .count();
        return (int) (correctasMarcadas - incorrectasMarcadas);
    }
}