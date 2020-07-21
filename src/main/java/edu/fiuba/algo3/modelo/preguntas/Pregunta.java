package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.IRespuesta;

import java.util.ArrayList;

public class Pregunta{

    private String textoPregunta;
    private String[] opciones;
    private ModoDePuntaje modoDePuntaje;
    private IRespuesta respuestaCorrecta;


    public Pregunta(String textoPregunta, String[] opciones , IRespuesta respuestaCorrecta){
        this.textoPregunta = textoPregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.modoDePuntaje = new Clasico();

    }


    public String getTextoPregunta(){
        return textoPregunta;
    }


    public String[] getOpciones(){
        return opciones;
    }


    public IRespuesta getRespuestaCorrecta(){
        return respuestaCorrecta;
    }


    public void asignarPuntajes(IRespuesta[] respuestasUsuarios, Jugador[] jugadores){

        for (int i = 0; i < respuestasUsuarios.length; i++){
            _asignarPuntaje(respuestasUsuarios[i], jugadores[i]);
        }
    }


    private void _asignarPuntaje(IRespuesta respuestaUsuario, Jugador unJugador){
        ArrayList<Boolean> aciertos = respuestaUsuario.esCorrecta(respuestaCorrecta);
        modoDePuntaje.asignarPuntaje(aciertos, unJugador);
    }

}