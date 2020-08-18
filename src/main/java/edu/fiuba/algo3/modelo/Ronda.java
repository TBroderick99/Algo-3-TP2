package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Ronda {

    private ArrayList<Turno> turnos;
    private Iterator<Turno> iteradorTurnos;
    private Turno turnoActual;
    private int numeroRonda;

    private Pregunta preguntaActual;

    private ArrayList<Respuesta> respuestas;

    public Ronda() {
        numeroRonda = 0;
        turnos = new ArrayList<>();
        respuestas = new ArrayList<>();
    }

    public void agregarTurno(Jugador jugador) {
        Turno turno = new Turno(jugador);
        turnos.add(turno);
    }


    public void siguienteTurno() throws NoHaySiguienteTurnoError {

        if (iteradorTurnos.hasNext()) {
            turnoActual = iteradorTurnos.next();
            turnoActual.actualizar(preguntaActual); // aca esta el problema
        }
        else{
            throw new NoHaySiguienteTurnoError();
        }

        //notifyObservers();        TO DO:  hacer el notify para ronda
    }

    public void enviarRespuesta() {
        turnoActual.enviarRespuesta(this);
    }

    public Boolean esUltimoTurno(){
        if (!iteradorTurnos.hasNext()) {
            return true;
        }
        return false;

    }


    public void actualizar(Pregunta pregunta) {
        setPreguntaActual(pregunta);
        respuestas.clear();
        numeroRonda += 1;

        this.iteradorTurnos = this.turnos.iterator();    //lleva el iterador de turnos al inicio
        this.turnoActual = this.iteradorTurnos.next();
        this.turnoActual.actualizar(pregunta);
    }


    public void asignarPuntajes() {
        preguntaActual.asignarPuntajes(respuestas);
    }


    public void recibirRespuesta(Respuesta respuesta){
        respuestas.add(respuesta);
    }

    public void setPreguntaActual(Pregunta pregunta) {
        preguntaActual = pregunta;
    }


    public Pregunta getPreguntaActual() {
        return this.preguntaActual;
    }


    public Turno getTurnoActual(){
        return turnoActual;
    }


    public ArrayList<Turno> getTurnos(){
        return turnos;
    }


    public ArrayList<Respuesta> getRespuestas(){
        return respuestas;
    }


    public int getNumeroDeRonda(){
        return numeroRonda;
    }

    public ArrayList<Jugador> getJugadores() {
        return turnos.stream().map(Turno::getJugador).collect(Collectors.toCollection(ArrayList::new));
    }

    public int cantidadTurnos() {
        return turnos.size();
    }
}