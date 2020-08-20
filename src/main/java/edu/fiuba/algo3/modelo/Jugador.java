package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.preguntas.boosters.BoosterExclusividad;
import edu.fiuba.algo3.modelo.preguntas.boosters.BoosterMultiplicador;

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
        boosters = new ArrayList<>(Arrays.asList(new BoosterMultiplicador(2), new BoosterMultiplicador(3), new BoosterExclusividad(2), new BoosterExclusividad(2)));
    }

    public Jugador() {}

    public Boolean consumirBooster(Respuesta respuesta, Booster boosterRecibido){
        for (Booster booster: this.boosters){
            if( booster == boosterRecibido){
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

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public int getPuntaje() { return puntaje; }

    public Booster getBoosterMultiplicador(int factorDeMultiplicacion){
        for(Booster booster: this.boosters){
            if(!booster.esExclusivo() && booster.tieneFactor(factorDeMultiplicacion) ){
                return booster;
            }
        }
        return null;
    }

    public Booster getBoosterExclusividad() {
        for(Booster booster: this.boosters){
            if(booster.esExclusivo() ){
                return booster;
            }
        }
        return null;
    }

    public int getCantidadBoosterMultiplicadorDisponibles(int factorDeMultiplicacion){
        int i = 0;
        for(Booster booster: this.boosters){
            if(!booster.esExclusivo() && booster.tieneFactor(factorDeMultiplicacion) ){
                i++;
            }
        }
        return i;
    }

    public int getCantidadBoosterExclusividadDisponibles(){
        int i = 0;
        for(Booster booster: this.boosters){
            if(booster.esExclusivo()){
                i++;
            }
        }
        return i;
    }

    public Boolean tieneBoosterExclusividad(){
        return getCantidadBoosterExclusividadDisponibles() != 0;
    }

    public Boolean tieneBoosterMultiplicador(int factorDeMultiplicacion){
        return getCantidadBoosterMultiplicadorDisponibles(factorDeMultiplicacion) != 0;
    }

}
