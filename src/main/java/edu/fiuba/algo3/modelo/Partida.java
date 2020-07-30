package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import java.util.ArrayList;
import java.util.Iterator;


public class Partida {
    private static Partida INSTANCE = new Partida();
    private Jugador jugadorActual;
    private ArrayList<Pregunta> preguntas;
    private Iterator<Pregunta> iteradorPreguntas;
    private Pregunta preguntaActual;

    /*private ArrayList<RespuestaSimple> respuestasRonda;

    private Partida(){}

    public static Partida getInstance(){
        return INSTANCE;
    }

    public void agregarJugadores(String nombreJugador1, String nombreJugador2){
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);
        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
        this.jugadorActual = jugador1;
        this.respuestasRonda = new ArrayList<RespuestaSimple>();

        this.preguntas = inicializarPreguntas();
        this.iteradorPreguntas = this.preguntas.iterator();
        this.preguntaActual = iteradorPreguntas.next();
    }

    private ArrayList<Pregunta> inicializarPreguntas() {
        return CreadorDePreguntas.crearPreguntas();
    }

    public void siguienteJugador(){
        jugadorActual = jugadorActual.getOponente();
    }
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    public void siguinteRonda(){
        asignarPuntajes();
        jugadorActual = jugadorActual.getOponente();
        if(iteradorPreguntas.hasNext())
            preguntaActual = iteradorPreguntas.next();
        else;
            //se terminaron las preguntas¿?
    }

    private void asignarPuntajes() {
        // Esto se evita en un futuro refactor.
        RespuestaSimple[] respuestas = new RespuestaSimple[]{respuestasRonda.get(0), respuestasRonda.get(1)};
        Jugador[] jugadores = new Jugador[]{jugadorActual, jugadorActual.getOponente()};
        preguntaActual.asignarPuntajes(respuestas, jugadores);
    }

    public String getNombreJugadorActual() {
        return jugadorActual.getNombre();
    }

    public Pregunta getPreguntaActual(){
        return preguntaActual;
    }

    public void guardarRespuesta(RespuestaSimple respuesta){
        respuestasRonda.add(respuesta);
    }*/
}
