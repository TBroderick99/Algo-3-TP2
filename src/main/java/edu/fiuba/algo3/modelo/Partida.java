package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Partida implements Observable {
    private static Partida INSTANCE = new Partida();

    private ArrayList<Observer> observers;

    private ArrayList<Jugador> jugadores;
    private Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;
    private ArrayList<Pregunta> preguntas;
    private Iterator<Pregunta> iteradorPreguntas;
    private Pregunta preguntaActual;

    private ArrayList<Respuesta> respuestasRonda;

    private Partida(){}

    public static Partida getInstance(){
        return INSTANCE;
    }

    public void agregarJugadores(String nombreJugador1, String nombreJugador2){
        observers = new ArrayList<Observer>();
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);
        this. jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.iteradorJugadores = this.jugadores.iterator();
        this.jugadorActual = iteradorJugadores.next();

        this.respuestasRonda = new ArrayList<Respuesta>();
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
        notifyObservers();
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
        notifyObservers();
    }

    private void asignarPuntajes() {
        // Esto se evita en un futuro refactor.
        Respuesta[] _respuestas =  new Respuesta[]{respuestasRonda.get(0), respuestasRonda.get(1)};
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>(Arrays.asList(_respuestas));

        Jugador[] jugadores = new Jugador[]{this.jugadores.get(0), this.jugadores.get(1)};
        preguntaActual.asignarPuntajes(respuestas);
    }

    public String getNombreJugadorActual() {
        return jugadorActual.getNombre();
    }

    public Pregunta getPreguntaActual(){
        return preguntaActual;
    }

    public void guardarRespuesta(Respuesta respuesta){
        respuestasRonda.add(respuesta);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.change());
    }
}
