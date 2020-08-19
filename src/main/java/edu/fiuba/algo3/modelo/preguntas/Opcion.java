package edu.fiuba.algo3.modelo.preguntas;

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

    public boolean equals(Opcion opcion){
        return opcion.tieneTexto(textoOpcion); //&& opcion.tieneValor(this.valorCorrecto);
    }

    private boolean tieneValor(Valor valorCorrecto) {
        return valorCorrecto.esIgual(this.valorCorrecto);
    }

    private boolean tieneTexto(String textoOpcion) {
        return textoOpcion.equals(this.textoOpcion);
    }

}
