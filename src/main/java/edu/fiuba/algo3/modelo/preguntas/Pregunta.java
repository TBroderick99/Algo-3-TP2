package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;


public class Pregunta{

    protected String textoPregunta;
    protected Puntaje puntaje;
    protected ArrayList<Opcion> opciones;

    public Pregunta(String textoPregunta, ArrayList<Opcion> opciones, Puntaje modoDePuntaje){
        this.textoPregunta = textoPregunta;
        this.puntaje = modoDePuntaje;
        this.opciones = opciones;
    }

    public String getTextoPregunta(){
        return textoPregunta;
    }


    public ArrayList<Opcion> getOpciones(){
        return opciones;
    }

    public void asignarPuntajes(ArrayList<Respuesta> respuestasUsuarios){

        for (Respuesta respuesta: respuestasUsuarios){
            puntaje.asignarPuntaje(respuesta);
        }

   }

}