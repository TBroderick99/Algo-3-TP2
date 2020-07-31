package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;

import java.util.ArrayList;


public abstract class Pregunta{

    protected String textoPregunta;
    protected Puntaje puntaje;

    public String getTextoPregunta(){
        return textoPregunta;
    }

    public abstract RespuestaVerdaderoFalso crearRespuesta();

    public abstract ArrayList<OpcionVerdaderoFalso> getOpcionesCorrectas();

    public abstract ArrayList<OpcionVerdaderoFalso> getOpciones();

    public void asignarPuntajes(RespuestaVerdaderoFalso[] respuestasUsuarios, Jugador[] jugadores){

        for (int i = 0; i < respuestasUsuarios.length; i++){
            _asignarPuntaje(respuestasUsuarios[i], jugadores[i]);
        }
    }

    private void _asignarPuntaje(RespuestaVerdaderoFalso respuestaUsuario, Jugador unJugador){
        puntaje.asignarPuntaje(respuestaUsuario, unJugador);
    }
}