package edu.fiuba.algo3.modelo.preguntas.boosters;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class BoosterMultiplicador extends Booster{

    public BoosterMultiplicador(int factor){ this.factorDeMultiplicacion = factor; }

    @Override
    public Boolean esExclusivo(){
        return false;
    }

    @Override
    public void analizarRespuestas(ArrayList<Respuesta> respuestasUsuarios){

    }

    @Override
    public void aplicarBoost(Respuesta respuesta) {//deberia fijarse si se puede aplicar o no
        respuesta.setBoost(this);
    }


}