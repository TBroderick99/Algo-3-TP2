package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class PuntajePenalidad extends Puntaje {

    @Override
    public int calcularPuntaje(Respuesta respuesta) {
        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();
        int correctasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && sel.esCorrecta()).count();
        int incorrectasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && !sel.esCorrecta()).count();
        return correctasMarcadas - incorrectasMarcadas;

        /*
        int puntajeASumar = 0;

        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();

        for (Seleccion seleccion : selecciones){
            if(seleccion.fueMarcada() && seleccion.esCorrecta())
                puntajeASumar +=1 ;
            else if(seleccion.fueMarcada() && !seleccion.esCorrecta())
                puntajeASumar -= 1;
        }
        return puntajeASumar;
        */
    }
}