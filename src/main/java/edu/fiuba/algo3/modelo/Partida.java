package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import java.util.ArrayList;
import java.util.Iterator;


public class Partida {
    private static Partida INSTANCE = new Partida();
    private ArrayList<Jugador> jugadores;
    private Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;
    private ArrayList<Pregunta> preguntas;
    private Iterator<Pregunta> iteradorPreguntas;
    private Pregunta preguntaActual;

    private ArrayList<RespuestaVerdaderoFalso> respuestasRonda;

    private Partida(){}

    public static Partida getInstance(){
        return INSTANCE;
    }

    public void agregarJugadores(String nombreJugador1, String nombreJugador2){
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);
        this. jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.iteradorJugadores = this.jugadores.iterator();
        this.jugadorActual = iteradorJugadores.next();

        this.respuestasRonda = new ArrayList<RespuestaVerdaderoFalso>();
        this.preguntas = inicializarPreguntas();

        this.iteradorPreguntas = this.preguntas.iterator();
        this.preguntaActual = iteradorPreguntas.next();
    }

    private ArrayList<Pregunta> inicializarPreguntas() {
        return CreadorDePreguntas.crearPreguntas();
    }

    public void siguienteJugador(){
        if(iteradorJugadores.hasNext())
            jugadorActual = iteradorJugadores.next();
    }
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    public void siguinteRonda(){
        asignarPuntajes();

        this.iteradorJugadores = this.jugadores.iterator();
        this.jugadorActual = iteradorJugadores.next();

        if(iteradorPreguntas.hasNext())
            preguntaActual = iteradorPreguntas.next();
        else;
            //se terminaron las preguntas¿?
    }

    private void asignarPuntajes() {
        // Esto se evita en un futuro refactor.
        RespuestaVerdaderoFalso[] respuestas = new RespuestaVerdaderoFalso[]{respuestasRonda.get(0), respuestasRonda.get(1)};
        Jugador[] jugadores = new Jugador[]{this.jugadores.get(0), this.jugadores.get(1)};
        preguntaActual.asignarPuntajes(respuestas, jugadores);
    }

    public String getNombreJugadorActual() {
        return jugadorActual.getNombre();
    }

    public Pregunta getPreguntaActual(){
        return preguntaActual;
    }

    public void guardarRespuesta(RespuestaVerdaderoFalso respuesta){
        respuestasRonda.add(respuesta);
    }
}
