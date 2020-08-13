package edu.fiuba.algo3.modelo;

public class Valor {

    protected int valor;

    public Valor(Boolean esValorCorrecto) {
        if (esValorCorrecto) {
            valor = 1;
        } else {
            valor = 0;
        }
    }

    public Valor(int valorNumerico){
        valor = valorNumerico;
    }

    public Valor(Grupo grupo){
        valor = grupo.getNumero();
    }

    public int getValor(){
        return this.valor;
    }

    public Boolean esIgual(Valor valorAComparar){
        return this.valor == valorAComparar.getValor();
    }

    public Boolean debeSerMarcado(){
        return valor != 0;
    }

}
