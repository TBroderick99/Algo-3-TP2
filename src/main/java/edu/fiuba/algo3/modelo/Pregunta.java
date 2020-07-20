package edu.fiuba.algo3.modelo;

public class Pregunta {
    private String texto;
    private boolean respuesta;

    public Pregunta(String textoPregunta, boolean respuesta){
        this. texto = textoPregunta;
        this. respuesta = respuesta;
    }

    public String getTexto(){
        return texto;
    }

    public boolean getRespuesta(){
        return respuesta;
    }
}
