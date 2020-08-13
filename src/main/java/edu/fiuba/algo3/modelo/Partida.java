package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.ManejadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Partida implements Observable {
    private static Partida instance = new Partida();

    private ArrayList<Observer> observers = new ArrayList<>();

    private Ronda ronda;
    public ManejadorDePreguntas manejadorDePreguntas;

    private Estado estado = Estado.INICIO;

    private Partida(){
        this.ronda = new Ronda();
    }

    public static synchronized Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    public void inicializarPartida(){                   //cuando los jugadores ya fueron agregados
        this.manejadorDePreguntas = new ManejadorDePreguntas();
        ronda.actualizar(getPreguntaActual());
        estado = Estado.JUGANDO;
    }

    public void inicializarPartida(ManejadorDePreguntas manejadorDePreguntas){ //Mock
        this.manejadorDePreguntas = manejadorDePreguntas;
        ronda.actualizar(getPreguntaActual());
        estado = Estado.JUGANDO;
    }

    public void agregarJugador(String nombre){
        Jugador jugador = new Jugador(nombre);
        ronda.agregarTurno(jugador);
    }

    public void siguienteTurno(){
        if (ronda.esUltimoTurno()){
            ronda.siguienteTurno();
            siguienteRonda();
        }
        else {
            ronda.siguienteTurno();
        }
        notifyObservers();
    }

    public void siguienteRonda(){     //Refactor, nuevo codigo con la implementacion de ronda y turnos
        ronda.asignarPuntajes();

        if(!manejadorDePreguntas.esLaUltimaPregunta()){
            manejadorDePreguntas.siguientePregunta();
            ronda.actualizar(getPreguntaActual());
        }
        else{
            estado = Estado.FINALIZADO;
        }

       //notifyObservers();
    }

    public void finalizarPartida() {}
    /*private void asignarPuntajes() {                      //la ronda asigna los puntajes
        // Esto se evita en un futuro refactor.
        Respuesta[] _respuestas =  new Respuesta[]{respuestasRonda.get(0), respuestasRonda.get(1)};
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(_respuestas));

        Jugador[] jugadores = new Jugador[]{this.jugadores.get(0), this.jugadores.get(1)};
        preguntaActual.asignarPuntajes(respuestas);
    }*/


    public Pregunta getPreguntaActual(){
        return manejadorDePreguntas.getPreguntaActual();
    }

    public Turno getTurnoActual(){
        return ronda.getTurnoActual();
    }

    public Jugador getJugadorActual(){                        //getter para que no rompa el controlador
        return ronda.getTurnoActual().getJugador();
    }

    public String getNombreJugadorActual(){                   //getter para que no rompa el controlador
        return ronda.getTurnoActual().getJugador().getNombre();
    }

    public Ronda getRonda(){
        return ronda;
    }

    public ArrayList<Jugador> getJugadores() {
        return ronda.getJugadores();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }

    public int cantidadJugadores() {
        return ronda.cantidadTurnos();
    }
}
