package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.Respuesta;

public class PuntajeClasico extends Puntaje {
    private final String tipoPuntaje = "Clásico";

    @Override
    public int calcularPuntaje(Respuesta respuesta){
        return respuesta.esPerfecta() ? 1: 0;
    }

    public String getTipo(){
        return tipoPuntaje;
    }
}