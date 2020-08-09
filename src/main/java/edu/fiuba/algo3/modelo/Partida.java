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

    private Ronda ronda;


    private ArrayList<Jugador> jugadores;                 //sacar relacionado a jugadores, se encargan los turnos
    private Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;

    private ArrayList<Pregunta> preguntas;                //que se encargue un ManejadorDePreguntas quizas?
    private Iterator<Pregunta> iteradorPreguntas;
    private Pregunta preguntaActual;

    private ArrayList<Respuesta> respuestasRonda;         //cada turno tendria su respuesta

    private Partida(){
        this.ronda = new Ronda();
    }

    public static Partida getInstance(){
        return INSTANCE;
    }

    public void agregarJugadores(String nombreJugador1, String nombreJugador2){  //esta refactoreado abajo
        observers = new ArrayList<Observer>();

        this. jugadores = new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);


        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.iteradorJugadores = this.jugadores.iterator();
        this.jugadorActual = iteradorJugadores.next();

        this.respuestasRonda = new ArrayList<Respuesta>();

        this.preguntas = inicializarPreguntas();
        this.iteradorPreguntas = this.preguntas.iterator();
        this.preguntaActual = iteradorPreguntas.next();
    }

    public void inicializarPartida(){
        this.preguntas = inicializarPreguntas();
        this.iteradorPreguntas = this.preguntas.iterator();
        this.preguntaActual = iteradorPreguntas.next();                //que se encargue un manejador de preguntas?

        ronda.actualizar(preguntaActual);

    }

    public void agregarJugador(String nombre){
        Jugador jugador = new Jugador(nombre);
        ronda.agregarTurno(jugador);
    }


    private ArrayList<Pregunta> inicializarPreguntas() {
        return CreadorDePreguntas.crearPreguntas();
    }


    public void siguienteJugador(){                   // se deberia pasar de turno, el turno tiene el jugador
        if(iteradorJugadores.hasNext())
            jugadorActual = iteradorJugadores.next();
        notifyObservers();
    }


    public Jugador getJugadorActual() {                //el turno se guarda al jugador
        return jugadorActual;
    }

    public void siguienteRonda(){
        asignarPuntajes();
        this.iteradorJugadores = this.jugadores.iterator();
        this.jugadorActual = this.iteradorJugadores.next();

        if(iteradorPreguntas.hasNext()){
            this.preguntaActual = this.iteradorPreguntas.next();
        }
        else{
            //se terminaron las preguntas?
        }
        notifyObservers();
    }


    /*public void siguinteRonda(){                     //Refactor, nuevo codigo con la implementacion de ronda y turnos
        //asignarPuntajes();
        ronda.asignarPuntajes();
        Pregunta preguntaActual = siguientePregunta();
        ronda.actualizar(preguntaActual);

        notifyObservers();
    }*/

    private void asignarPuntajes() {                      //la ronda asigna los puntajes
        // Esto se evita en un futuro refactor.
        Respuesta[] _respuestas =  new Respuesta[]{respuestasRonda.get(0), respuestasRonda.get(1)};
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>(Arrays.asList(_respuestas));

        Jugador[] jugadores = new Jugador[]{this.jugadores.get(0), this.jugadores.get(1)};
        preguntaActual.asignarPuntajes(respuestas);
    }

    public String getNombreJugadorActual() {               //el turno guarda al jugador
        return jugadorActual.getNombre();
    }

    public Pregunta getPreguntaActual(){                   //ronda se guarda la pregunta actual
        return preguntaActual;
    }

    public void guardarRespuesta(Respuesta respuesta){     //responsabilidad de la ronda
        respuestasRonda.add(respuesta);
    }

    public Pregunta siguientePregunta(){
        if(!iteradorPreguntas.hasNext()) {
            //terminar partida()
        }
        return iteradorPreguntas.next();
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
