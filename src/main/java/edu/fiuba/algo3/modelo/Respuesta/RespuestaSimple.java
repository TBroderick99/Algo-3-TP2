package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaSimple implements IRespuesta{

    private String opcion;

    public RespuestaSimple() {}

    public RespuestaSimple(String opcion_) {
        this.opcion = opcion_;
    }

    @Override
    public ArrayList<Boolean> esCorrecta(IRespuesta respuesta) {
        /*TODO*/
        return null;
    }
}
