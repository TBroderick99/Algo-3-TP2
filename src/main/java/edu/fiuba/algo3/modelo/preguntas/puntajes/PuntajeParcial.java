package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Seleccion;

import java.util.ArrayList;

public class PuntajeParcial extends Puntaje {
    private final String tipoPuntaje = "Parcial";

    @Override
    public int calcularPuntaje(Respuesta respuesta) {
        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();
        int puntajeASumar = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && sel.esCorrecta()).count();
        int incorrectasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && !sel.esCorrecta()).count();
        return incorrectasMarcadas > 0 ? 0 : puntajeASumar;
    }

    public String getTipo() {
        return tipoPuntaje;
    }
}