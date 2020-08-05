package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.BoosterMultiplicador;
import edu.fiuba.algo3.modelo.BoosterExclusividad;

import java.util.ArrayList;


public class Pregunta{

    private String textoPregunta;
    private Puntaje puntaje;
    private Booster booster;
    private ArrayList<Opcion> opciones;

    public Pregunta(String textoPregunta, ArrayList<Opcion> opciones, Puntaje modoDePuntaje){
        this.textoPregunta = textoPregunta;
        this.puntaje = modoDePuntaje;
        this.opciones = opciones;
        this.booster = new BoosterMultiplicador(1);//2
    }

    public String getTextoPregunta(){
        return textoPregunta;
    }


    public ArrayList<Opcion> getOpciones(){
        return opciones;
    }

    public void asignarPuntajes(ArrayList<Respuesta> respuestasUsuarios){

        /*Boolean todosRespondieronBien = true;

        for (Respuesta respuesta: respuestasUsuarios){
            if (respuesta.esPerfecta()) {
                respuesta.getBooster().agregarBoost(this.booster);
                continue;
            }
            todosRespondieronBien = false;
        }

        if (todosRespondieronBien && this.booster.esExclusivo()) {this.booster = 0}*/

        for (Respuesta respuesta: respuestasUsuarios){
            puntaje.asignarPuntaje(respuesta);
        }

    }

   public void setBoost(Booster boosterRecibido) {
        boosterRecibido.agregarBoost(this.booster);
        booster = boosterRecibido;
    }

}