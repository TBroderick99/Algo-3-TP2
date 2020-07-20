package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Partida {
    private static Partida INSTANCE = new Partida();
    private Jugador jugadorActual;
    private ArrayList<Pregunta> preguntas;

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

        this.preguntas = new ArrayList<Pregunta>();

    }

    public void agregarPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
    }

    public void siguienteTurno(){
        jugadorActual = jugadorActual.getOponente();
    }

    public String getNombreJugadorActual() {
        return jugadorActual.getNombre();
    }
}
