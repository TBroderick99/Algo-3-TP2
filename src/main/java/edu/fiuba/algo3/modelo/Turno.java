package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class Turno {

    private Jugador jugador;
    private Respuesta respuesta;

    public Turno(Jugador jugador){
        this.jugador = jugador;
    }


    public void actualizar(Pregunta pregunta){
        this.respuesta = new Respuesta(jugador, pregunta);
    }

    public void enviarRespuesta(Ronda ronda){
        ronda.recibirRespuesta(this.respuesta);
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }

    public Jugador getJugador(){
        return jugador;
    }

}
