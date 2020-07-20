package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaGrupal{

    private ArrayList<String> opcionA;
    private ArrayList<String> opcionB;

    public RespuestaGrupal() {}

    public RespuestaGrupal(ArrayList<String> opcionA_, ArrayList<String> opcionB_) {
        this.opcionA = opcionA_;
        this.opcionB = opcionB_;
    }

    public ArrayList<String> getOpcionA() {
        return this.opcionA;
    }

    public ArrayList<String> getOpcionB() {
        return this.opcionB;
    }

    //@Override
    public ArrayList<Boolean> esCorrecta(IRespuesta respuesta) {
        /*TODO*/
        return null;
    }
}
