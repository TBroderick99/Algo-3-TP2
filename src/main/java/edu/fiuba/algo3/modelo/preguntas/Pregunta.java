package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.preguntas.boosters.BoosterMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class Pregunta{

    private String textoPregunta;
    private Puntaje puntaje;
    private Booster booster;
    private ArrayList<Opcion> opciones;
    private String tipoPregunta;

    public Pregunta(String textoPregunta, ArrayList<Opcion> opciones, Puntaje modoDePuntaje, String tipoPregunta){
        this.textoPregunta = textoPregunta;
        this.puntaje = modoDePuntaje;
        this.opciones = opciones;
        this.booster = new BoosterMultiplicador(1);
        this.tipoPregunta = tipoPregunta;
    }

    public String getTextoPregunta(){
        return textoPregunta;
    }


    public ArrayList<Opcion> getOpciones(){
        return opciones;
    }

    public void asignarPuntajes(ArrayList<Respuesta> respuestasUsuarios){
        this.booster.analizarRespuestas(respuestasUsuarios);

        for (Respuesta respuesta: respuestasUsuarios){
            puntaje.asignarPuntaje(respuesta);
        }

    }

    public Booster getBooster() {
        return booster;
    }

    public void setBoost(Booster boosterRecibido) {
        boosterRecibido.agregarBoost(this.booster);
        booster = boosterRecibido;
    }

    public ArrayList<Grupo> getGrupos() {
        return new ArrayList<>();
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public String getTipoPuntaje(){
        return puntaje.getTipo();
    }
}