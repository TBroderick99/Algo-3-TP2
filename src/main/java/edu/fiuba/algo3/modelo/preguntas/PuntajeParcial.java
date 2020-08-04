package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class PuntajeParcial extends Puntaje {

    @Override
    public int calcularPuntaje(Respuesta respuesta) {
        int puntajeASumar = 0;

        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();

        for (Seleccion seleccion : selecciones){
            if(seleccion.fueMarcada() && !seleccion.esCorrecta()){
                return puntajeASumar = 0;

            }
            else if(seleccion.fueMarcada() && seleccion.esCorrecta()){
                puntajeASumar += 1;
            }
        }
        return puntajeASumar;
    }
}