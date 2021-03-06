package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.preguntas.ManejadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;


public class Partida implements Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    private Ronda ronda;
    public ManejadorDePreguntas manejadorDePreguntas;

    private final int CANTIDAD_JUGADORES = 2;

    public Partida(){
        this.ronda = new Ronda();
    }


    public void inicializarPartida(ArrayList<Pregunta> preguntas){                   //cuando los jugadores ya fueron agregados
        this.manejadorDePreguntas = new ManejadorDePreguntas(preguntas);
        ronda.actualizar(getPreguntaActual());
    }

    public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        ronda.agregarTurno(jugador);

    }

    public void siguienteTurno() throws NoHaySiguienteTurnoError {
        ronda.siguienteTurno();
        notifyObservers();
    }


    public void enviarRespuesta() {
        ronda.enviarRespuesta();
    }

    public void siguienteRonda() throws NoHaySiguienteRondaError {
        if(!manejadorDePreguntas.esLaUltimaPregunta()){
            manejadorDePreguntas.siguientePregunta();
            ronda.actualizar(getPreguntaActual());
            notifyObservers();
        }
        else {
            notifyObservers();
            throw new NoHaySiguienteRondaError();
        }
    }

    public void asignarPuntajes() {
        ronda.asignarPuntajes();
    }

    public Pregunta getPreguntaActual(){
        return manejadorDePreguntas.getPreguntaActual();
    }

    public Turno getTurnoActual(){
        return ronda.getTurnoActual();
    }

    public Ronda getRonda(){
        return ronda;
    }

    public Jugador getJugadorActual(){                        //getter para que no rompa el controlador
        return ronda.getTurnoActual().getJugador();
    }

    public String getNombreJugadorActual(){                   //getter para que no rompa el controlador
        return ronda.getTurnoActual().getJugador().getNombre();
    }

    public ArrayList<Jugador> getJugadores() {
        return ronda.getJugadores();
    }

    public int cantidadJugadoresAgregados() {
        return ronda.cantidadTurnos();
    }

    public int cantidadMaximaDeJugadores(){
        return CANTIDAD_JUGADORES;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }


}
