package edu.fiuba.algo3.modelo.Respuesta;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class Respuesta {

    protected ArrayList<Seleccion> selecciones;
    protected Jugador jugadorAsociado;


    public Respuesta(Jugador jugadorAAsociar, Pregunta pregunta){  //tambien la pregunta podria crear la respuesta
        selecciones = new ArrayList<Seleccion>();
        this.jugadorAsociado = jugadorAAsociar;

        for(Opcion opcion: pregunta.getOpciones()){
            this.agregarSeleccion(opcion);
        }
    }

    public Respuesta(Jugador jugadorAsociado){    //Creada solamente para test Modos de puntaje
        selecciones = new ArrayList<Seleccion>();
        this.jugadorAsociado = jugadorAsociado;
    }


    public void marcar(Opcion opcion, Valor valorAMarcar){
        Seleccion seleccion = getSeleccion(opcion);

        seleccion.marcar(valorAMarcar);
    }

    public void desmarcar(Opcion opcion){
        Seleccion seleccion = getSeleccion(opcion);
        seleccion.desmarcar();
    }

    public ArrayList<Seleccion> getSelecciones(){
        return selecciones;
    }

    public Jugador getJugador(){
        return jugadorAsociado;
    }

    public void agregarSeleccion(Opcion opcion){
        Seleccion nuevaSeleccion = new Seleccion(opcion);
        selecciones.add(nuevaSeleccion);

    }

    private Seleccion getSeleccion(Opcion opcion){   //nunca deberia devolver null, testear postcondicion

        for(Seleccion seleccion: selecciones){

            if(seleccion.getOpcion() == opcion){
                return seleccion;
            }
        }

        return null;
    }

}