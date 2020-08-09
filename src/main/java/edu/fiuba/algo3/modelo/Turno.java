package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Turno {

    private int tiempo; //cambiar int
    private Jugador jugador;
    private Respuesta respuesta;


    public void actualizar(){
        Respuesta respuesta = new Respuesta(jugador);
        //renovar el timer
    }


    public Turno(Jugador jugador){
        this.jugador = jugador;
        //TO DO: inicializar el tiempo;
    }


    public Respuesta getRespuesta(){
        return respuesta;
    }

}
