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
    private ManejadorDePreguntas manejadorDePreguntas;

    private ArrayList<Jugador> jugadores;                 //sacar relacionado a jugadores, se encargan los turnos
    private Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;

    private ArrayList<Respuesta> respuestasRonda;         //cada turno tendria su respuesta

    private Estado estado = Estado.INICIO;

    private Partida(){
        this.ronda = new Ronda();
    }

/*    public static Partida getInstance(){
        return instance;
    }
*/
    public static synchronized Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    /*public void agregarJugadores(String nombreJugador1, String nombreJugador2){  //esta refactoreado abajo
        observers = new ArrayList<>();

        this.jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);


        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.iteradorJugadores = this.jugadores.iterator();
        this.jugadorActual = iteradorJugadores.next();

        this.respuestasRonda = new ArrayList<>();

        this.preguntas = inicializarPreguntas();
        this.iteradorPreguntas = this.preguntas.iterator();
        this.preguntaActual = iteradorPreguntas.next();
    }*/

    public void inicializarPartida(){                   //cuando los jugadores ya fueron agregados
        this.manejadorDePreguntas = new ManejadorDePreguntas();
        ronda.actualizar(getPreguntaActual());
        estado = Estado.JUGANDO;
    }

    public void agregarJugador(String nombre){
        Jugador jugador = new Jugador(nombre);
        ronda.agregarTurno(jugador);
    }

    private ArrayList<Pregunta> inicializarPreguntas() {
        return CreadorDePreguntas.crearPreguntas();
    }


    /*public void siguienteJugador(){                   // se deberia pasar de turno, el turno tiene el jugador
        if(iteradorJugadores.hasNext())
            jugadorActual = iteradorJugadores.next();
        notifyObservers();
    }*/

    public void siguienteTurno(){
        ronda.siguienteTurno();
    }



    /*public void siguienteRonda(){
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
    }*/


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

    public Jugador getJugadorActual(){                        //getter para que no rompa el controlador
        return ronda.getTurnoActual().getJugador();
    }

    public String getNombreJugadorActual(){                   //getter para que no rompa el controlador
        return ronda.getTurnoActual().getJugador().getNombre();
    }

    public Ronda getRonda(){
        return ronda;
    }

    public void guardarRespuesta(Respuesta respuesta){     //responsabilidad de la ronda
        respuestasRonda.add(respuesta);
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
