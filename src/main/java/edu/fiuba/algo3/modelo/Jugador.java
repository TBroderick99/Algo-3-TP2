package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.JugadorNoTieneMasBoostersDisponiblesError;
import edu.fiuba.algo3.modelo.Excepciones.SeleccionNoEstaMarcadaError;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Arrays;

public class Jugador {
    private String nombre;
    private Jugador oponente;
    private int puntaje;
    private ArrayList<Booster> boosters;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
        boosters = new ArrayList<Booster>(Arrays.asList(new BoosterMultiplicador(2), new BoosterMultiplicador(3), new BoosterExclusividad(2), new BoosterExclusividad(2)));
    }

    public Boolean consumirMultiplicador(Respuesta respuesta, int factorMultiplicacion){
        for (Booster booster: boosters){
            if( !booster.esExclusivo() && booster.getFactor() == factorMultiplicacion){
                booster.aplicarBoost(respuesta);
                boosters.remove(booster);
                return true;
            }
        }
        return false;
    }


    public String getNombre() {
        return nombre;
    }

    public void sumarPuntos(int cantidadPuntos){
        puntaje += cantidadPuntos;
    }

    public int getPuntaje() { return puntaje; }
}
