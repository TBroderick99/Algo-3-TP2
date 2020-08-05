package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.Valor;

public  class Opcion {

    protected String textoOpcion;    //cambiar a private
    protected Valor valorCorrecto;

    public Opcion(String textoOpcion, Valor valor){
        this.textoOpcion = textoOpcion;
        this.valorCorrecto = valor;
    }

    public String getTexto(){
        return textoOpcion;
    }

    public Valor getValor(){
        return this.valorCorrecto;
    }

    public Boolean debeSerMarcada(){
        return valorCorrecto.debeSerMarcado();
    }

}
