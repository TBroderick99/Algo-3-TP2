package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class PuntajeClasico extends Puntaje {

    @Override
    public int calcularPuntaje(Respuesta respuesta){
        //TO DO: ESTE CODIGO SE PUEDE REEMPLAZAR CON ESTA LINEA, HACE LO MISMO PERO EN RESPUESTA
        /*respuesta.esPefecta() ? return 1: return 0;*/

        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();
        int correctasNoMarcadas = (int) selecciones.stream().filter(sel ->!sel.fueMarcada() && sel.debeSerMarcada()).count();
        System.out.println(correctasNoMarcadas);
        int incorrectasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && !sel.esCorrecta()).count();
        System.out.println(incorrectasMarcadas);
        return (correctasNoMarcadas + incorrectasMarcadas) > 0 ? 0 : 1;

        /*
        int puntajeASumar = 1;

        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();

        for ( Seleccion seleccion : selecciones){
            if( (seleccion.fueMarcada() && !seleccion.esCorrecta()) || (!seleccion.fueMarcada() && seleccion.debeSerMarcada()) ){
                return puntajeASumar = 0;

            }
        }

        return puntajeASumar;
        */
    }

}