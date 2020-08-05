package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class BoosterExclusividad extends Booster{

    public BoosterExclusividad(int factor){ this.factorDeMultiplicacion = factor; }

    @Override
    public Boolean esExclusivo(){
        return true;
    }

    @Override
    public void aplicarBoost(Respuesta respuesta) {//deberia fijarse si se puee aplicar o no
        respuesta.getPregunta().setBoost(this);
    }

}