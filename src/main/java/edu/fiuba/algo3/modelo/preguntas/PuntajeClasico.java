package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class PuntajeClasico extends Puntaje {

    @Override
    public int calcularPuntaje(Respuesta respuesta){

        int puntajeASumar = 1;

        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();

        for ( Seleccion seleccion : selecciones){
            if( (seleccion.fueMarcada() && !seleccion.esCorrecta()) || (!seleccion.fueMarcada() && seleccion.debeSerMarcada()) ){
                return puntajeASumar = 0;

            }
        }
        return puntajeASumar;
    }

}