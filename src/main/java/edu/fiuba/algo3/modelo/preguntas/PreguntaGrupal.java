package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class PreguntaGrupal extends Pregunta{

    private final ArrayList<Grupo> grupos;

    public PreguntaGrupal(String textoPregunta, ArrayList<Opcion> opciones, Puntaje modoDePuntaje, String tipoPregunta, ArrayList<Grupo> grupos) {
        super(textoPregunta, opciones, modoDePuntaje, tipoPregunta);
        this.grupos = grupos;
    }

    @Override
    public ArrayList<Grupo> getGrupos() {
        return this.grupos;
    }
}
