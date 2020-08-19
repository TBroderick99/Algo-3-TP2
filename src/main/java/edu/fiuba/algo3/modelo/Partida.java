package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteTurnoError;
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

    public Boolean esUltimoTurno() {
        return ronda.esUltimoTurno();
    }

    public void enviarRespuesta() {
        ronda.enviarRespuesta();
    }

    public void siguienteRonda() throws NoHaySiguienteRondaError {

        if(!manejadorDePreguntas.esLaUltimaPregunta()){
            manejadorDePreguntas.siguientePregunta();
            ronda.actualizar(getPreguntaActual());
        }
        else {
            throw new NoHaySiguienteRondaError();
        }
        notifyObservers();
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

    public int cantidadJugadoresAgregados() {
        return ronda.cantidadTurnos();
    }

    public int cantidadMaximaDeJugadores(){
        return CANTIDAD_JUGADORES;
    }
}
