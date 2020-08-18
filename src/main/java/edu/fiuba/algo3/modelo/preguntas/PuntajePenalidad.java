package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class PuntajePenalidad extends Puntaje {
    private final String tipoPuntaje = "Penalidad";

    @Override
    public int calcularPuntaje(Respuesta respuesta) {
        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();
        int correctasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && sel.esCorrecta()).count();
        int incorrectasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && !sel.esCorrecta()).count();
        return correctasMarcadas - incorrectasMarcadas;
    }

    public String getTipo() {
        return tipoPuntaje;
    }
}