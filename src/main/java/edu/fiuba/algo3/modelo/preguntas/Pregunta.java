package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaSimple;

import java.util.ArrayList;

//PREGUNTA VERDADERO Y FALSO

public class Pregunta{

    private String textoPregunta;
    private String[] opciones;
    private ModoDePuntaje modoDePuntaje;
    private RespuestaSimple respuestaCorrecta;

    //recibe respuestasimple, esta es solo verdadero y falso
    public Pregunta(String textoPregunta, String[] opciones , RespuestaSimple respuestaCorrecta){
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


    public RespuestaSimple getRespuestaCorrecta(){
        return respuestaCorrecta;
    }


    public void asignarPuntajes(RespuestaSimple[] respuestasUsuarios, Jugador[] jugadores){

        for (int i = 0; i < respuestasUsuarios.length; i++){
            _asignarPuntaje(respuestasUsuarios[i], jugadores[i]);
        }
    }

    private void _asignarPuntaje(RespuestaSimple respuestaUsuario, Jugador unJugador){
        Boolean[] aciertos = respuestaUsuario.esCorrecta(respuestaCorrecta);
        modoDePuntaje.asignarPuntaje(aciertos, unJugador);
    }

}