package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private Jugador oponente;
    private int puntaje;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
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
        puntaje += cantidadPuntos;
    }

    public int getPuntaje() { return puntaje; }
}
