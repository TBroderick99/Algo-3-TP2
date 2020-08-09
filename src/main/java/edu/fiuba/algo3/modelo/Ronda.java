package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Iterator;

public class Ronda {

    private ArrayList<Turno> turnos;
    private Iterator<Turno> iteradorTurnos;
    private Turno turnoActual;
    private int numeroRonda;

    private Pregunta preguntaActual;

    private ArrayList<Respuesta> respuestas;

    public Ronda(){
        numeroRonda = 0;
        turnos = new ArrayList<Turno>();
        respuestas = new ArrayList<Respuesta>();
    }

    public void agregarTurno(Jugador jugador){
        Turno turno = new Turno(jugador);
        turnos.add(turno);
    }


    public void siguienteTurno(){
        respuestas.add(turnoActual.getRespuesta());

        if(iteradorTurnos.hasNext()) {
            turnoActual = iteradorTurnos.next();
            turnoActual.actualizar(preguntaActual);
        }
        //notifyObservers();        TO DO:  hacer el notify para ronda
    }

    public void actualizar(Pregunta pregunta){
        setPreguntaActual(pregunta);                //siguientePregunta
        this.numeroRonda += 1;                      //pasar numero de ronda
        this.iteradorTurnos = this.turnos.iterator();    //actualizar iterador de turnos
        this.turnoActual = this.iteradorTurnos.next();
    }

    public void asignarPuntajes(){
        preguntaActual.asignarPuntajes(respuestas);
    }

    public void setPreguntaActual(Pregunta pregunta){
        preguntaActual = pregunta;
    }



    public Pregunta getPreguntaActual() {
        return this.preguntaActual;
    }

}