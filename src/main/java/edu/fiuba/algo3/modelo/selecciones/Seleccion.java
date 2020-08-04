package edu.fiuba.algo3.modelo.selecciones;

import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;

public class Seleccion {
    protected Boolean fueMarcada;
    protected Valor valorMarcado;
    protected Opcion opcion;
    private static int cantidadDeSeleccionadas = 0;   //TO DO: Quizas que la respuesta sepa cuantas seleccionadas hay tenga mas sentido.


    public Seleccion(Opcion unaOpcion){
        opcion = unaOpcion;
        fueMarcada = false;
    }

    public Boolean esCorrecta(){
        return valorMarcado.esIgual(opcion.getValor());
    }

    public Boolean fueMarcada(){
        return fueMarcada;
    }

    public void marcar(Valor valorAMarcar){
        fueMarcada = true;
        this.asignarValor(valorAMarcar);
        cantidadDeSeleccionadas += 1;
    }

    public void desmarcar(){
        fueMarcada = false;
        cantidadDeSeleccionadas -= 1;
    }


    public void asignarValor(Valor valorAMarcar){
        this.valorMarcado = valorAMarcar;
    }

    public Opcion getOpcion(){
        return opcion;
    }


    public static int getCantidadDeSeleccionadas(){
        return cantidadDeSeleccionadas;
    }

    public Boolean debeSerMarcada(){
        return opcion.debeSerMarcada();
    }

}
