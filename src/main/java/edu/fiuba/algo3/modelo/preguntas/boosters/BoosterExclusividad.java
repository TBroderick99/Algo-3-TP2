package edu.fiuba.algo3.modelo.preguntas.boosters;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class BoosterExclusividad extends Booster{

    public BoosterExclusividad(int factor){ this.factorDeMultiplicacion = factor; }

    @Override
    public Boolean esExclusivo(){
        return true;
    }

    @Override
    public void analizarRespuestas(ArrayList<Respuesta> respuestasUsuarios){
        Boolean todosRespondieronBien = true;

        for (Respuesta respuesta: respuestasUsuarios){
            if (respuesta.esPerfecta()) {
                respuesta.getBooster().agregarBoost(this);
                continue;
            }
            todosRespondieronBien = false;
        }

        if (todosRespondieronBien) {
            this.factorDeMultiplicacion = 0;
            for (Respuesta respuesta: respuestasUsuarios){
                respuesta.getBooster().agregarBoost(this);
            }
        }
    }

    @Override
    public void aplicarBoost(Respuesta respuesta) {//deberia fijarse si se puee aplicar o no
        respuesta.getPregunta().setBoost(this);
    }

}