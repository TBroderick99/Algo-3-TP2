package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaSimple{

    private String opcion;

    public RespuestaSimple() {}

    public RespuestaSimple(String opcion_) {
        this.opcion = opcion_;
    }

    public String getOpcion() {
        return this.opcion;
    }

    //@Override
    public ArrayList<Boolean> esCorrecta(String respuesta) {
        ArrayList<Boolean> returnValue = new ArrayList<>();
        returnValue.add(respuesta.equals(this.opcion));
        return returnValue;
    }
}
