package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public abstract class Booster{

    protected int factorDeMultiplicacion;

    public int multiplicarPuntaje( int puntaje ) { return puntaje * factorDeMultiplicacion; }

    public void agregarBoost(Booster boosterAAgregar){ this.factorDeMultiplicacion *= boosterAAgregar.getFactor(); }

    public int getFactor(){ return factorDeMultiplicacion; }

    public abstract Boolean esExclusivo();

    public abstract void aplicarBoost(Respuesta respuesta);

}