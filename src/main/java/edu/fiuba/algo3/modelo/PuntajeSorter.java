package edu.fiuba.algo3.modelo;

import java.util.Comparator;

public class PuntajeSorter implements Comparator<Jugador> {

    @Override
    public int compare(Jugador jugador1, Jugador jugador2) {
        return jugador2.getPuntaje() - jugador1.getPuntaje();
    }
}
