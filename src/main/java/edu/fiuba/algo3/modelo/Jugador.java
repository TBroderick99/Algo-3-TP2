package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private Jugador oponente;
    private int puntos;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public void setOponente(Jugador oponente) {
        this.oponente = oponente;
    }

    public Jugador getOponente() {
        return oponente;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarPuntos(int cantidadPuntos){
        puntos += cantidadPuntos;
    }
}
