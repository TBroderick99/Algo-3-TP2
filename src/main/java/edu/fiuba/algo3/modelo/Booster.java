package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Booster{

    protected int factorDeMultiplicacion;

    public int multiplicarPuntaje( int puntaje ) { return puntaje * factorDeMultiplicacion; }

    public void agregarBoost(Booster boosterAAgregar){ this.factorDeMultiplicacion *= boosterAAgregar.getFactor(); }

    public int getFactor(){ return factorDeMultiplicacion; }

    public Boolean tieneFactor(int factorDeMultiplicacion){
        return this.factorDeMultiplicacion == factorDeMultiplicacion;
    }

    public abstract Boolean esExclusivo();

    public abstract void analizarRespuestas(ArrayList<Respuesta> respuestasUsuarios);

    public abstract void aplicarBoost(Respuesta respuesta);


}