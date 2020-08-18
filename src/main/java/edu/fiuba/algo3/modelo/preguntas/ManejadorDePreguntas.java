package edu.fiuba.algo3.modelo.preguntas;

import java.util.ArrayList;
import java.util.Iterator;

public class ManejadorDePreguntas {
    public ArrayList<Pregunta> preguntas;
    private Iterator<Pregunta> iteradorPreguntas;
    private Pregunta preguntaActual;
    private int numeroPregunta = 0;


    public ManejadorDePreguntas(ArrayList<Pregunta> preguntas){
        this.preguntas = preguntas;
        this.iteradorPreguntas = this.preguntas.iterator();
        siguientePregunta();
    }

    public Pregunta getPreguntaActual(){
        return this.preguntaActual;
    }

    public boolean esLaUltimaPregunta() {
        return !iteradorPreguntas.hasNext();
    }



    public void siguientePregunta() {
        this.preguntaActual = iteradorPreguntas.next();
        this.numeroPregunta += 1;
    }

    public int getNumeroPregunta(){
        return this.numeroPregunta;
    }

    public int getCantidadPreguntas(){
        return preguntas.size();
    }
}
