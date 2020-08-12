package edu.fiuba.algo3.modelo.selecciones;

import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.Excepciones.SeleccionNoEstaMarcadaError;
import edu.fiuba.algo3.modelo.opciones.Opcion;

public class Seleccion {
    protected Boolean fueMarcada;
    protected Valor valorMarcado;
    protected Opcion opcion;


    public Seleccion(Opcion unaOpcion){
        opcion = unaOpcion;
        fueMarcada = false;
    }

    public Boolean esCorrecta(){
        if (!fueMarcada){ throw new SeleccionNoEstaMarcadaError(); }
        return valorMarcado.esIgual(opcion.getValor());
    }

    public Boolean fueMarcada(){
        return fueMarcada;
    }

    public void marcar(Valor valorAMarcar){
        fueMarcada = true;
        this.asignarValor(valorAMarcar);
    }

    public void desmarcar(){
        fueMarcada = false;
    }

    public Valor getValor(){ return this.valorMarcado; }


    public void asignarValor(Valor valorAMarcar){
        this.valorMarcado = valorAMarcar;
    }

    public Opcion getOpcion(){
        return opcion;
    }


    public Boolean debeSerMarcada(){
        return opcion.debeSerMarcada();
    }

}
