package edu.fiuba.algo3.modelo.opciones;

public abstract class Opcion {

    private String textoOpcion;

    public Opcion(String textoOpcion){
        this.textoOpcion = textoOpcion;
    }

    public String getTexto(){
        return textoOpcion;
    }

}
